package org.usfirst.frc.team58.robot.commands;

import org.usfirst.frc.team58.robot.Dashboard;
import org.usfirst.frc.team58.robot.Robot;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitForChildren;

public class WaitThenLift extends CommandGroup {
	public WaitThenLift() {
		addSequential(new Wait(1000));
		addParallel(new PIDElevate(Dashboard.ScaleHeight/2, 3000));
	}
}
