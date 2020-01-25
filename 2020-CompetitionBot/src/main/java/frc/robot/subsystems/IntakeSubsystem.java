package frc.robot.subsystems;

import static frc.robot.Constants.*;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class IntakeSubsystem extends SubsystemBase {

    public static final double MOTOR_SPEED = 1.0;

    private final WPI_TalonSRX intakeMotor = new WPI_TalonSRX(INTAKE_MOTOR);

    public IntakeSubsystem() {

    }

    public void startIntake() {
        this.intakeMotor.set(MOTOR_SPEED);
    }

    public void stopIntake() {
        this.intakeMotor.set(0.0);
    }

}
