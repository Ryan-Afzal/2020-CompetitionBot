package frc.robot.subsystems;

import static frc.robot.Constants.*;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.cscore.VideoMode;
import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class CameraSubsystem extends SubsystemBase {

	private UsbCamera intakeCamera;
	private UsbCamera shooterCamera;

	public CameraSubsystem() {
		this.initIntakeCamera();
		this.initShooterCamera();
	}

	private void initIntakeCamera() {
		this.intakeCamera = CameraServer.getInstance().startAutomaticCapture(0);

		this.intakeCamera.setResolution(320,480);
		this.intakeCamera.setFPS(20);

		Shuffleboard.getTab(TAB_KEY)
			.add(INTAKE_CAMERA_KEY, this.intakeCamera)
			.withSize(5, 3)
			.withPosition(0, 0)
			;
	}

	private void initShooterCamera() {
		this.shooterCamera = CameraServer.getInstance().startAutomaticCapture(1);

		this.shooterCamera.setResolution(320,480);
		this.shooterCamera.setFPS(20);
			
		Shuffleboard.getTab(TAB_KEY)
			.add(SHOOTER_CAMERA_KEY, this.shooterCamera)
			.withSize(4, 3)
			.withPosition(5, 0)
			;
	}

}
