package org.usfirst.frc.team58.robot.commands;

import org.usfirst.frc.team58.robot.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitForChildren;

public class RightAngle extends CommandGroup {
	public RightAngle() {
		addSequential(new PIDdrive(3,0,0,72));
		
		addSequential(new PIDRotate(0.03,0.006,0.07,90));
	
		addSequential(new PIDdrive(3,0,0,36));
		//if(Robot.gameData.charAt(0) == 'L') {
			//addSequential(new DriveForwward(distance));
			//addSequential(new Rotate(-45));
			//addSequential(new DriveForward(distance));
			//addSequential(new PutCube));
		//}
		//if(Robot.gameData.charAt(0) == 'R') {
			//addSequential(new DriveForwward(distance));
			//addSequential(new Rotate(45));
			//addSequential(new DriveForward(distance));
			//addSequential(new PutCube));
		//}
	}
}
