package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

/**
 * A subsystem that controls the color sensors.
 */
public class ColorSensorSubsystem extends SubsystemBase {

  private int targetColor;
  
  public ColorSensorSubsystem() {
    throw new UnsupportedOperationException();
  }

  @Override
  public void periodic() {
    throw new UnsupportedOperationException();
  }

  public int getTargetColor() {
    return this.targetColor;
  }

  public void setTargetColor(int targetColor) {
    this.targetColor = targetColor;
  }

  public int getLeftColor() {
      throw new UnsupportedOperationException();
  }

  public int getRightColor() {
      throw new UnsupportedOperationException();
  }
}
