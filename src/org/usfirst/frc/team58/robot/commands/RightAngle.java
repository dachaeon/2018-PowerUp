package org.usfirst.frc.team58.robot.commands;

import org.usfirst.frc.team58.robot.Robot;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitForChildren;

public class RightAngle extends CommandGroup {
	public RightAngle() {
		addSequential(new PIDdrive(3,0,0,120));
		addSequential(new ResetWait(250)); // Wait 1000ms
		addSequential(new PIDRotate(0.03,0.006,0.07,90));
		addSequential(new ResetWait(250)); // Wait 1000ms
		addSequential(new PIDdrive(3,0,0,36));
	}
}
