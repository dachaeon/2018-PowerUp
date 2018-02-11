package org.usfirst.frc.team58.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class SpitWaitSpit extends CommandGroup {
	public SpitWaitSpit() {
		addSequential(new SpitCube());
		addSequential(new WaitForTime());
		addSequential(new SpitCube());
	}

}
