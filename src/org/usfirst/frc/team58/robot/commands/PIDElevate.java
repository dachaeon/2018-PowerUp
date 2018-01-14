// Created by Emma and Joe on 01/13/18

package org.usfirst.frc.team58.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team58.robot.Robot;


public class PIDElevate extends Command {	
	
	double height;
	
	public PIDElevate(double height) {
		// Use requires() here to declare subsystem dependencies
		requires(Robot.m_Elevator);
		this.height = height;
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		Robot.m_Elevator.PIDControl(height);
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() { // Add code to determine if PID loop is finished
		return false;
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
		// Return to variable control mode
		Robot.m_Elevator.returnToVariableControl();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
		// Return to variable control mode
		Robot.m_Elevator.returnToVariableControl();
	}
}