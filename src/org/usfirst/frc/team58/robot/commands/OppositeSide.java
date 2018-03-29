package org.usfirst.frc.team58.robot.commands;

import org.usfirst.frc.team58.robot.Dashboard;
import org.usfirst.frc.team58.robot.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class OppositeSide extends CommandGroup {
	public OppositeSide() {
		if(Robot.gameData.charAt(1) == 'L') {
			addSequential(new TrapDrive(210)); 
			addSequential(new ResetWait(250)); // Wait 500ms
			addSequential(new TurnToAngle(-70)); // Turn -90 degrees
			addSequential(new ResetWait(250)); // Wait 500ms
			addSequential(new TrapDrive(188)); 
			addSequential(new ResetWait(250));
			addSequential(new TurnToAngle(65));
			addSequential(new GoToScale());
			addSequential(new PIDElevate(0, 1500));
		} else if (Robot.gameData.charAt(1) == 'R') {
			addSequential(new TrapDrive(210)); 
			addSequential(new ResetWait(250)); // Wait 500ms
			addSequential(new TurnToAngle(75)); // Turn -90 degrees
			addSequential(new ResetWait(10)); // Wait 500ms- reduced to 10ms because we added the PID Elevate after
			addSequential(new PIDElevate(Dashboard.SwitchHeight, 750));
			addSequential(new TrapDrive(188));  
			addSequential(new ResetWait(250));
			addSequential(new TurnToAngle(-70));
			addSequential(new GoToScale());
		}
	}
}
