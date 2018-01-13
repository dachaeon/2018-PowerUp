// Created by Tyler, Emma, and Joe on 01/08/18

package org.usfirst.frc.team58.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team58.robot.Robot;
import org.usfirst.frc.team58.robot.RobotMap;


public class Drive extends Command {	
	
	public Drive() {
		// Use requires() here to declare subsystem dependencies
		requires(Robot.m_DriveTrain);
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		// Collect values from Driver control
		double moveValue = Robot.m_oi.driver.getRawAxis(RobotMap.moveAxis);
		double turnValue = Robot.m_oi.driver.getRawAxis(RobotMap.turnAxis);
		double boostValue = Robot.m_oi.driver.getRawAxis(RobotMap.boostAxis);
		boolean boostOn = false;
		
		// Set moveValue to 100% if moveAxis is 90% or more
		if (moveValue > 0.9) {
			moveValue = 1;
		}
		if (moveValue < -0.9) {
			moveValue = -1;
		}
		
		// Deadbands for driving controllers
		if ((moveValue <= 0.2) && (moveValue >= -0.2)) {
			moveValue = 0;
		}
		
		if ((turnValue <= 0.2) && (turnValue >= -0.2)){
			turnValue = 0;
		}
		
		// Determine if Boost should be on
		if (boostValue >= 0.75) {
			boostOn = true;
		}
		
		// Send values to Drive Train subsystem
		Robot.m_DriveTrain.drive(moveValue, turnValue);
		Robot.m_DriveTrain.boost(boostOn);
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
	}
}