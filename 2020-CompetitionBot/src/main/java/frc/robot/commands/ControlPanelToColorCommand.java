package frc.robot.commands;

import frc.robot.subsystems.ColorSensorSubsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;

/**
 * A prototype command that turns the color wheel to the target color.
 */
public class ControlPanelToColorCommand extends CommandBase {
  
  private final ColorSensorSubsystem colorSensor;

  private boolean isFinished;

  /**
   * Creates a new ControlPanelToColorCommand.
   *
   * @param colorSensor The color sensors used by this command.
   */
  public ControlPanelToColorCommand(ColorSensorSubsystem colorSensor) {
    this.colorSensor = colorSensor;
    this.addRequirements(this.colorSensor);
  }

  @Override
  public void initialize() {
    // Start the motors
  }

  @Override
  public void execute() {
    int target = this.colorSensor.getTargetColor();

    if (!this.isFinished) {
      this.isFinished = this.colorSensor.getLeftColor() == target
       && this.colorSensor.getRightColor() == target;
    }
  }

  @Override
  public void end(boolean interrupted) {
    // Stop the motors
  }

  @Override
  public boolean isFinished() {
    return this.isFinished;
  }
}
