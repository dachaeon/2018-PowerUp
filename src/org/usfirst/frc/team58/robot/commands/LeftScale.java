package org.usfirst.frc.team58.robot.commands;

import org.usfirst.frc.team58.robot.Dashboard;
import org.usfirst.frc.team58.robot.Robot;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitForChildren;

public class LeftScale extends CommandGroup {
	public LeftScale() {
		addSequential(new PIDdrive(252, 0.9));
		addSequential(new ResetWait(250));
		addSequential(new PIDRotate(0.03,0.006,0.07, 45));
		addSequential(new GoToScale());
		addSequential(new PIDElevate(0, 1500));
		/* addSequential(new PIDRotate(0.03,0.006,0.07, 70));
		addSequential(new ResetWait(250));
		addSequential(new PIDdrive(56, 0.75));
		addSequential(new PullCube());*/
		//addParallel(new ForwardNSpit());
	}
}
