package org.usfirst.frc.team58.robot.commands;

import org.usfirst.frc.team58.robot.Dashboard;
import org.usfirst.frc.team58.robot.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class MiddleSwitch extends CommandGroup {
	public MiddleSwitch() {
		
		if(Robot.gameData.charAt(0) == 'R') {
			addSequential(new PIDdrive(3,0,0,36)); //36
			addSequential(new ResetWait(250)); // Wait 1000ms
			addSequential(new PIDRotate(0.03,0.006,0.07,50));
			addSequential(new ResetWait(250)); // Wait 1000ms
			addSequential(new PIDdrive(3,0,0,65)); //65
			addSequential(new ResetWait(500)); // Wait 1000ms 
			addSequential(new PIDRotate(0.03,0.006,0.07,-45));
			addSequential(new PIDElevate(Dashboard.SwitchHeight));
			addSequential(new PIDdrive(3,0,0,6));
			addSequential(new SpitCube());
			
		} else if(Robot.gameData.charAt(0) == 'L') {
			addSequential(new PIDdrive(3,0,0,36));
			addSequential(new ResetWait(500)); // Wait 1000ms 
			addSequential(new PIDRotate(0.03,0.006,0.07,-50));
			addSequential(new ResetWait(250)); // Wait 1000ms
			addSequential(new PIDdrive(3,0,0,65));
			addSequential(new ResetWait(250)); // Wait 1000ms 
			addSequential(new PIDRotate(0.03,0.006,0.07,45)); 
			addSequential(new PIDElevate(Dashboard.SwitchHeight));
			addSequential(new PIDdrive(3,0,0,6));
			addSequential(new SpitCube());
		}
		
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
