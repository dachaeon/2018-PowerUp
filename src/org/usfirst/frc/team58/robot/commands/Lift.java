package org.usfirst.frc.team58.robot.commands;

import org.usfirst.frc.team58.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class Lift extends Command {
	private double speed;
	
	
	public Lift(double speed) {
		// Use requires() here to declare subsystem dependencies
		requires(Robot.m_Lifter);
		this.speed = speed;
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		Robot.m_Lifter.driveLifter(speed);
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		if (Robot.m_Lifter.checkSwitch() == true) {
			System.out.println("Hit it!");
		}
		return Robot.m_Lifter.checkSwitch();
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
		Robot.m_Lifter.driveLifter(0);
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
		end();
	}
}
