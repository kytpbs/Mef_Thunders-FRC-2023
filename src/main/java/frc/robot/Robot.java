// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import static frc.robot.Constants.Automonus;
import static frc.robot.Constants.kCameraAuto;
import static frc.robot.Constants.kGyroAuto;
import static frc.robot.Constants.kTimedAuto;
import static frc.robot.Constants.kStabilize;
import static frc.robot.Constants.teleop;
import static frc.robot.Constants.rightMotorsGroup;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.net.PortForwarder;
import edu.wpi.first.wpilibj.Timer;
/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  Timer timer = new Timer();
  private String m_autoSelected;
  private final SendableChooser<String> m_chooser = new SendableChooser<>();
  private double temp = 0.1;

  @Override
  public void robotInit() {
    Automonus.init();
    rightMotorsGroup.setInverted(true);
    PortForwarder.add(5800, "photonvision.local", 5800);
    Gyro.init();
    timer.reset();
    timer.start();
    SmartDashboard.putNumber("Linear_P", 0.1);
    SmartDashboard.putNumber("Linear_D", 0.0);
    m_chooser.setDefaultOption("Timer Auto", kTimedAuto);
    m_chooser.addOption("Gyro Auto", kGyroAuto);
    m_chooser.addOption("Camera Auto", kCameraAuto);
    m_chooser.addOption("Stabilize Auto", kStabilize);
    SmartDashboard.putData("Auto choices", m_chooser);
  }

  @Override
  public void robotPeriodic() {
    Debug.acceloremeter();
    Debug.PhotonVison();
    if (timer.get() - temp >= 0.5) {
      Gyro.Gyro_dashboard();
      temp = timer.get();
    }
  }

  @Override
  public void autonomousInit() {
    m_autoSelected = m_chooser.getSelected();
    SmartDashboard.updateValues();
    // m_autoSelected = SmartDashboard.getString("Auto Selector", kDefaultAuto);
    System.out.println("Auto selected: " + m_autoSelected);
  }

  /** This function is called periodically during autonomous. */
  @Override
  public void autonomousPeriodic() {
    switch (m_autoSelected) {
      case kGyroAuto:
        Automonus.Gyro();
        break;
      case kCameraAuto:
        Automonus.Camera();
        break;
      case kStabilize:
        Automonus.Stabilize();
        break;
      case kTimedAuto:
      default:
        Automonus.Timed();
        break;
    }
  }

  /** This function is called once when teleop is enabled. */
  @Override
  public void teleopInit() {
    teleop.init();
  }

  /** This function is called periodically during operator control. */
  @Override
  public void teleopPeriodic() {
    teleop.drive();
    teleop.buttons();
  }

  /** This function is called once when the robot is disabled. */
  @Override
  public void disabledInit() {}

  /** This function is called periodically when disabled. */
  @Override
  public void disabledPeriodic() {}

  /** This function is called once when test mode is enabled. */
  @Override
  public void testInit() {}

  /** This function is called periodically during test mode. */
  @Override
  public void testPeriodic() {}

  /** This function is called once when the robot is first started up. */
  @Override
  public void simulationInit() {}

  /** This function is called periodically whilst in simulation. */
  @Override
  public void simulationPeriodic() {}
}
