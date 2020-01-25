package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ConveyorSubsystem;

public class MoveConveyorCommand extends CommandBase {

    private final ConveyorSubsystem conveyorSubsystem;

    public MoveConveyorCommand(ConveyorSubsystem conveyorSubsystem) {
        this.conveyorSubsystem = conveyorSubsystem;
        this.addRequirements(this.conveyorSubsystem);
    }

    @Override
    public void initialize() {
        this.conveyorSubsystem.startConveyor();
    }

    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public void end(boolean interrupted) {
        this.conveyorSubsystem.stopConveyor();
    }
}
