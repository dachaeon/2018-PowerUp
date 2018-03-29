package org.usfirst.frc.team58.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class DriveLiftScale extends CommandGroup {
	public DriveLiftScale() {
		addParallel(new PIDdrive(221, 0.9));
		addParallel(new WaitThenLift());
	}
}
