package org.usfirst.frc.team58.robot.commands;

import org.usfirst.frc.team58.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class ResetWait extends Command {
	
	long startTime;
	double duration; 
	
	public ResetWait(double duration) {
		requires(Robot.m_DriveTrain);
		this.duration = duration;
	}
	
	@Override
	protected void initialize() {
		startTime = System.currentTimeMillis();
		Robot.m_DriveTrain.drive(0, 0, false);
		Robot.m_DriveTrain.zeroEncoders();
		Robot.m_DriveTrain.zeroNavx();
	}
	
	@Override
	protected void execute() {
		Robot.m_DriveTrain.drive(0, 0, false);
	}
	
	@Override
	protected boolean isFinished() {
		// Checks to see if duration has elapsed since start time
		if (System.currentTimeMillis() >= startTime + duration) {
			return true;
		} else {
			//System.out.println("Waiting");
			return false;
		}
		
	}
	
	@Override
	protected void end() {
		Robot.m_DriveTrain.drive(0, 0, false);
	}
	
	@Override
	protected void interrupted() {
		end();
	}

}
