package frc.robot.commands;

import frc.robot.subsystems.PneumaticsTestSubsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class PneumaticsTestOutCommand extends CommandBase {

	private PneumaticsTestSubsystem subsystem;

	public PneumaticsTestOutCommand(PneumaticsTestSubsystem subsystem) {
		this.subsystem = subsystem;
	}

	@Override
	public void execute() {
		subsystem.out();
	}

	@Override
	public boolean isFinished() {
		return true;
	}
}
