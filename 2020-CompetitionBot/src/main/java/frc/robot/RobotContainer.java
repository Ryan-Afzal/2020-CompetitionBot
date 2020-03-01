package frc.robot;

import static frc.robot.Constants.*;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj2.command.*;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.*;
import frc.robot.subsystems.*;

@SuppressWarnings("unused")
public class RobotContainer {

	private final GenericHID driveHid1 = new Joystick(DRIVE_HID_1);
	private final GenericHID driveHid2 = new Joystick(DRIVE_HID_2);
	private final GenericHID operatorHid = new Joystick(OPERATOR_HID);

	private final DriveTrainSubsystem driveTrain = new DriveTrainSubsystem();
	private final IntakeSubsystem intakeSubsystem = new IntakeSubsystem();
	private final ConveyorSubsystem conveyorSubsystem = new ConveyorSubsystem();
	private final ShootSubsystem shootSubsystem = new ShootSubsystem();
	private final JamFixSubsystem jamFixSubsystem = new JamFixSubsystem();
	private final CameraSubsystem cameraSubsystem = new CameraSubsystem();

	public RobotContainer() {
		this.configureDefaultCommands();
		this.configureButtonBindings();
	}

	private void configureDefaultCommands() {
		//this.driveTrain.setDefaultCommand(new DriveTrainArcadeDefaultCommand(this.driveTrain, this.driveHid1));
		this.driveTrain.setDefaultCommand(new DriveTrainCurvatureDefaultCommand(this.driveTrain, this.driveHid1, this.driveHid2));
	}
	
	private void configureButtonBindings() {
		// Toggle Intake
		new JoystickButton(this.operatorHid, TOGGLE_INTAKE_BUTTON)
			.whenPressed(new ToggleIntakeCommand(this.intakeSubsystem));
		
		// Intake
		new JoystickButton(this.operatorHid, INTAKE_BUTTON)
			.whileHeld(new IntakeCommand(this.intakeSubsystem));

		// Reverse Intake
		new JoystickButton(this.operatorHid, INTAKE_REVERSE_BUTTON)
			.whileHeld(new IntakeReverseCommand(this.intakeSubsystem));

		// Conveyor
		new JoystickButton(this.operatorHid, MOVE_CONVEYOR_BUTTON)
			.whileHeld(new ConveyorAndJamCommand(this.conveyorSubsystem, this.jamFixSubsystem));

		// Reverse Conveyor
		new JoystickButton(this.operatorHid, MOVE_CONVEYOR_REVERSE_BUTTON)
			.whileHeld(new MoveConveyorReverseCommand(this.conveyorSubsystem));
		
		// Shoot
		new JoystickButton(this.operatorHid, SHOOT_BUTTON)
			.whileHeld(new ShootCommand(this.shootSubsystem));

		// Fix Hopper Jam
		/*new JoystickButton(this.operatorHid, JAM_BUTTON)
			.whileHeld(new FixJamCommand(this.jamFixSubsystem));*/
	}

	public Command getAutonomousCommand() {
		return new InstantCommand(() -> System.out.println("Auto Started"))// Start
			.andThen(new InstantCommand(() -> this.intakeSubsystem.setIntakeDeploy(DoubleSolenoid.Value.kReverse)))
			.andThen(new InstantCommand(() -> this.shootSubsystem.startShoot(), this.shootSubsystem))// Start shooter
			.andThen(new WaitUntilCommand(() -> this.shootSubsystem.getCurrentSpeed() <= this.shootSubsystem.getTargetSpeed()))// Wait for shooter to come up to full speed
			.andThen(new InstantCommand(() -> this.conveyorSubsystem.startConveyor(), this.conveyorSubsystem))// Start conveyor
			.andThen(new WaitCommand(10)
				//.raceWith(new AutoRunConveyorToShootNBallsCommand(this.conveyorSubsystem, this.shootSubsystem, 3))
				)// Run conveyor to fire N balls OR 10 seconds
			.andThen(new InstantCommand(() -> this.conveyorSubsystem.stopConveyor(), this.conveyorSubsystem))// Stop Conveyor
			.andThen(new InstantCommand(() -> this.shootSubsystem.stopShoot(), this.shootSubsystem))// Stop shooter
			.andThen(new DriveDistanceCommand(this.driveTrain, 4 * 12))// Drive backwards
			.andThen(new InstantCommand(() -> System.out.println("Auto Ended")));// End
			
			// Next: Turn Around.
	}

	public void onDisable() {
		this.intakeSubsystem.stopIntakeDeploy();
	}
}
