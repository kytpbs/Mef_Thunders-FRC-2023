package frc.robot;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import static frc.robot.Constants.timer;
import static frc.robot.Constants.driveTrain;
import static frc.robot.Constants.accelerometer;

public class Autonomous {
    public void init() {
        driveTrain.setSafetyEnabled(false);
        SmartDashboard.putNumber("Time ", 0.01);
        SmartDashboard.putNumber("Movement Speed", 0.4);
        SmartDashboard.putNumber("Rotation Speed", 0.4);
        SmartDashboard.putNumber("Wanted Area", 10);
    }
    public void Timed() {
        Autonomus_utils.drive.meter_drive(time, false); 
    }
    public void Gyro() {
        
    }
    public void Camera() {
        Double speed = SmartDashboard.getNumber("Movement Speed", 0.4);
        Double Rotation_Speed = SmartDashboard.getNumber("Rotation Speed", 0.4);
        Integer Wanted_Area_Percantage = (int)SmartDashboard.getNumber("Wanted Area", 10);
        PhotonVision.Auto(speed, Rotation_Speed, Wanted_Area_Percantage);
    }
    public void Stabilize() {
        double y_accel = accelerometer.getY();
        driveTrain.arcadeDrive(y_accel*100,0);
    }
    private static class Autonomus_utils {
        private static class drive {
            private static void meter_drive(Double x, Boolean meter) {
                timer.start();
                timer.reset();
                double time = x;
                if (meter) {
                    time = calculate_distance_to_time(x);
                }
                while (timer.get() < time){
                    driveTrain.arcadeDrive(0.4,0);
                }
                driveTrain.stopMotor();
                timer.stop();
            }
            /* 
            TODO: Create the algorithm(requires extensive data...) 
            */
            private static Double calculate_distance_to_time(Double x) {
                return x;
            }
        }
    }
}
