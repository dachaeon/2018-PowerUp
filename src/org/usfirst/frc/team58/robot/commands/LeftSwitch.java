package org.usfirst.frc.team58.robot.commands;

import org.usfirst.frc.team58.robot.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class LeftSwitch extends CommandGroup {
	public LeftSwitch() {
		if(Robot.gameData.charAt(0) == 'L') {
			//addSequential(new DriveForwward(distance));
			//addSequential(new Rotate(90));
			//addSequential(new DriveForward(smallDistance));
			//addSequential(new PutCube));
		}
		if(Robot.gameData.charAt(0) == 'R') {
			//addSequential(new DriveForwward(longerDistance));
			//addSequential(new Rotate(90));
			//addSequential(new DriveForwward(farDistance));
			//addSequential(new Rotate(90));
			//addSequential (new DriveForward(smallDistance));
			//addSequential(new PutCube());
		}
	}
}
