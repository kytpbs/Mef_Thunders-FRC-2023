package frc.robot;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;



public class Gyro {
    private static Mpu6050 mpu6050 = new Mpu6050();
    public static void init() {
        mpu6050.init();
    }
    public static void Gyro_dashboard() {
        SmartDashboard.putNumber("Gyro X", mpu6050.get_Gyro_x());
        SmartDashboard.putNumber("Gyro Y", mpu6050.get_Gyro_y());
        SmartDashboard.putNumber("Gyro Z", mpu6050.get_Gyro_z());
        SmartDashboard.putNumber("Gyro X Rotation", mpu6050.get_x_Rotation());
        SmartDashboard.putNumber("Gyro Y Rotation", mpu6050.get_y_Rotation());
        SmartDashboard.putNumber("mpu6050 X accel:", mpu6050.get_Accel_x());
        SmartDashboard.putNumber("mpu6050 y accel:", mpu6050.get_Accel_y());
        SmartDashboard.putNumber("mpu6050 z accel:", mpu6050.get_Accel_z());
    }
}
