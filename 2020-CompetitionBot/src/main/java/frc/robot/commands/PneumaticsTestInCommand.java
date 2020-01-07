package frc.robot.commands;

import frc.robot.subsystems.PneumaticsTestSubsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class PneumaticsTestInCommand extends CommandBase {

	private PneumaticsTestSubsystem subsystem;

	public PneumaticsTestInCommand(PneumaticsTestSubsystem subsystem) {
		this.subsystem = subsystem;
	}

	@Override
	public void execute() {
		subsystem.in();
	}

	@Override
	public boolean isFinished() {
		return true;
	}
}
