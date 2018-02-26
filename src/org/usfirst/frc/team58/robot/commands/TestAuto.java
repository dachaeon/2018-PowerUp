package org.usfirst.frc.team58.robot.commands;

import org.usfirst.frc.team58.robot.Dashboard;
import org.usfirst.frc.team58.robot.Robot;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitForChildren;

public class TestAuto extends CommandGroup {
	public TestAuto() {
		addParallel(new PIDElevate(Dashboard.ScaleHeight));
		addParallel(new ForwardNSpit());
		//addParallel(new ForwardNSpit());
	}
}
