package org.usfirst.frc.team58.robot.commands;

import org.usfirst.frc.team58.robot.Dashboard;
import org.usfirst.frc.team58.robot.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class Middle2Cube extends CommandGroup {
	public Middle2Cube() {
		
		System.out.println("RUNNING MIDDLE 2CUBE");
		if (Robot.gameData != null) {
		if(Robot.gameData.charAt(0) == 'R') {
			//System.out.println("Got the switch on the right");
			/* addSequential(new PIDdrive(31, 0.6)); //36 to 31 at bridgewater 2:55PM 
			addSequential(new ResetWait(250)); // Wait 1000ms
			addSequential(new PIDRotate(0.02,0,0.01,50));
			addSequential(new ResetWait(250)); // Wait 1000ms
			addSequential(new PIDdrive(60, 0.6)); //65
			addSequential(new ResetWait(1000)); // Wait 1000ms 
			addSequential(new PIDRotate(0.02,0,0.01,-40));
			addSequential(new ResetWait(1)); // wait for no time -- resets navx while the robot goes to the switch
			addSequential(new GoToSwitch());
			addSequential(new PIDElevate(-800, 500)); */
			//addSequential(new PIDRotate(0.02,0,0.01, -50));
			//addSequential(new ForwardNGrab());
			addSequential(new TrapDrive(10));
			//addSequential(new ResetWait(250)); // Wait 158ms 
			addSequential(new PIDRotate(0.02,0,0.01, 30.5058));
			addSequential(new ResetWait(158)); // Wait 158ms
			addSequential(new TrapDrive(62.58));
			addSequential(new ResetWait(158));// Wait 158ms 
			//addSequential(new PIDRotate(0.02,0,0.01, 40)); 
			addSequential(new GoToSwitch());
			addSequential(new PIDElevate(-800, 1000));
			addSequential(new TimeDrive(450, 0.9));
			addSequential(new PIDRotate(0.02,0,0.01, -55));
			addSequential(new ResetWait(158)); // 158ms
			addSequential(new ForwardNGrab());
			addSequential(new TimeDrive(300, 0.9));
			//addSequential(new ResetWait(250));
			addSequential(new PIDRotate(0.02,0,0.01, 65));
			addSequential(new ResetWait(158)); // 158ms
			//addSequential(new TrapDrive(15));
			// ADD ANOTHER SMALL DRIVE HERE
			addSequential(new GoToSwitch());
			//addSequential(new SpitCube());
			
			
		} else if(Robot.gameData.charAt(0) == 'L') {
			//System.out.println("Got the switch on the left");
			addSequential(new TrapDrive(10));
			//addSequential(new ResetWait(250));  
			addSequential(new PIDRotate(0.02,0,0.01,-40.0058));
			addSequential(new ResetWait(158)); // Wait 158ms
			addSequential(new TrapDrive(62.58));
			addSequential(new ResetWait(158));// Wait 158ms 
			//addSequential(new PIDRotate(0.02,0,0.01, 40)); 
			addSequential(new GoToSwitch());
			addSequential(new PIDElevate(-800, 1000));
			addSequential(new TimeDrive(450, 0.9));
			addSequential(new PIDRotate(0.02,0,0.01, 55));
			addSequential(new ResetWait(158)); // 158ms
			addSequential(new ForwardNGrab());
			addSequential(new TimeDrive(300, 0.9));
			//addSequential(new ResetWait(250));
			addSequential(new PIDRotate(0.02,0,0.01, -55));
			addSequential(new ResetWait(158)); // 158ms
			//addSequential(new TrapDrive(15));
			// ADD ANOTHER SMALL DRIVE
			addSequential(new GoToSwitch());
			//addSequential(new SpitCube());
		}
		}
		
	}
}
