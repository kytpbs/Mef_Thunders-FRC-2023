package frc.robot;
import org.photonvision.targeting.PhotonPipelineResult;
import org.photonvision.targeting.PhotonTrackedTarget;
import static frc.robot.Constants.driveTrain;
import static frc.robot.Constants.camera;

public class PhotonVision {
    public static void Auto() {
        var result = camera.getLatestResult();
        boolean hasTargets = result.hasTargets();
        if (hasTargets) {
            PhotonTrackedTarget target = result.getBestTarget();
            double yaw = target.getYaw();
            double pitch = target.getPitch();
            double area = target.getArea();
            double skew = target.getSkew();
        }
    }
    public static void Yaw_Correction(Double Rotation_Speed) {
        var result = camera.getLatestResult();
        boolean hasTargets = result.hasTargets();
        if (hasTargets) {
            PhotonTrackedTarget target = result.getBestTarget();
            double yaw = target.getYaw();
            if (yaw > 0) {
                driveTrain.arcadeDrive(0, -Rotation_Speed);
            } else if (yaw < 0) {
                driveTrain.arcadeDrive(0, Rotation_Speed);
            } else {
                driveTrain.arcadeDrive(0, 0);
            }
        }
    }
    /** This is the area correction method Using The Camera. 
     * @param speed The speed of the robot.
     * @warn This method does yaw correction as well.
     * @warn Be sure to Have the camera set up right so that it doesn't get random targets.
     * @param Rotation_Speed The speed of the rotation.
     */
    public static void Area_Correction(Double speed, Double Rotation_Speed) {
        Yaw_Correction(Rotation_Speed);
        var result = camera.getLatestResult();
        boolean hasTargets = result.hasTargets();
        if (hasTargets) {
            PhotonTrackedTarget target = result.getBestTarget();
            double yaw = target.getYaw();
            double area = target.getArea();
            if (area > 20) {
                driveTrain.arcadeDrive(speed, 0);
            } 
            else if (area < 20) {
                driveTrain.arcadeDrive(-speed, 0);
            } 
            else {
                driveTrain.arcadeDrive(0, 0);
            }
        }
    }
}
