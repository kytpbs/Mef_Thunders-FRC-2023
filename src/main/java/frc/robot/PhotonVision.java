package frc.robot;
import org.photonvision.targeting.PhotonTrackedTarget;
import org.photonvision.PhotonUtils;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.math.util.Units;

import static frc.robot.Constants.driveTrain;
import static frc.robot.Constants.camera;
import static frc.robot.Constants.fowardController;
import static frc.robot.Constants.turnController;

import static frc.robot.Constants.photonvision.CAMERA_HEIGHT_METERS;
import static frc.robot.Constants.photonvision.CAMERA_PITCH_RADIANS;
import static frc.robot.Constants.photonvision.TARGET_HEIGHT_METERS;


public class PhotonVision {
    static double rotation_Speed;
    static double forward_Speed;

    public static void Auto(Integer wanted_meter_diffrence, double max_rotation_speed, double max_foward_speed) {
        rotation_Speed = Yaw_Correction();
        forward_Speed = Area_Correction(wanted_meter_diffrence);

        driveTrain.arcadeDrive(forward_Speed*max_foward_speed, rotation_Speed*max_foward_speed);
    }
    
    public static void Dashboard() {
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
        }
    }
    
    public static Double Yaw_Correction() {
        var result = camera.getLatestResult();
        boolean hasTargets = result.hasTargets();
        if (hasTargets) {
            PhotonTrackedTarget target = result.getBestTarget();
            double yaw = target.getYaw();
            rotation_Speed = -turnController.calculate(yaw,0);
            return rotation_Speed;
        }
        else {
            return 0.0;
        }
    }

    public static Double Area_Correction(int goal) {
        var result = camera.getLatestResult();
        boolean hasTargets = result.hasTargets();
        if (hasTargets) {
            PhotonTrackedTarget target = result.getBestTarget();
            double area = target.getArea();
            double range = PhotonUtils.calculateDistanceToTargetMeters(
                                    CAMERA_HEIGHT_METERS,
                                    TARGET_HEIGHT_METERS,
                                    CAMERA_PITCH_RADIANS,
                                    Units.degreesToRadians(area));
            forward_Speed = fowardController.calculate(range, goal);
            return forward_Speed;
        }
        else {
            return 0.0;
        }
    }
}
