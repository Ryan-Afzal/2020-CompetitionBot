package frc.robot.subsystems;

import static frc.robot.Constants.*;
import com.ctre.phoenix.motorcontrol.can.*;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

/**
 * Drivetrain subsystem that uses an Arcade Drive.
 */
public class DriveTrainSubsystem extends SubsystemBase {

    /**
     * A coefficient used when using arcade drive.
     */
    public static final double MOTOR_COEFFICIENT_FORWARDBACK = 1.0;

    /**
     * A coefficient used when using arcade drive.
     */
    public static final double MOTOR_COEFFICIENT_LEFTRIGHT = 1.0;

    private final WPI_TalonSRX l1 = new WPI_TalonSRX(LEFT_FRONT_DRIVE_MOTOR);
    private final WPI_TalonSRX l2 = new WPI_TalonSRX(LEFT_BACK_DRIVE_MOTOR);
    private final WPI_TalonSRX r1 = new WPI_TalonSRX(RIGHT_FRONT_DRIVE_MOTOR);
    private final WPI_TalonSRX r2 = new WPI_TalonSRX(RIGHT_BACK_DRIVE_MOTOR);

    //private final Encoder e1 = new Encoder(0, 1);
    //private final Encoder e2 = new Encoder(3,2);
    
    private final SpeedControllerGroup leftControllerGroup = new SpeedControllerGroup(l1, l2);
    private final SpeedControllerGroup rightControllerGroup = new SpeedControllerGroup(r1, r2);
    
    private final DifferentialDrive differentialDrive = new DifferentialDrive(this.leftControllerGroup, this.rightControllerGroup);

    /**
     * Contruct an instance of the drivetrain.
     */
    public DriveTrainSubsystem() {

    }

    /**
     * Arcade the {@link DriveTrainSubsystem} using the provided values.
     * @param forwardBack The speed along the x-axis [-1.0, 1.0]. Forward is positive.
     * @param leftRight The rotation rate along the z-axis [-1.0, 1.0]. Clockwise is positive.
     */
    public void arcadeDrive(double forwardBack, double leftRight) {
        this.differentialDrive.arcadeDrive(MOTOR_COEFFICIENT_FORWARDBACK * forwardBack, MOTOR_COEFFICIENT_LEFTRIGHT * leftRight);
    }
    
}
