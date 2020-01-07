package frc.robot.subsystems;

import com.revrobotics.ColorSensorV3;

import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.util.Color;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

/**
 * The Color Sensor test subystem
 */
public class ColorSensorTestSubsystem extends SubsystemBase {
	
	private final I2C.Port i2cPort = I2C.Port.kOnboard;
	private final ColorSensorV3 m_colorSensor = new ColorSensorV3(i2cPort);
  
	private Color prevColor = Color.kAliceBlue;

	public ColorSensorTestSubsystem() {

	}

	@Override
	public void periodic() {
		// System.out.println("itjesilfjeh lfhnelw");
    	Color detectedColor = m_colorSensor.getColor();

    	/**
    	 * The sensor returns a raw IR value of the infrared light detected.
    	 */
    	// double IR = m_colorSensor.getIR();
    	/**
    	 * Open Smart Dashboard or Shuffleboard to see the color detected by the sensor.
    	 */
    	double d = Math.sqrt(Math.abs(Math.pow((detectedColor.red - prevColor.red), 2)
    	    + Math.pow((detectedColor.green - prevColor.green), 2) + Math.pow((detectedColor.blue - prevColor.blue), 2)));
    	double thresh = 0.05;
    	if (d > thresh) {
    	  System.out
    	      .println("red: " + detectedColor.red + " green: " + detectedColor.green + " blue: " + detectedColor.blue);
    	}
    	this.prevColor = detectedColor;
	}
}
