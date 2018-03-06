package org.usfirst.frc.team58.robot.commands;

import org.usfirst.frc.team58.robot.Dashboard;
import org.usfirst.frc.team58.robot.Robot;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitForChildren;

public class LeftScale extends CommandGroup {
	public LeftScale() {
		addSequential(new PIDdrive(252, 0.75));
		addSequential(new ResetWait(250));
		addSequential(new PIDRotate(0.03,0.006,0.07,20));
		addParallel(new PIDElevate(Dashboard.ScaleHeight));
		addParallel(new ForwardNSpit(-0.4));
		//addParallel(new ForwardNSpit());
	}
}
