package frc.robot;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import static frc.robot.Constants.timer;
import static frc.robot.Constants.driveTrain;
import static frc.robot.Constants.accelerometer;

public class Autonomous {
    public void Timed() {
        double time = SmartDashboard.getNumber("Time ", 0.0);
        Autonomus_utils.drive.meter_drive(time, false); 
    }
    public void Gyro() {
        
    }
    public void Camera() {
        PhotonVision.Auto();
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
