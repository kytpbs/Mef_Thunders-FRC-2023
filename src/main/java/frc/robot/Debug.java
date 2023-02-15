package frc.robot;
import static frc.robot.Constants.accelerometer;
import org.photonvision.targeting.PhotonTrackedTarget;
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
        var result = PhotonVision.cam();
        PhotonTrackedTarget target = result.getBestTarget();
        boolean hasTargets = result.hasTargets();
        double yaw = target.getYaw();
        double pitch = target.getPitch();
        double area = target.getArea();
        double skew = target.getSkew();
        System.out.println(result);
        SmartDashboard.putBoolean("Target Detected: ", hasTargets);
        if (hasTargets) {
            SmartDashboard.putNumber("Yaw: ", yaw);
            SmartDashboard.putNumber("Pitch: ", pitch);
            SmartDashboard.putNumber("Area: ", area);
            SmartDashboard.putNumber("Skew: ", skew);
        }
    }
    private static class Debug_utils{
        
    }
}