// Created by Emma and Joe on 01/14/18

package org.usfirst.frc.team58.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team58.robot.Robot;
import org.usfirst.frc.team58.robot.RobotMap;


public class Grab extends Command {	
	
	public Grab() {
		// Use requires() here to declare subsystem dependencies
		requires(Robot.m_Grabber);
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {

	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		// get values from controller
		double moveValue = Robot.m_oi.operator.getRawAxis(RobotMap.grabAxis);
		double releaseValue = Robot.m_oi.operator.getRawAxis(RobotMap.releaseAxis);
		boolean releaseActivate = false;
		
		// round up if pushed most of the way forward or back
		if (moveValue > 0.9) {
			moveValue = 1;
		}
		if (moveValue < -0.9) {
			moveValue = -1;
		}
		
		// apply deadband
		if ((moveValue > -0.2) && (moveValue < 0.2)) {
			moveValue = 0;
		}
		
		// determine if grabber should be open
		if (releaseValue > 0.75) {
			releaseActivate = true;
		}
		
		// send values to subsystem
		Robot.m_Grabber.grabWheels(moveValue);
		Robot.m_Grabber.release(releaseActivate);
	}


	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
		Robot.m_Grabber.grabWheels(0);
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
		Robot.m_Grabber.grabWheels(0);
	}
}