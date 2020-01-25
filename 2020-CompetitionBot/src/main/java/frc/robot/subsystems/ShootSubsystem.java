package frc.robot.subsystems;

import static frc.robot.Constants.*;

import com.revrobotics.*;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ShootSubsystem extends SubsystemBase {

    public static final double MOTOR_SPEED = 1.0;

    private final CANSparkMax shootMotor = new CANSparkMax(SHOOT_MOTOR, CANSparkMaxLowLevel.MotorType.kBrushless);

    public ShootSubsystem() {
        
    }

    public void startShoot() {
        this.shootMotor.set(MOTOR_SPEED);
    }

    public void stopShoot() {
        this.shootMotor.set(0.0);
    }

}
