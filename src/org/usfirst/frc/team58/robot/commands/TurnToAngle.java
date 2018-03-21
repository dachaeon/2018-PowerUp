// AHHHHHHHHHHHHH

package org.usfirst.frc.team58.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team58.robot.Robot;
import org.usfirst.frc.team58.robot.RobotMap;


public class TurnToAngle extends Command {	
	
	private double angle;
	private double currentAngle;
	private double startSpeed = 0.6;
	private double midSpeed = 0.6;
	private double endSpeed = 0.6;
	

	
	public TurnToAngle(double angle) {
		this.angle = angle;
		// Use requires() here to declare subsystem dependencies
		requires(Robot.m_DriveTrain);
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		Robot.m_DriveTrain.zeroNavx();
		Robot.m_DriveTrain.enableDisablePID(false);
		
		if(angle < 0) {
			startSpeed = -startSpeed;
			midSpeed = -midSpeed;
			endSpeed = -endSpeed;
		}
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {	
		currentAngle = Robot.m_DriveTrain.getAngle();
		System.out.println("Current Angle: " + currentAngle);
		if((Math.abs(currentAngle) > (Math.abs(angle)-25)) && (Math.abs(currentAngle) < (Math.abs(angle)+25))) {
			Robot.m_DriveTrain.drive(0, endSpeed, false);
		} else if((Robot.m_DriveTrain.getAngle() > (-5)) && (Robot.m_DriveTrain.getAngle() < (5))) {
			Robot.m_DriveTrain.drive(0, startSpeed, false);
		} else {
			Robot.m_DriveTrain.drive(0, midSpeed, false);
		}
		
		
	}


	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		
		if((Math.abs(currentAngle) > (Math.abs(angle)-2)) && (Math.abs(currentAngle) < (Math.abs(angle)+2))) {
			return true;
		} else {
		return false;
		}
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
		Robot.m_DriveTrain.drive(0, 0, false);
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
		end();
	}
	

}