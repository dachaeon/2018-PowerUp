package org.usfirst.frc.team58.robot.commands;

import org.usfirst.frc.team58.robot.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class OppositeSide extends CommandGroup {
	public OppositeSide() {
		if(Robot.gameData.charAt(1) == 'L') {
			addSequential(new TrapDrive(200)); 
			addSequential(new ResetWait(500)); // Wait 500ms
			addSequential(new TurnToAngle(-70)); // Turn -90 degrees
			addSequential(new ResetWait(500)); // Wait 500ms
			addSequential(new TrapDrive(181.58)); 
			addSequential(new ResetWait(500));
			addSequential(new TurnToAngle(65));
			addSequential(new GoToScale());
			addSequential(new PIDElevate(0, 1500));
		} else if (Robot.gameData.charAt(1) == 'R') {
			addSequential(new TrapDrive(200)); 
			addSequential(new ResetWait(500)); // Wait 500ms
			addSequential(new TurnToAngle(85)); // Turn -90 degrees
			addSequential(new ResetWait(500)); // Wait 500ms
			addSequential(new TrapDrive(181.58)); 
			addSequential(new ResetWait(500));
			addSequential(new TurnToAngle(-90));
			addSequential(new GoToScale());
		}
	}
}
