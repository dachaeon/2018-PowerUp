package org.usfirst.frc.team58.robot.commands;

import org.usfirst.frc.team58.robot.Dashboard;
import org.usfirst.frc.team58.robot.Robot;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitForChildren;

public class LeftScale extends CommandGroup {
	public LeftScale() {
		addSequential((new TrapDrive(233.5858)));
		//addSequential(new ResetWait(250));
		addSequential(new PIDRotate(0.03,0.006,0.07, 20.058));
		addSequential(new GoToScale(1400));
		addSequential(new PIDElevate(-800, 2000));
		addSequential(new ResetWait(158));
		addSequential(new TurnToAngle(95));
		addSequential(new ResetWait(158));
		//addSequential(new PIDdrive(30.58, 0.75));
		addSequential(new ForwardNGrab());
		//addParallel(new ForwardNSpit()); */
	}
}
