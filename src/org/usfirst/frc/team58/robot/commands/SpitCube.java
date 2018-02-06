// for use in auto only

package org.usfirst.frc.team58.robot.commands;

import org.usfirst.frc.team58.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class SpitCube extends Command {
	long startTime;
	long duration;
	
	public SpitCube () {
		duration = 1000; //ot sure how long, approx 1 second enough?
	}
	
	@Override
	protected void initialize() {
		startTime = System.currentTimeMillis();
		Robot.m_Grabber.grabWheels(-1);
	}
	
	@Override
	protected void execute() {
		Robot.m_Grabber.grabWheels(-1);
		
		// ends when duration is completed
		if (isFinished()) {
			end();
		}
	}
	
	@Override
	protected boolean isFinished() {
		// checks to see if duration has elapsed since start time
		if (System.currentTimeMillis() >= startTime + duration) {
			return true;
		} else {
			return false;
		}
		
	}
	
	@Override
	protected void end() {
		Robot.m_Grabber.grabWheels(0);
	}
	
	@Override
	protected void interrupted() {
		Robot.m_Grabber.grabWheels(0);
	}

}
