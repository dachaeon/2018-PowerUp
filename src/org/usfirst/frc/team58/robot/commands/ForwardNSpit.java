package org.usfirst.frc.team58.robot.commands;

import org.usfirst.frc.team58.robot.Dashboard;
import org.usfirst.frc.team58.robot.Robot;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitForChildren;

public class ForwardNSpit extends CommandGroup {
	public ForwardNSpit() {
		addSequential(new PIDdrive(3,0,0,18));
		//addSequential(new ResetWait(250)); // Wait 1000ms
		//addParallel(new ElevateTime(1000));
		addSequential(new SpitCube());
	}
}
