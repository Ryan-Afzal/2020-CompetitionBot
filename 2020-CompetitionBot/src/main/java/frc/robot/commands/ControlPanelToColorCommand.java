package frc.robot.commands;

import frc.robot.subsystems.ColorSensorSubsystem;
import frc.robot.subsystems.ControlPanelSubsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;

/**
 * A prototype command that turns the color wheel to the target color.
 */
public class ControlPanelToColorCommand extends CommandBase {
  
  private final ColorSensorSubsystem colorSensorSubsystem;
  private final ControlPanelSubsystem controlPanelSubsystem;

  private boolean isFinished;

  /**
   * Creates a new ControlPanelToColorCommand.
   *
   * @param colorSensorSubsystem The color sensors used by this command.
   */
  public ControlPanelToColorCommand(ColorSensorSubsystem colorSensorSubsystem, ControlPanelSubsystem controlPanelSubsystem) {
    this.colorSensorSubsystem = colorSensorSubsystem;
    this.controlPanelSubsystem = controlPanelSubsystem;
    this.addRequirements(this.colorSensorSubsystem, this.controlPanelSubsystem);
  }

  @Override
  public void initialize() {
      // Start Motors
  }

  @Override
  public void execute() {
    int target = this.colorSensorSubsystem.getTargetColor();

    if (!this.isFinished) {
      this.isFinished = this.colorSensorSubsystem.getLeftColor() == target
       && this.colorSensorSubsystem.getRightColor() == target;
    }
  }

  @Override
  public void end(boolean interrupted) {
    this.controlPanelSubsystem.stopWheels();
  }

  @Override
  public boolean isFinished() {
    return this.isFinished;
  }
}
