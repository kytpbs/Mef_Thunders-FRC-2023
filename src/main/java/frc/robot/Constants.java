package frc.robot;

import edu.wpi.first.wpilibj.BuiltInAccelerometer;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.interfaces.Accelerometer;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;
import org.photonvision.PhotonCamera;
import edu.wpi.first.wpilibj.Timer;

public final class Constants{
    public static PWMSparkMax leftMotor1 = new PWMSparkMax(0);
    public static PWMSparkMax leftMotor2 = new PWMSparkMax(1);
    public static PWMSparkMax rightMotor1 = new PWMSparkMax(2);
    public static PWMSparkMax rightMotor2 = new PWMSparkMax(3);
    public static MotorControllerGroup rightMotorsGroup = new MotorControllerGroup(rightMotor1,rightMotor2);
    public static MotorControllerGroup leftMotorsGroup  = new MotorControllerGroup(leftMotor1, leftMotor2);
    public static DifferentialDrive driveTrain = new DifferentialDrive(leftMotorsGroup,rightMotorsGroup);

    public static Joystick stick = new Joystick(0);

    public static Accelerometer accelerometer = new BuiltInAccelerometer();

    public static final String kTimedAuto = "Timer Auto";
    public static final String kGyroAuto = "Gyro Auto";
    public static final String kCameraAuto = "Camera Auto";
    public static final String kStabilize = "Stabilize Auto";
    public static double x_default_double[] = new double[1280]; 
    public static double y_default_double[] = new double[720]; 
    public static double z = 0;
    public static Autonomous Automonus = new Autonomous();
    public static Teleop teleop = new Teleop();
    public static Timer timer = new Timer();
    public static PhotonCamera camera = new PhotonCamera("Picam");
}