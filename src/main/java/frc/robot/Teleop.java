package frc.robot;
import static frc.robot.Constants.driveTrain;
import static frc.robot.Constants.stick;

public class Teleop {
    public void drive() {
        driveTrain.arcadeDrive(stick.getY(), stick.getZ(),true);
    }
    public void buttons() {
      if (stick.getRawButtonPressed(1)) {
        Buttons.button1.pressed();
      }
      if (stick.getRawButtonReleased(1)) {
        Buttons.button1.relased();
      }
      if (stick.getRawButtonPressed(2)) {
        Buttons.button2.pressed();
      }
      if (stick.getRawButtonReleased(2)) {
        Buttons.button2.relased();
      }
      if (stick.getRawButtonPressed(3)) {
        Buttons.button3.pressed();
      }
      if (stick.getRawButtonReleased(3)) {
        Buttons.button3.relased();
      }
      if (stick.getRawButtonPressed(4)) {
        Buttons.button4.pressed();
      }
      if (stick.getRawButtonReleased(4)) {
        Buttons.button4.relased();
      }
    }

  private static class Buttons {
    static class button1 {
      public static void pressed() {
        
      }
      public static void relased() {

      }
      }
    static class button2 {
      public static void pressed() {

      }
      public static void relased() {

      }
    }

    static class button3 {
      public static void pressed() {

      }
      public static void relased() {

      }
    }
    static class button4 {
      public static void pressed() {
        
      }
      public static void relased() {
        
      }
    }
  }
}
