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
			addSequential(new PIDdrive(36, 0.75)); // Drive forward 36 inches
			addSequential(new ResetWait(250)); // Wait 250ms
			addSequential(new PIDRotate(0.03,0.006,0.07,50)); // Rotate 50 degrees
			addSequential(new ResetWait(250)); // Wait 250ms
			addSequential(new PIDdrive(60, 0.75)); // Drive forward 60 inches
			addSequential(new ResetWait(500)); // Wait 500ms
			addSequential(new PIDRotate(0.03,0.006,0.07,-45)); // Rotate -45 degrees
			addParallel(new PIDElevate(Dashboard.SwitchHeight, 5000)); // Bring elevator to switch height
			addParallel(new ForwardNSpit(-0.5)); // Drive forward, spit, back up
			
		} else if(Robot.gameData.charAt(0) == 'L') {
			System.out.println("Got the switch on the left");
			addSequential(new PIDdrive(31, 0.75)); // Drive forward 31 inches
			addSequential(new ResetWait(500)); // Wait 500ms 
			addSequential(new PIDRotate(0.03,0.006,0.07,-50)); //Rotate -50 degrees
			addSequential(new ResetWait(250)); // Wait 250ms
			addSequential(new PIDdrive(60, 0.75)); //Drive 60 inches
			addSequential(new ResetWait(500));// Wait 500ms 
			addSequential(new PIDRotate(0.03,0.006,0.07,35)); // Rotate 35 degrees
			addParallel(new PIDElevate(Dashboard.SwitchHeight, 5000)); // Bring elevator to switch height
			addParallel(new ForwardNSpit(-0.5)); // Drive forward, spit, back up
		}
		} else {
			
			// FAILSAFE. IF GAME DATA IS NULL, IT SHOULD STILL CROSS THE BASELINE BY BACKING UP INTO THE SWITCH.
			
			addSequential(new PIDdrive(36, 0.5)); // Drive Forward 36 inches.
			addSequential(new ResetWait(250)); // Wait 250ms
			addSequential(new PIDRotate(0.03,0.006,0.07,90)); // Rotate 90 degrees
			addSequential(new ResetWait(250)); // Wait 250ms
			addSequential(new PIDdrive(45, 0.5)); // Drive forward 45 inches
			addSequential(new ResetWait(500)); // Wait 500ms
			addSequential(new PIDRotate(0.03,0.006,0.07,90)); // Rotate 90 degrees
			addSequential(new ResetWait(250)); // Wait 250ms
			addSequential(new TimeDrive(2500, 0.5)); // Drive backwards at half speed for 2.5 seconds
	
		}
	}
}
