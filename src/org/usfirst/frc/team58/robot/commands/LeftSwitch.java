package org.usfirst.frc.team58.robot.commands;

import org.usfirst.frc.team58.robot.Dashboard;
import org.usfirst.frc.team58.robot.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class LeftSwitch extends CommandGroup {
	public LeftSwitch() {
		if (Robot.gameData != null) {
		if(Robot.gameData.charAt(0) == 'L') {
			addSequential(new TimeDrive(100, -0.5)); // Drive forward at half speed for 100ms
			addSequential(new TurnToAngle(-10)); // Turn -10 degrees
			addSequential(new PIDdrive(145, 0.75)); // Drive forward 145 inches
			addSequential(new ResetWait(1000)); // Wait 1000ms
			addSequential(new TurnToAngle(70)); // Turn 70 degrees
			addParallel(new PIDElevate(Dashboard.SwitchHeight, 5000)); // Raise elevator up to switch height
			addParallel(new ForwardNSpit(-0.6)); // Drive forward, spit, and back up
		}
		if(Robot.gameData.charAt(0) == 'R') {
			addSequential(new ResetWait(500)); // Wait 500ms
			addSequential(new TrapDrive(200)); // Drive forward 200 inches
			addSequential(new ResetWait(500)); // Wait 500ms
			addSequential(new TurnToAngle(70)); // Turn 90 degrees
			addSequential(new ResetWait(500)); // Wait 500ms
			//addSequential(new PIDdrive(192, 0.75)); // Drive forward 192 inches
		}
	} else {
		// FAILSAFE
			addSequential(new PIDdrive(125, 0.75));
	}
	}
}
