package frc.robot.subsystems;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class CameraSubsystem extends SubsystemBase {

	private final UsbCamera driverCamera = CameraServer.getInstance().startAutomaticCapture(0);
	private final UsbCamera operatorCamera = CameraServer.getInstance().startAutomaticCapture(1);

	public CameraSubsystem() {
		this.driverCamera.setResolution(160,90);
		this.driverCamera.setFPS(30);

		this.operatorCamera.setResolution(160, 90);
		this.operatorCamera.setFPS(25);
	}

	public UsbCamera getDriverCamera() {
		return this.driverCamera;
	}

	public UsbCamera getOperatoCamera() {
		return this.operatorCamera;
	}

}
