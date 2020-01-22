package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ControlPanelSubsystem;

public class ControlPanelExtendWheelsCommand extends CommandBase {

    private final ControlPanelSubsystem controlPanelSubsystem;

    private boolean isFinished;

    public ControlPanelExtendWheelsCommand(ControlPanelSubsystem controlPanelSubsystem) {
        this.controlPanelSubsystem = controlPanelSubsystem;
    }

    @Override
    public void initialize() {
        this.controlPanelSubsystem.extendWheels();
    }

    @Override
    public void execute() {
        if (!this.isFinished) {
            this.isFinished = this.controlPanelSubsystem.areWheelsExtended();
        }
    }

    @Override
    public void end(boolean interrupted) {
        if (interrupted) {
            this.controlPanelSubsystem.retractWheels();
        }
    }

    @Override
    public boolean isFinished() {
        return this.isFinished;
    }
}