package org.usfirst.frc.team58.robot.commands;

import org.usfirst.frc.team58.robot.Dashboard;
import org.usfirst.frc.team58.robot.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class MiddleFast extends CommandGroup {
	public MiddleFast() {
		
		System.out.println("RUNNING MIDDLE 2CUBE");
		if (Robot.gameData != null) {
		if(Robot.gameData.charAt(0) == 'R') {
			//System.out.println("Got the switch on the right");;
			addSequential(new TrapDrive(10));
			//addSequential(new ResetWait(250)); // Wait 1000ms 
			addSequential(new PIDRotate(0.02,0,0.01, 42.0058));
			addSequential(new ResetWait(158)); // Wait 1000ms
			addSequential(new TrapDrive(62.58));
			addSequential(new ResetWait(158));// Wait 1000ms 
			//addSequential(new PIDRotate(0.02,0,0.01, 40)); 
			addSequential(new GoToSwitch());
			addSequential(new PIDElevate(-800, 1000));

			
			
		} else if(Robot.gameData.charAt(0) == 'L') {
			//System.out.println("Got the switch on the left");
			addSequential(new TrapDrive(10));
			//addSequential(new ResetWait(250)); // Wait 1000ms 
			addSequential(new PIDRotate(0.02,0,0.01,-36.0058));
			addSequential(new ResetWait(158)); // Wait 1000ms
			addSequential(new TrapDrive(62.58));
			addSequential(new ResetWait(158));// Wait 1000ms 
			//addSequential(new PIDRotate(0.02,0,0.01, 40)); 
			addSequential(new GoToSwitch());
			addSequential(new PIDElevate(-800, 1000));

		}
		}
		

	}
}
