// Created by Emma and Joe on 01/13/18

package org.usfirst.frc.team58.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team58.robot.Robot;
import org.usfirst.frc.team58.robot.RobotMap;


public class VariableElevate extends Command {	
	
<<<<<<< HEAD:src/org/usfirst/frc/team58/robot/commands/VariableElevate.java
	public VariableElevate() {
=======
	
	public Drive() {
>>>>>>> drivesystem-only:src/org/usfirst/frc/team58/robot/commands/Drive.java
		// Use requires() here to declare subsystem dependencies
		requires(Robot.m_Elevator);
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		Robot.m_Elevator.variableControl(0);
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		double moveValue = Robot.m_oi.operator.getRawAxis(RobotMap.elevateAxis);
		if (moveValue > 0.9) {
			moveValue = 1;
		}
		if (moveValue < -0.9) {
			moveValue = -1;
		}
		if ((moveValue > -0.2) && (moveValue < 0.2)) {
			moveValue = 0;
		}
		
<<<<<<< HEAD:src/org/usfirst/frc/team58/robot/commands/VariableElevate.java
		Robot.m_Elevator.variableControl(moveValue); // Duffy-Safe Mode is moveValue*0.75
=======
		if ((turnValue <= 0.2) && (turnValue >= -0.2)){
			turnValue = 0;
		}
		
		// Determine if Boost should be on
		if (boostValue >= 0.75) {
			boostOn = true;
		}
		
		// Send values to Drive Train subsystem -- only if a PID command is not enabled
		Robot.m_DriveTrain.drive(moveValue, turnValue, false);
		Robot.m_DriveTrain.boost(boostOn);
		
>>>>>>> drivesystem-only:src/org/usfirst/frc/team58/robot/commands/Drive.java
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
		Robot.m_Elevator.variableControl(0);
	}
	

}