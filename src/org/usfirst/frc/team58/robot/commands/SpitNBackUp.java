package org.usfirst.frc.team58.robot.commands;

import org.usfirst.frc.team58.robot.Dashboard;
import org.usfirst.frc.team58.robot.Robot;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitForChildren;

public class SpitNBackUp extends CommandGroup {
	public SpitNBackUp() {
		addParallel(new SpitCube());
		addParallel(new TimeDrive(1000, 0.5));
	}
}
