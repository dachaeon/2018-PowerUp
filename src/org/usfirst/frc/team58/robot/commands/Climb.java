package org.usfirst.frc.team58.robot.commands;

import org.usfirst.frc.team58.robot.Dashboard;
import org.usfirst.frc.team58.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team58.robot.subsystems.*;

public class Climb extends Command{
	/* T.Hansen 02.08.2017 - This is the climb command, where we tell 
	 * the robot to run the motor to spin the "winch" so that we can
	 * climb up the rope at the end of the match. It also must TURN
	 * OFF ALL OTHER SUBSYSTEMS BESIDES THE CLIMBER.*/
	//Not done. Needs button pressed run the motor. Work in progress.
	double maxClimberCurrent;
	double climberSpeed;
	
	public Climb() {
		
        // Use requires() here to declare subsystem dependencies
    	requires(Robot.m_Climber);
 
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	climberSpeed = 1;
    	Robot.m_Climber.climb(climberSpeed);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.m_Climber.climb(climberSpeed);

    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.m_Climber.climb(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.m_Climber.climb(0);
    }
}
