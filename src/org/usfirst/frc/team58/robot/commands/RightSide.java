
package org.usfirst.frc.team58.robot.commands;

import org.usfirst.frc.team58.robot.Dashboard;
import org.usfirst.frc.team58.robot.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class RightSide extends CommandGroup {
	public RightSide() {
			if(Robot.gameData.charAt(1) == 'R') {
				addSequential(new RightScale());
			} else {
				addSequential(new PIDdrive(125, 0.75)); // changed to cross line for SEMass
			}
	}	
}

