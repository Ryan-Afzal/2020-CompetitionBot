package frc.robot.subsystems;

import static frc.robot.Constants.*;
import com.ctre.phoenix.motorcontrol.can.*;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

/**
 * Drivetrain subsystem that uses an Arcade Drive.
 * It takes a single {@link GenericHID} and uses its Y and X values for Forward/Back and Left/Right, respectively.
 */
public class DriveTrainSubsystem extends SubsystemBase {

    private final WPI_TalonSRX l1 = new WPI_TalonSRX(LEFT_FRONT_DRIVE_MOTOR);
    private final WPI_TalonSRX l2 = new WPI_TalonSRX(LEFT_BACK_DRIVE_MOTOR);
    private final WPI_TalonSRX r1 = new WPI_TalonSRX(RIGHT_FRONT_DRIVE_MOTOR);
    private final WPI_TalonSRX r2 = new WPI_TalonSRX(RIGHT_BACK_DRIVE_MOTOR);

    private final Encoder e1 = new Encoder(0, 1);
    private final Encoder e2 = new Encoder(3,2);
    
    private final SpeedControllerGroup leftControllerGroup = new SpeedControllerGroup(l1, l2);
    private final SpeedControllerGroup rightControllerGroup = new SpeedControllerGroup(r1, r2);
    
    private final DifferentialDrive differentialDrive = new DifferentialDrive(this.leftControllerGroup, this.rightControllerGroup);
    
    private final GenericHID driveHid;

    /**
     * Contruct an instance of the drivetrain.
     * @param driveHid The HID that provides input to the drivetrain.
     */
    public DriveTrainSubsystem(GenericHID driveHid) {
        this.driveHid = driveHid;
    }

    /**
     * Arcade the {@link DriveTrainSubsystem} using the provided values.
     * @param forwardBack The speed along the x-axis [-1.0, 1.0]. Forward is positive.
     * @param leftRight The rotation rate along the z-axis [-1.0, 1.0]. Clockwise is positive.
     */
    public void arcadeDrive(double forwardBack, double leftRight) {
        this.differentialDrive.arcadeDrive(forwardBack, leftRight);
    }

    @Override
    public void periodic() {
        //System.out.println(e2.get());
        double forwardBack = this.driveHid.getY();
        double leftRight = this.driveHid.getX();

        this.differentialDrive.arcadeDrive(forwardBack, leftRight);
    }
    
}
