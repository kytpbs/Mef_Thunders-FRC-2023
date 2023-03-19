package frc.robot;

public class Gyro {
    private static Mpu6050 mpu6050 = new Mpu6050();
    public static void init() {
        mpu6050.init();
    }
    
}
