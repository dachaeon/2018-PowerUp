package org.usfirst.frc.team58.robot.commands;

import org.usfirst.frc.team58.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class ElevateTime extends Command {
	
	private long time;
	private long start;
	
	public ElevateTime(long time) {
		requires(Robot.m_Elevator);
		this.time = time;
	}
	
	protected void initialize() {
		start = System.currentTimeMillis();
		Robot.m_Elevator.variableControl(-.75);
	}
	@Override
	protected boolean isFinished() {
        if(System.currentTimeMillis() < (start + time)) {
        	return false;
        }
        return true;
	}
	
	// Called once after isFinished returns true
    protected void end() {
    	Robot.m_Elevator.variableControl(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }

}
