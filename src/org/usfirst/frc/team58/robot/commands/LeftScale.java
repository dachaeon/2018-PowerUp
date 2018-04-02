package org.usfirst.frc.team58.robot.commands;

import org.usfirst.frc.team58.robot.Dashboard;
import org.usfirst.frc.team58.robot.Robot;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitForChildren;

public class LeftScale extends CommandGroup {
	public LeftScale() {
		addSequential((new TrapDrive(240.5858)));
		//addSequential(new ResetWait(250));
		addSequential(new PIDRotate(0.03,0.006,0.07, 30.058));
		addSequential(new GoToScale());
		addSequential(new PIDElevate(-800, 2000));
		addSequential(new ResetWait(250));
		addSequential(new TurnToAngle(95));
		addSequential(new ResetWait(250));
		//addSequential(new PIDdrive(30.58, 0.75));
		addSequential(new ForwardNGrab());
		//addParallel(new ForwardNSpit()); */
	}
}
