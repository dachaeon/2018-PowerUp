package org.usfirst.frc.team58.robot.commands;

import org.usfirst.frc.team58.robot.Robot;
import org.usfirst.frc.team58.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class RunRearElevator extends Command {
	
	public RunRearElevator() {
		// Use requires() here to declare subsystem dependencies
		requires(Robot.m_RearElevator);
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		Robot.m_RearElevator.driveElevator(0.5);
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		if (isFinished()) {
			end();
		}
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return Robot.m_RearElevator.getSwitch();
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
		Robot.m_RearElevator.driveElevator(0);
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
		Robot.m_RearElevator.driveElevator(0);
	}
}
