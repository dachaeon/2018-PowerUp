package org.usfirst.frc.team58.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class ForwardNGrab extends CommandGroup {
	public ForwardNGrab() {
		addParallel(new PIDdrive(20.58, 0.858));
		addParallel(new PullCube());
	}
}
