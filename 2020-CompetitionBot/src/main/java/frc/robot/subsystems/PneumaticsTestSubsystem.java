package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

/**
 * A test subsystem to test the pneumatics on the old kitbot.
 */
public class PneumaticsTestSubsystem extends SubsystemBase {

	private DoubleSolenoid solenoid = new DoubleSolenoid(Constants.PNEUMATICS_TEST_OUT, Constants.PNEUMATICS_TEST_IN);

	public PneumaticsTestSubsystem() {
		
	}

	@Override
	public void periodic() {
		
	}

	public void out() {
		solenoid.set(DoubleSolenoid.Value.kForward);
	}

	public void in() {
		solenoid.set(DoubleSolenoid.Value.kReverse);
	}

	public void stop() {
		solenoid.set(DoubleSolenoid.Value.kOff);
	}

}
