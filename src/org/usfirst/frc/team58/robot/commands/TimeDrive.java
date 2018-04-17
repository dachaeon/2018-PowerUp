package org.usfirst.frc.team58.robot.commands;

import org.usfirst.frc.team58.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class TimeDrive extends Command {

	long startTime;
	double duration;
	double speed;
	
	public TimeDrive(double duration, double speed) {
		this.duration = duration;
		this.speed = speed;
		
	}
	
	@Override
	protected void initialize() {
		new ResetWait(250);
		startTime = System.currentTimeMillis();

	}
	
	@Override
	protected void execute() {
		Robot.m_DriveTrain.drive(speed, 0, false);
	}
	
	@Override
	protected boolean isFinished() {
		if (System.currentTimeMillis() >= startTime + duration) {
			//System.out.println("Checkin' Time");
			return true;
		} else {
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
