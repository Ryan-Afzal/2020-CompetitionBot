package frc.robot;

import static frc.robot.Constants.*;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.*;
import frc.robot.subsystems.*;

@SuppressWarnings("unused")
public class RobotContainer {

	private final Joystick driveHid = new Joystick(DRIVE_HID_PORT);
	private final Joystick operatorHid = new Joystick(OPERATOR_HID_PORT);

	private final DriveTrainSubsystem driveTrain = new DriveTrainSubsystem(this.driveHid);
	//private final ControlPanelSubsystem controlPanelSubsystem = new ControlPanelSubsystem();
	//private final IntakeSubsystem intakeSubsystem = new IntakeSubsystem();

	//private final IntakeCommand intakeCommand = new IntakeCommand(this.intakeSubsystem);

	public RobotContainer() {
		this.configureButtonBindings();
	}
	
	private void configureButtonBindings() {
		//new JoystickButton(this.driveHid, INTAKE_BUTTON)
		//	.whileHeld(this.intakeCommand);
	}

	public Command getAutonomousCommand() {
		return null;
	}
}
