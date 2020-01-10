package frc.robot.subsystems;

import static frc.robot.Constants.*;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveTrainSubsystem extends SubsystemBase {

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

        // Tank drive with forward-back and left-right
    }
    
}
