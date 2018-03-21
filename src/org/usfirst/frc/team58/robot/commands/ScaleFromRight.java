package org.usfirst.frc.team58.robot.commands;

import org.usfirst.frc.team58.robot.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class ScaleFromRight extends CommandGroup {
	public ScaleFromRight() {
		if(Robot.gameData.charAt(1) == 'R') {
			addSequential(new RightScale());
		} else if (Robot.gameData.charAt(1) == 'L'){
			addSequential(new OppositeSide());
		} else {
			addSequential(new PIDdrive(125, 0.75));
		}
	}
}
