package frc.robot.subsystems;

import static frc.robot.Constants.*;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ConveyorSubsystem extends SubsystemBase {

    public static final double MOTOR_SPEED = 1.0;

    private final WPI_TalonSRX conveyorMotor = new WPI_TalonSRX(CONVEYOR_MOTOR);

    public ConveyorSubsystem() {
        
    }

    public void startConveyor() {
        this.conveyorMotor.set(MOTOR_SPEED);
    }

    public void stopConveyor() {
        this.conveyorMotor.set(MOTOR_SPEED);
    }

}
