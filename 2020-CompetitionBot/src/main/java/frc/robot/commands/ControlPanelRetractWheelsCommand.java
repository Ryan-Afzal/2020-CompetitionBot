package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ControlPanelSubsystem;

public class ControlPanelRetractWheelsCommand extends CommandBase {

    private final ControlPanelSubsystem controlPanelSubsystem;

    private boolean isFinished;

    public ControlPanelRetractWheelsCommand(ControlPanelSubsystem controlPanelSubsystem) {
        this.controlPanelSubsystem = controlPanelSubsystem;
    }

    @Override
    public void initialize() {
        this.controlPanelSubsystem.retractWheels();
    }

    @Override
    public void execute() {
        if (!this.isFinished) {
            this.isFinished = !this.controlPanelSubsystem.areWheelsExtended();
        }
    }

    @Override
    public boolean isFinished() {
        return this.isFinished;
    }
}
