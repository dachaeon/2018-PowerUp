package org.usfirst.frc.team58.robot.commands;

import org.usfirst.frc.team58.robot.Robot;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.command.PIDCommand;

public class PIDRotate extends PIDCommand {

	PIDController c;
	private double p = 0.03; 
	private double i = 0.006;
	private double d = 0.07;
	
	public PIDRotate(double p, double i, double d, double angle){
		super(p, i, d);
		// Access controller and set setpoint
		c = getPIDController();
		c.setSetpoint(angle);
		// Access Drive Train
		requires(Robot.m_DriveTrain);
		setTimeout(5);
		c.setAbsoluteTolerance(1);
	}
	
	@Override
	protected void initialize() {
		Robot.m_DriveTrain.zeroNavx();
		Robot.m_DriveTrain.enableDisablePID(true);
		c.enable();
		
	}

	@Override
	protected double returnPIDInput() {
		double angle = Robot.m_DriveTrain.getAngle();
		System.out.println(angle);
		return Robot.m_DriveTrain.getAngle();
	}

	@Override
	protected void usePIDOutput(double output) {
		System.out.println(output);
		Robot.m_DriveTrain.drive(0, output, true);
	}

	@Override
	protected boolean isFinished() {
		// normally if (c.onTarget())
		if (c.onTarget()) {
			System.out.println("finished");
			return true;
		} else {
			System.out.println("not there yet");
			return false;
		}
		
		
	}

	@Override
	protected void end() {
		//c.free();
		c.disable();
		Robot.m_DriveTrain.enableDisablePID(false);
	}
	
	@Override
	protected void interrupted() {
		end();
	}

}
