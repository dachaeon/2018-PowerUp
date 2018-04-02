// AHHHHHHHHHHHHH

package org.usfirst.frc.team58.robot.commands;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team58.robot.Robot;
import org.usfirst.frc.team58.robot.RobotMap;


public class TrapDrive extends Command {	
	
	private double distance;
	private double nu_dist;
	private double startSpeed = -0.58;
	private double midSpeed = -1;
	private double endSpeed = -0.58;
	private double encoderValue;
	

	
	public TrapDrive(double distance) {
		this.distance = distance;
		requires(Robot.m_DriveTrain);
		// Stop any driving
		Robot.m_DriveTrain.drive(0, 0, false);
		// Zero encoder
		Robot.m_DriveTrain.zeroEncoders();
		// Convert the setpoint distance to native units for encoders
		nu_dist = (distance*4096)/(6*Math.PI);
		// Use requires() here to declare subsystem dependencies
		requires(Robot.m_DriveTrain);
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		Robot.m_DriveTrain.zeroNavx();
		Robot.m_DriveTrain.enableDisablePID(false);
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {	
		encoderValue = Robot.m_DriveTrain.getEncoders();
		
		double angle = Robot.m_DriveTrain.getAngle();
		angle = -angle*0.1558; // scale down angle to make it a small correction. Change scale factor as needed - Emma
		double nu_range = (nu_dist) * 0.1;
		
		if(encoderValue < nu_range) {
			Robot.m_DriveTrain.drive(startSpeed, angle, false);
		}else if(encoderValue < (nu_dist - nu_range)) {
			Robot.m_DriveTrain.drive(midSpeed, angle, false);
		}else {
			Robot.m_DriveTrain.drive(endSpeed, angle, false);
		}
		
	}


	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {	
		if((encoderValue > (nu_dist - 1000)) && (encoderValue < (nu_dist +1000))) {
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