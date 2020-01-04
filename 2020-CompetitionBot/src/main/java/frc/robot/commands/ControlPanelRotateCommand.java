package frc.robot.commands;

import frc.robot.subsystems.ColorSensorSubsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;

/**
 * A prototype command that turns the color wheel to the target color.
 */
public class ControlPanelRotateCommand extends CommandBase {
  
  private final ColorSensorSubsystem colorSensor;

  /**
   * Creates a new ControlPanelToColorCommand.
   *
   * @param colorSensor The color sensors used by this command.
   */
  public ControlPanelRotateCommand(ColorSensorSubsystem colorSensor) {
	this.colorSensor = colorSensor;
	
    this.addRequirements(this.colorSensor);
  }

  @Override
  public void initialize() {
    // Start the motors
  }

  @Override
  public void execute() {
	throw new UnsupportedOperationException();
  }

  @Override
  public void end(boolean interrupted) {
    // Stop the motors
  }

  @Override
  public boolean isFinished() {
    throw new UnsupportedOperationException();
  }
}
