package frc.robot.subsystems;

import static frc.robot.Constants.*;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveTrainSubsystem extends SubsystemBase {

    private final VictorSP l1 = new VictorSP(LEFT_FRONT_DRIVE_MOTOR_PORT);
    private final VictorSP l2 = new VictorSP(LEFT_BACK_DRIVE_MOTOR_PORT);
    private final VictorSP r1 = new VictorSP(RIGHT_FRONT_DRIVE_MOTOR_PORT);
    private final VictorSP r2 = new VictorSP(RIGHT_BACK_DRIVE_MOTOR_PORT);
    
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
