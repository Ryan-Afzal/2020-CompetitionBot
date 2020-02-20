package frc.robot;

public final class Constants {
	/*
	 * User Interface (Joysticks and Buttons)
	 */
	public static final int DRIVE_HID_1 = 0;
	public static final int DRIVE_HID_2 = 1;
	public static final int OPERATOR_HID = 2;

	public static final int QUICKTURN_BUTTON = 1;

	public static final int TOGGLE_INTAKE_BUTTON = 12;
	public static final int INTAKE_BUTTON = 11;
	public static final int JAM_BUTTON = 10;
	
	public static final int MOVE_CONVEYOR_BUTTON = 1;
	public static final int MOVE_CONVEYOR_REVERSE_BUTTON = 9;
	
	public static final int SHOOT_BUTTON = 2;

	/*
	 * Unused
	 */

	public static final int TOGGLE_CLIMB_BUTTON = -1;

	public static final int CONTROL_PANEL_ROTATE_TO_COLOR_BUTTON = -1;
	public static final int CONTROL_PANEL_FULL_ROTATION_BUTTON = -1;

	/*
	 * Pneumatic Ports
	 */
	public static final int INTAKE_DEPLOY_LEFT = 4;
	public static final int INTAKE_RETRACT_LEFT = 5;

	public static final int INTAKE_DEPLOY_RIGHT = 6;
	public static final int INTAKE_RETRACT_RIGHT = 7;

	/*
	 * Unused
	 */

	public static final int CLIMB_DEPLOY = -1;
	public static final int CLIMB_RETRACT = -1;

	/*
	 * CAN IDs
	 */
	public static final int LEFT_FRONT_DRIVE_MOTOR = 12;
	public static final int LEFT_BACK_DRIVE_MOTOR = 13;
	public static final int RIGHT_BACK_DRIVE_MOTOR = 14;
	public static final int RIGHT_FRONT_DRIVE_MOTOR = 15;
	public static final int SHOOT_MOTOR = 16;
	public static final int FRONT_CONVEYOR_MOTOR = 17;
	public static final int BACK_CONVEYOR_MOTOR = 18;
	public static final int INTAKE_MOTOR = 19;
	public static final int JAM_FIX_MOTOR = 20;

	/*
	 * Smart Dashboard
	 */
	public static final String LEFT_FRONT_DRIVE_MOTOR_KEY = "Left Front";
	public static final String LEFT_BACK_DRIVE_MOTOR_KEY = "Left Back";
	public static final String RIGHT_FRONT_DRIVE_MOTOR_KEY = "Right Front";
	public static final String RIGHT_BACK_DRIVE_MOTOR_KEY = "Right Back";

}
