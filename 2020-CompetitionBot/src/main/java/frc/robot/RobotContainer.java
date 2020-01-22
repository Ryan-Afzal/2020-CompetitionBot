package frc.robot;

import static frc.robot.Constants.*;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.*;
import frc.robot.subsystems.*;

@SuppressWarnings("unused")
public class RobotContainer {

	private final GenericHID driveHid = new Joystick(DRIVE_HID);
	private final GenericHID operatorHid = new Joystick(OPERATOR_HID);

	private final DriveTrainSubsystem driveTrain = new DriveTrainSubsystem(this.driveHid, this.operatorHid);
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
