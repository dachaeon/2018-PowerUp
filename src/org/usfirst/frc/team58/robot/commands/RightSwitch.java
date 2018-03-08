package org.usfirst.frc.team58.robot.commands;

import org.usfirst.frc.team58.robot.Dashboard;
import org.usfirst.frc.team58.robot.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class RightSwitch extends CommandGroup {
	public RightSwitch() {
		if (Robot.gameData != null ) {
		if(Robot.gameData.charAt(0) == 'R') {
			addSequential(new TimeDrive(100, -0.5)); // Drive forward at half speed for 100ms
			addSequential(new PIDRotate(0.03,0.006,0.07, 10)); // Turn 10 degrees
			addSequential(new PIDdrive(145, 0.75)); // Drive forward 145 inches
			addSequential(new ResetWait(500)); // Wait 500ms
			addSequential(new PIDRotate(0.03,0.006,0.07,-90)); // Rotate -90 degrees
			addParallel(new PIDElevate(Dashboard.SwitchHeight, 5000)); // Bring elevator up to switch height
			addParallel(new ForwardNSpit(-0.5)); // Drive forward, spit, back up
		} else if(Robot.gameData.charAt(0) == 'L') {
			addSequential(new PIDdrive(192,0.75)); //Drive forward 192 inches
			addSequential(new ResetWait(500)); // Wait 500ms
			addSequential(new PIDRotate(0.03,0.006,0.07,-90)); // Turn -90 degrees
			addSequential(new ResetWait(500)); // Wait 500ms
		}
		} else {
			addSequential(new PIDdrive(125, 0.75)); // if no data, just cross auto line
		}
	}	
}

