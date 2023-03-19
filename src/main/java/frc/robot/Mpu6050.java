package frc.robot;

import edu.wpi.first.wpilibj.I2C;

public class Mpu6050 {
    private static final int power_mgmt_1 = 0x6b;
    private static final int mpu6050_Adress = 0x68;

    private static final int gyro_x_out = 0x43;
    private static final int gyro_y_out = 0x45;
    private static final int gyro_z_out = 0x47;

    private static final int accel_x_out = 0x3b;
    private static final int accel_y_out = 0x3d;
    private static final int accel_z_out = 0x3f;

    public static final I2C mpu6050 = new I2C(I2C.Port.kOnboard, mpu6050_Adress);


    /**
     * Disables sleep mode on the mpu6050
     */
    public void init() {
        mpu6050.write(power_mgmt_1, 0);
    }
    /**
     * Reads a 2 byte value from the mpu6050
     * @param adress The adress to read from
     * @return The value read
     */
    public Integer read(int adress) {
        byte[] data = new byte[2];
        mpu6050.read(adress, 2, data);
        int x = (data[0] << 8) + data[1];
        return x;
    }
    
    /**
     * Calculates the distance between two points
     * @param x The x value
     * @param y The y value
     * @return The distance between the two points
     */
    public Double dist(Double x, Double y) {
        return Math.sqrt(x*x + y*y);
    }

    public Integer get_Gyro_x() {
        int x = read(gyro_x_out);
        return x/131;
    }
    
    public Integer get_Gyro_y() {
        int y = read(gyro_y_out);
        return y/131;
    }
    
    public Integer get_Gyro_z() {
        int z = read(gyro_z_out);
        return z/131;
    }

    /**
     * Calculates the rotation of the robot on the x axis in terms of degrees
     * @return The rotation of the robot on the x axis
     */
    public Double get_x_Rotation() {
        double x = get_Gyro_x();
        double y = get_Gyro_y();
        double z = get_Gyro_z();
        double radians = Math.atan2(x, dist(y,z));
        return -Math.toDegrees(radians);
    }
    /**
     * Calculates the rotation of the robot on the y axis in terms of degrees
     * @return The rotation of the robot on the y axis
     */
    public Double get_y_Rotation() {
        double x = get_Gyro_x();
        double y = get_Gyro_y();
        double z = get_Gyro_z();
        double radians = Math.atan2(y, dist(x,z));
        return Math.toDegrees(radians);
    }


    public double get_Accel_x() {
        int x = read(accel_x_out);
        return x/16384.0;
    }
    
    public double get_Accel_y() {
        int y = read(accel_y_out);
        return y/16384.0;
    }
    
    public double get_Accel_z() {
        int z = read(accel_z_out);
        return z/16384.0;
    }
}
