package org.usfirst.frc.team58.robot.commands;

import org.usfirst.frc.team58.robot.Dashboard;
import org.usfirst.frc.team58.robot.Robot;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitForChildren;

public class GoToSwitchSecond extends CommandGroup {
	public GoToSwitchSecond() {
		addParallel(new PIDElevate(Dashboard.SwitchHeight, 2058));
		addParallel(new ForwardNSpit(-0.5858, 658));
		//addParallel(new ForwardNSpit());
	}
}
