package org.usfirst.frc.team58.robot.commands;

import org.usfirst.frc.team58.robot.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class ScaleFromLeft extends CommandGroup {
	public ScaleFromLeft() {
		if(Robot.gameData.charAt(1) == 'L') {
			addSequential(new LeftScale());
		} else if (Robot.gameData.charAt(1) == 'R'){
			addSequential(new OppositeSide());
		} else {
			addSequential(new PIDdrive(125, 0.75));
		}
	}
}
