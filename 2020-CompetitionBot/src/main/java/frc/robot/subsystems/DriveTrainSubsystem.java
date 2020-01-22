package frc.robot.subsystems;

import static frc.robot.Constants.*;
import com.ctre.phoenix.motorcontrol.can.*;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

/**
 * Drivetrain subsystem that uses an Arcade Drive.
 * It takes a single {@link GenericHID} and uses its Y and X values for Forward/Back and Left/Right, respectively.
 */
public class DriveTrainSubsystem extends SubsystemBase {

    private class DriveTrainArcadeCommand extends CommandBase {
        
        private final DriveTrainSubsystem driveTrainSubsystem;
        private final GenericHID driveHid;

        public DriveTrainArcadeCommand(DriveTrainSubsystem driveTrainSubsystem, GenericHID driveHid) {
            this.driveTrainSubsystem = driveTrainSubsystem;
            this.driveHid = driveHid;
        }

        @Override
        public void execute() {
            double forwardBack = this.driveHid.getY();
            double leftRight = this.driveHid.getX();

            this.driveTrainSubsystem.arcadeDrive(forwardBack, leftRight);
        }

        @Override
        public void end(boolean interrupted) {
            this.driveTrainSubsystem.arcadeDrive(0.0, 0.0);
        }

    }

    private class DriveTrainTankCommand extends CommandBase {
        
        private final DriveTrainSubsystem driveTrainSubsystem;
        
        private final GenericHID leftHid;
        private final GenericHID rightHid;

        public DriveTrainTankCommand(DriveTrainSubsystem driveTrainSubsystem, GenericHID leftHid, GenericHID rightHid) {
            this.driveTrainSubsystem = driveTrainSubsystem;
            this.leftHid = leftHid;
            this.rightHid = rightHid;
        }

        @Override
        public void execute() {
            double left = this.leftHid.getY();
            double right = this.rightHid.getY();

            this.driveTrainSubsystem.tankDrive(left, right);
        }

        @Override
        public void end(boolean interrupted) {
            this.driveTrainSubsystem.tankDrive(0.0, 0.0);
        }

    }

    /**
     * A coefficient used when using arcade drive.
     */
    public static final double MOTOR_COEFFICIENT_FORWARDBACK = 1.0;

    /**
     * A coefficient used when using arcade drive.
     */
    public static final double MOTOR_COEFFICIENT_LEFTRIGHT = 1.0;

    /**
     * The coefficient used when using tank drive.
     */
    public static final double MOTOR_COEFFICIENT_TANK = 1.0;

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

    private GenericHID driveHid2;

    /**
     * Contruct an instance of the drivetrain.
     * @param driveHid The HID that provides input to the drivetrain.
     */
    public DriveTrainSubsystem(GenericHID driveHid) {
        this.driveHid = driveHid;
    }

    /**
     * Construct an instance of the drivetrain.
     * @param hid1
     * @param hid2
     */
    public DriveTrainSubsystem(GenericHID hid1, GenericHID hid2) {
        this.driveHid = hid1;
        this.driveHid2 = hid2;
    }

    /**
     * Arcade the {@link DriveTrainSubsystem} using the provided values.
     * @param forwardBack The speed along the x-axis [-1.0, 1.0]. Forward is positive.
     * @param leftRight The rotation rate along the z-axis [-1.0, 1.0]. Clockwise is positive.
     */
    public void arcadeDrive(double forwardBack, double leftRight) {
        this.differentialDrive.arcadeDrive(MOTOR_COEFFICIENT_FORWARDBACK * forwardBack, MOTOR_COEFFICIENT_LEFTRIGHT * leftRight);
    }

    /**
     * Tank the {@link DriveTrainSubsystem} using the provided values.
     * @param left The speed of the left side [-1.0, 1.0]. Forward is positive.
     * @param right The speed of the right side [-1.0, 1.0]. Forward is positive.
     */
    public void tankDrive(double left, double right) {
        this.differentialDrive.tankDrive(MOTOR_COEFFICIENT_TANK * left, MOTOR_COEFFICIENT_TANK * right);
    }

    @Override
    public void periodic() {
        // Do Nothing
    }

    @Override
    public Command getDefaultCommand() {
        return new DriveTrainArcadeCommand(this, this.driveHid);
        //return new DriveTrainTankCommand(this, this.driveHid, this.driveHid2)
    }
    
}
