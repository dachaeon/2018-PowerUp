package org.usfirst.frc.team58.robot.commands;

import org.usfirst.frc.team58.robot.Dashboard;
import org.usfirst.frc.team58.robot.Robot;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitForChildren;

public class ForwardNSpit extends CommandGroup {
	public ForwardNSpit(double speed) {
		addSequential(new ResetWait(1400));
		addSequential(new TimeDrive(2000, speed)); //was 30
		//addSequential(new ResetWait(250)); // Wait 1000ms
		//addParallel(new ElevateTime(1000));
		addSequential(new SpitCube());
		addSequential(new TimeDrive(1000, 0.5));
	}
}
