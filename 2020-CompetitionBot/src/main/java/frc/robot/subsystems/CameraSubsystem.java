package frc.robot.subsystems;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class CameraSubsystem extends SubsystemBase {

	private UsbCamera camera = CameraServer.getInstance().startAutomaticCapture();

	public CameraSubsystem() {
		this.camera.setResolution(160,90);
		this.camera.setFPS(25);
	}

	public UsbCamera getCamera() {
		return this.camera;
	}

}
