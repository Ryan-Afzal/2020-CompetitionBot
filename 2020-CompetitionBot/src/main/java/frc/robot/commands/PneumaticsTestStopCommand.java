package frc.robot.commands;

import frc.robot.subsystems.PneumaticsTestSubsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class PneumaticsTestStopCommand extends CommandBase {

	private PneumaticsTestSubsystem subsystem;

	public PneumaticsTestStopCommand(PneumaticsTestSubsystem subsystem) {
		this.subsystem = subsystem;
	}

	@Override
	public void execute() {
		subsystem.stop();
	}

	@Override
	public boolean isFinished() {
		return true;
	}
}
