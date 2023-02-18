package frc.robot;
import org.photonvision.targeting.PhotonPipelineResult;
import org.photonvision.targeting.PhotonTrackedTarget;
import static frc.robot.Constants.driveTrain;
import static frc.robot.Constants.camera;

public class PhotonVision {
    public static PhotonPipelineResult cam() {
        var result = camera.getLatestResult();
        return result;
    }
    public static void Auto() {
        var result = PhotonVision.cam();
        boolean hasTargets = result.hasTargets();
        if (hasTargets) {
            PhotonTrackedTarget target = result.getBestTarget();
            double yaw = target.getYaw();
            double pitch = target.getPitch();
            double area = target.getArea();
            double skew = target.getSkew();
        }
    }
}
