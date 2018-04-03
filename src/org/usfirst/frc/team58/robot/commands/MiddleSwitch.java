package org.usfirst.frc.team58.robot.commands;

import org.usfirst.frc.team58.robot.Dashboard;
import org.usfirst.frc.team58.robot.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class MiddleSwitch extends CommandGroup {
	public MiddleSwitch() {
		
		System.out.println("RUNNING MIDDLE SWITCH");
		if (Robot.gameData != null) {
		if(Robot.gameData.charAt(0) == 'R') {
			System.out.println("Got the switch on the right");
			addSequential(new PIDdrive(31, 0.6)); //36 to 31 at bridgewater 2:55PM 
			addSequential(new ResetWait(250)); // Wait 1000ms
			addSequential(new PIDRotate(0.02,0,0.01,50));
			addSequential(new ResetWait(250)); // Wait 1000ms
			addSequential(new PIDdrive(60, 0.6)); //65
			addSequential(new ResetWait(1000)); // Wait 1000ms 
			addSequential(new PIDRotate(0.02,0,0.01,-40));
			addSequential(new ResetWait(1)); // wait for no time -- resets navx while the robot goes to the switch
			addSequential(new GoToSwitch());
			addSequential(new PIDElevate(-800, 500));
			//addSequential(new PIDRotate(0.02,0,0.01, -50));
			//addSequential(new ForwardNGrab());
			
			
		} else if(Robot.gameData.charAt(0) == 'L') {
			System.out.println("Got the switch on the left");
			addSequential(new PIDdrive(31, 0.6));
			addSequential(new ResetWait(500)); // Wait 1000ms 
			addSequential(new PIDRotate(0.02,0,0.01,-55));
			addSequential(new ResetWait(250)); // Wait 1000ms
			addSequential(new PIDdrive(60, 0.6));
			addSequential(new ResetWait(1000));// Wait 1000ms 
			addSequential(new PIDRotate(0.02,0,0.01, 40)); 
			addParallel(new PIDElevate(Dashboard.SwitchHeight, 5000));
			addParallel(new ForwardNSpit(-0.4));
			//addSequential(new SpitCube());
		}
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
