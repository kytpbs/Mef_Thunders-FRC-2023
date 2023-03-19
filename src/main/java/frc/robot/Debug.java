package frc.robot;
import static frc.robot.Constants.accelerometer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public  class Debug {
    public static void acceloremeter() {
        double y_accel = accelerometer.getY();
        double x_accel = accelerometer.getX();
        SmartDashboard.putNumber("Y Accel: ", y_accel);
        SmartDashboard.putNumber("x Accel: ", x_accel);
        SmartDashboard.updateValues();
    }
    public static void PhotonVison() {
        PhotonVision.Dashboard();
    }
}