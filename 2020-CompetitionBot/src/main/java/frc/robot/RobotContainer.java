package frc.robot;

import frc.robot.subsystems.ColorSensorSubsystem;
import frc.robot.subsystems.ColorSensorTestSubsystem;
import frc.robot.subsystems.PneumaticsTestSubsystem;
import edu.wpi.first.wpilibj2.command.Command;

/**
 * This class is where the bulk of the robot should be declared.	Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).	Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer implements IRobotContainer {
	
	//private final ColorSensorSubsystem colorSensorSubsystem = new ColorSensorSubsystem();

	private final ColorSensorTestSubsystem colorSensorTestSubsystem = new ColorSensorTestSubsystem();
	private final PneumaticsTestSubsystem pneumaticsTestSubsystem = new PneumaticsTestSubsystem();

	public RobotContainer() {
		this.configureButtonBindings();
	}
	
	private void configureButtonBindings() {
		
	}

	public Command getAutonomousCommand() {
		return null;
	}
}
