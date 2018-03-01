package org.usfirst.frc.team58.robot.commands;

import org.usfirst.frc.team58.robot.Dashboard;
import org.usfirst.frc.team58.robot.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class LeftSwitch extends CommandGroup {
	public LeftSwitch() {
		if (Robot.gameData != null) {
		if(Robot.gameData.charAt(0) == 'L') {
			addSequential(new ResetWait(500)); // Wait 500ms
			addSequential(new PIDdrive(135, 0.75));
			addSequential(new ResetWait(500)); // Wait 1000ms
			addSequential(new PIDRotate(0.03,0.006,0.07,90));
			addSequential(new ResetWait(100)); // Wait 1000ms
			addSequential(new PIDElevate(Dashboard.SwitchHeight));
			addParallel(new ForwardNSpit());
		}
		if(Robot.gameData.charAt(0) == 'R') {
			addSequential(new ResetWait(500)); // Wait 1000ms
			addSequential(new PIDdrive(210, 0.75));
			addSequential(new ResetWait(500)); // Wait 1000ms
			addSequential(new PIDRotate(0.03,0.006,0.07,90));
			addSequential(new ResetWait(500)); // Wait 1000ms
			addSequential(new PIDdrive(192, 0.75));
			addSequential(new ResetWait(500)); // Wait 1000ms
			addSequential(new PIDRotate(0.03,0.006,0.07,90));
			addSequential(new ResetWait(100));
			addSequential(new PIDElevate(Dashboard.SwitchHeight));
			addParallel(new ForwardNSpit());
		}
	}
	}
}
