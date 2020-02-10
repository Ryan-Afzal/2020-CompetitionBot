package frc.robot.subsystems;

import static frc.robot.Constants.*;

import com.revrobotics.*;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ShootSubsystem extends SubsystemBase {

    private final CANSparkMax shootMotor = new CANSparkMax(SHOOT_MOTOR, CANSparkMaxLowLevel.MotorType.kBrushless);

    public ShootSubsystem() {
        
    }

    public void startShoot() {
        System.out.println("startShoot() called");
        this.shootMotor.set(-0.8);
    }

    public void stopShoot() {
        System.out.println("stopShoot() called");
        this.shootMotor.set(0.0);
    }

}
