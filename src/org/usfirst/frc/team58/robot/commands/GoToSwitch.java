package org.usfirst.frc.team58.robot.commands;

import org.usfirst.frc.team58.robot.Dashboard;
import org.usfirst.frc.team58.robot.Robot;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitForChildren;

public class GoToSwitch extends CommandGroup {
	public GoToSwitch() {
		addParallel(new PIDElevate(Dashboard.SwitchHeight, 1458));
		addParallel(new ForwardNSpit(-0.55, 658));
		//addParallel(new ForwardNSpit());
	}
}
