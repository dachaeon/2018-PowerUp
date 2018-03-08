
package org.usfirst.frc.team58.robot.commands;

import org.usfirst.frc.team58.robot.Dashboard;
import org.usfirst.frc.team58.robot.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class LeftSide extends CommandGroup {
	public LeftSide() {
		if (Robot.gameData != null ) {
			if(Robot.gameData.charAt(1) == 'L') {
				addSequential(new LeftScale()); //scale is top priority
			} else {
				addSequential(new LeftSwitch()); //switch is second priority
			}
		} else {
			addSequential(new PIDdrive(125, 0.75)); // if no data, just cross auto line
		}
	}	
}


