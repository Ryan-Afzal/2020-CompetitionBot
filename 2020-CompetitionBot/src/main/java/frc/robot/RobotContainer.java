package frc.robot;

import static frc.robot.Constants.*;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.*;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.*;
import frc.robot.subsystems.*;

public class RobotContainer {

	private final GenericHID driveHid = new Joystick(DRIVE_HID);
	private final GenericHID operatorHid = new Joystick(OPERATOR_HID);

	private final DriveTrainSubsystem driveTrain = new DriveTrainSubsystem();
	private final IntakeSubsystem intakeSubsystem = new IntakeSubsystem();
	private final ConveyorSubsystem conveyorSubsystem = new ConveyorSubsystem();
	private final ShootSubsystem shootSubsystem = new ShootSubsystem();

	public RobotContainer() {
		this.configureDefaultCommands();
		this.configureButtonBindings();
	}

	private void configureDefaultCommands() {
		this.driveTrain.setDefaultCommand(new DriveTrainDefaultCommand(this.driveTrain, this.driveHid));
	}
	
	private void configureButtonBindings() {
		// Toggle Intake
		new JoystickButton(this.operatorHid, TOGGLE_INTAKE_BUTTON)
			.whenPressed(new ToggleIntakeCommand(this.intakeSubsystem));
		
		// Intake
		new JoystickButton(this.operatorHid, INTAKE_BUTTON)
			.whileHeld(new IntakeCommand(this.intakeSubsystem));

		// Conveyor
		new JoystickButton(this.operatorHid, MOVE_CONVEYOR_BUTTON)
			.whileHeld(new MoveConveyorCommand(this.conveyorSubsystem));
		
		// Shoot
		new JoystickButton(this.operatorHid, SHOOT_BUTTON)
			.whileHeld(new ShootCommand(this.shootSubsystem));
	}

	public Command getAutonomousCommand() {
		return null;
	}

	public void onDisable() {
		this.intakeSubsystem.stopIntakeDeploy();
	}
}
