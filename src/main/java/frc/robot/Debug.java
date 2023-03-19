package frc.robot;
import static frc.robot.Constants.accelerometer;
import static frc.robot.Constants.camera;
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
        var result = camera.getLatestResult();
        boolean hasTargets = result.hasTargets();
        SmartDashboard.putBoolean("Target Detected: ", hasTargets);
        if (hasTargets) {
            PhotonTrackedTarget target = result.getBestTarget();
            double yaw = target.getYaw();
            double pitch = target.getPitch();
            double area = target.getArea();
            double skew = target.getSkew();
            SmartDashboard.putNumber("Yaw: ", yaw);
            SmartDashboard.putNumber("Pitch: ", pitch);
            SmartDashboard.putNumber("Area: ", area);
            SmartDashboard.putNumber("Skew: ", skew);
            SmartDashboard.updateValues();
        }
    }
}