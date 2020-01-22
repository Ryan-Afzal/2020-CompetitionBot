package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ControlPanelSubsystem;

public class ControlPanelRotateToColorCommand extends CommandBase {

	private final ControlPanelSubsystem controlPanelSubsystem;

	private boolean isFinished;

	public ControlPanelRotateToColorCommand(ControlPanelSubsystem controlPanelSubsystem) {
		this.controlPanelSubsystem = controlPanelSubsystem;
		this.isFinished = false;
	}

	@Override
	public void initialize() {
		this.controlPanelSubsystem.startWheels();
	}

	@Override
	public void execute() {
		var color = this.controlPanelSubsystem.getTargetColor();

		if (!this.isFinished) {
			this.isFinished = this.controlPanelSubsystem.getLeftSensorColor().equals(color)
				&& this.controlPanelSubsystem.getRightSensorColor().equals(color);
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