package org.usfirst.frc.team58.robot.commands;

import org.usfirst.frc.team58.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class Wait extends Command {
	
	long startTime;
	double duration; 
	
	public Wait(double duration) {
		this.duration = duration;
	}
	
	@Override
	protected void initialize() {
		startTime = System.currentTimeMillis();
	}
	
	@Override
	protected void execute() {
		//System.out.println("Waiting!");
	}
	
	@Override
	protected boolean isFinished() {
		// Checks to see if duration has elapsed since start time
		if (System.currentTimeMillis() >= startTime + duration) {
			return true;
		} else {
			System.out.println("Waiting");
			return false;
		}
		
	}
	
	@Override
	protected void end() {
		System.out.print("Done waiting!");
	}
	
	@Override
	protected void interrupted() {
		end();
	}

}
