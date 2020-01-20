package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

/**
 * Control Panel subsystem that controls the color sensor, linear actuator, and rotator wheels.
 */
public class ControlPanelSubsystem extends SubsystemBase {

	/**
	 * The speed of the motors controlling the wheels.
	 */
	private static final double MOTOR_SPEED = 0.0;

	/**
	 * The gear reduction for the motors controlling the wheels
	 */
	private static final double GEAR_REDUCTION = 1.0;

	public ControlPanelSubsystem() {
		
	}

	public void extendWheels() {
		throw new UnsupportedOperationException();
	}

	public void retractWheels() {
		throw new UnsupportedOperationException();
	}

	public void startWheels() {
		this.setWheels(MOTOR_SPEED * GEAR_REDUCTION);
	}

	public void stopWheels() {
		this.setWheels(0.0);
	}

	private void setWheels(double speed) {
		throw new UnsupportedOperationException();
	}

}
