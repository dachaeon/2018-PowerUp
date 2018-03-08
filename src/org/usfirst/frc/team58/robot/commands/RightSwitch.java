package org.usfirst.frc.team58.robot.commands;

import org.usfirst.frc.team58.robot.Dashboard;
import org.usfirst.frc.team58.robot.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class RightSwitch extends CommandGroup {
	public RightSwitch() {
		if (Robot.gameData != null ) {
		if(Robot.gameData.charAt(0) == 'R') {
			addSequential(new TimeDrive(100, -0.5));
			addSequential(new PIDRotate(0.03,0.006,0.07, 10));
			addSequential(new PIDdrive(145, 0.75));
			addSequential(new ResetWait(500)); // Wait 1000ms
			addSequential(new PIDRotate(0.03,0.006,0.07,-90));
			addParallel(new PIDElevate(Dashboard.SwitchHeight, 5000));
			addParallel(new ForwardNSpit(-0.5));
		} else if(Robot.gameData.charAt(0) == 'L') {
			addSequential(new PIDdrive(192,0.75));
			addSequential(new ResetWait(500)); // Wait 1000ms
			addSequential(new PIDRotate(0.03,0.006,0.07,-90));
			addSequential(new ResetWait(500)); // Wait 1000ms
			/* addSequential(new PIDdrive(3,0,0,192));
			addSequential(new ResetWait(500)); // Wait 1000ms
			addSequential(new PIDRotate(0.03,0.006,0.07,-90)); */
			
		}
		}
	}	
}

