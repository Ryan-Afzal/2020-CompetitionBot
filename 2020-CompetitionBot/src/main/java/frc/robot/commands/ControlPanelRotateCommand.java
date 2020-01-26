package frc.robot.commands;

import edu.wpi.first.wpilibj.util.Color;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ControlPanelSubsystem;

/**
 * Command which uses a {@link ControlPanelSubsystem} to rotate the control panel by a specified number of full revolutions.
 */
public class ControlPanelRotateCommand extends CommandBase {
    
    private final ControlPanelSubsystem controlPanelSubsystem;

    private final int targetCount;

    private boolean isFinished;

    private Color startingColor;
    private Color prevColor;
    private int count;

    /**
     * Constructs a new {@link ControlPanelRotateCommand} that rotates the control panel by the specified number of full revolutions.
     * @param controlPanelSubsystem The control panel subsystem
     * @param targetCount The specified number of full rotations to perform
     */
    public ControlPanelRotateCommand(ControlPanelSubsystem controlPanelSubsystem) {
        this.controlPanelSubsystem = controlPanelSubsystem;
        this.addRequirements(this.controlPanelSubsystem);
        this.targetCount = this.controlPanelSubsystem.getTargetRotations() * 2;// Convert from full revolutions to wedges with the starting color.

        this.isFinished = false;
        
        this.startingColor = null;
        this.prevColor = null;
        this.count = 0;
    }

    @Override
	public void initialize() {
        this.startingColor = this.controlPanelSubsystem.getSensorColor();
        this.prevColor = this.controlPanelSubsystem.getSensorColor();
        this.controlPanelSubsystem.startWheels();
	}

	@Override
	public void execute() {
		if (!this.isFinished) {
            Color color = this.controlPanelSubsystem.getSensorColor();

            if (!color.equals(this.prevColor)) {
                if (color.equals(this.startingColor)) {
                    this.count++;

                    if (this.count == this.targetCount) {
                        this.isFinished = true;
                    }
                }
            }

            this.prevColor = color;
        }
	}

	@Override
	public void end(boolean interrupted) {
		this.controlPanelSubsystem.stopWheels();
	}

	@Override
	public boolean isFinished() {
		return this.isFinished;
    }
    
}
