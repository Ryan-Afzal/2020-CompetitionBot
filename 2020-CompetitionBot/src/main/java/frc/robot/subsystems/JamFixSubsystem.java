package frc.robot.subsystems;

import static frc.robot.Constants.*;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class JamFixSubsystem extends SubsystemBase {

	private final WPI_TalonSRX motor = new WPI_TalonSRX(JAM_FIX_MOTOR);

	public JamFixSubsystem() {

	}

	public void startFix() {
		this.motor.set(1.0);
	}

	public void stopFix() {
		this.motor.set(0.0);
	}

}