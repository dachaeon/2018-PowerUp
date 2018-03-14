package org.usfirst.frc.team58.robot.commands;

import org.usfirst.frc.team58.robot.Dashboard;
import org.usfirst.frc.team58.robot.Robot;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitForChildren;

public class GoToScale extends CommandGroup {
	public GoToScale() {
		addParallel(new PIDElevate(Dashboard.ScaleHeight, 4000));
		addParallel(new ForwardNSpit(-0.47));
		//addParallel(new ForwardNSpit());
	}
}
