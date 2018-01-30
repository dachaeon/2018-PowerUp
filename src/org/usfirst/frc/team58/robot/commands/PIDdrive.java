package org.usfirst.frc.team58.robot.commands;

import org.usfirst.frc.team58.robot.Robot;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.PIDCommand;

public class PIDdrive extends PIDCommand {
	
	private double nu_dist;
	private PIDController c;

	public PIDdrive(double p, double i, double d, double distance) {
		super(p, i, d);
		//require drivetrain -- zero encoders
		requires(Robot.m_DriveTrain);
		Robot.m_DriveTrain.drive(0, 0, false);
		Robot.m_DriveTrain.zeroEncoders();
		
		// access controller
		c = getPIDController();
		
		// convert setpoint distance to native units for encoders
		nu_dist = (distance*4096)/(6*Math.PI);
		setSetpoint(nu_dist);
		
		// set minimum and maximum inputs
		//setInputRange(-0.5, 0.5);
		
		// set timeout to 15 sec
		setTimeout(15);
		
		System.out.println("PID drive constructed");
		
		initialize();
	}
	
	@Override
	protected void initialize () {
		Robot.m_DriveTrain.drive(0, 0,true);
		c.enable();
		Robot.m_DriveTrain.enableDisablePID(true);
	}
	
	@Override
	protected void execute() {
		System.out.println("hello"); // apparently this never runs??
	}

	@Override
	protected double returnPIDInput() {
		double input = Robot.m_DriveTrain.getEncoders();
		System.out.println("input = " +input);
		return input;
	}

	@Override
	protected void usePIDOutput(double output) {
		
		// get angle correction
		double angle = Robot.m_DriveTrain.getAngle();
		if (Math.abs(angle)<2) {
			angle = 0;
		
		
		} else {
			angle = angle/100; // scale down angle to make it a small correction. Change scale factor as needed - Emma
		}
		
		System.out.println("output = " + output + "angle = " + angle);
		// send to drive train
		Robot.m_DriveTrain.drive(-output, 0, true); // has to be negative output
		
		if (isFinished()) {
			end();
		}
	}
	

	@Override
	protected boolean isFinished() {
		
		// apparently never runs either???
		if (Robot.m_DriveTrain.getEncoders() >= nu_dist ) {
			System.out.println("at setpoint");
			return true; // if you go to the setpoint, stop
		} else if (isTimedOut()) {
			System.out.println("past time");
			return true; // will safely end command after 15 seconds. can make shorter up in constructor
		} else {
			System.out.println("not there yet");
			return false;
		}
	}
	@Override
	protected void end() {
		c.disable();
		Robot.m_DriveTrain.drive(0, 0, true);
		Robot.m_DriveTrain.enableDisablePID(false);
	}
	
	@Override
	protected void interrupted() {
		c.disable();
		Robot.m_DriveTrain.drive(0, 0, true);
		Robot.m_DriveTrain.enableDisablePID(false);

	}

}
