package frc.robot.subsystems;

import static frc.robot.Constants.*;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

/**
 * Drivetrain subsystem that uses an Arcade Drive.
 * It takes a single {@link GenericHID} and uses its Y and X values for Forward/Back and Left/Right, respectively.
 */
public class DriveTrainSubsystem extends SubsystemBase {

    private final PWMVictorSPX l1 = new PWMVictorSPX(LEFT_FRONT_DRIVE_MOTOR);
    private final PWMVictorSPX l2 = new PWMVictorSPX(LEFT_BACK_DRIVE_MOTOR);
    private final PWMVictorSPX r1 = new PWMVictorSPX(RIGHT_FRONT_DRIVE_MOTOR);
    private final PWMVictorSPX r2 = new PWMVictorSPX(RIGHT_BACK_DRIVE_MOTOR);
    
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

    @Override
    public void periodic() {
        double forwardBack = this.driveHid.getY();
        double leftRight = this.driveHid.getX();

        this.differentialDrive.arcadeDrive(forwardBack, leftRight);
    }
    
}
