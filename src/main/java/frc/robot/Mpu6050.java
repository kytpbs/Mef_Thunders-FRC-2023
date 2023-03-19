package frc.robot;

import edu.wpi.first.wpilibj.I2C;

public class Mpu6050 {
    private static final int power_mgmt_1 = 0x6b;
    private static final int power_mgmt_2 = 0x6c;
    private static final int mpu6050_Adress = 0x68;

    private static final int gyro_x_out = 0x43;
    private static final int gyro_y_out = 0x45;
    private static final int gyro_z_out = 0x47;

    private static final int accel_x_out = 0x3b;
    private static final int accel_y_out = 0x3d;
    private static final int accel_z_out = 0x3f;

    public static final I2C mpu6050 = new I2C(I2C.Port.kOnboard, mpu6050_Adress);

    public void init() {
        mpu6050.write(power_mgmt_1, 0);
    }

    public void Accoleremeter_read() {
        byte[] data = new byte[6];
        mpu6050.read(0x3b, 6, data);
        int x = (data[0] << 8) + data[1];
        int y = (data[2] << 8) + data[3];
        int z = (data[4] << 8) + data[5];
        System.out.println("x: " + x + " y: " + y + " z: " + z);
    }

    public Integer Gyro_x() {
        int x = read(gyro_x_out);
        return x/131;
    }
    public Integer Gyro_y() {
        int y = read(gyro_y_out);
        return y/131;
    }
    public Integer Gyro_z() {
        int z = read(gyro_z_out);
        return z/131;
    }

    public double Accel_x() {
        int x = read(accel_x_out);
        return x/16384.0;
    }
    public double Accel_y() {
        int y = read(accel_y_out);
        return y/16384.0;
    }
    public double Accel_z() {
        int z = read(accel_z_out);
        return z/16384.0;
    }

    public Integer read(int adress) {
        byte[] data = new byte[2];
        mpu6050.read(adress, 2, data);
        int x = (data[0] << 8) + data[1];
        return x;
    }
}
