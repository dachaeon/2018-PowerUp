package org.usfirst.frc.team58.robot.commands;

import org.usfirst.frc.team58.robot.Robot;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.PIDCommand;

public class PIDdrive extends Command {
	
	private double nu_dist;
	private PIDController c;
	
    private PIDSource source = new PIDSource() {
    	PIDSourceType t = null;
    	
        public double pidGet() {
            return returnPIDInput();
        }

		@Override
		public void setPIDSourceType(PIDSourceType pidSource) {
			t = pidSource;
		}

		@Override
		public PIDSourceType getPIDSourceType() {
			// TODO Auto-generated method stub
			return t;
		}
    };
    
    private PIDOutput output = new PIDOutput() {

        public void pidWrite(double output) {
            usePIDOutput(output);
        }
    };
    

	public PIDdrive(double p, double i, double d, double distance) {
		//require drivetrain -- zero encoders
		requires(Robot.m_DriveTrain);
		Robot.m_DriveTrain.drive(0, 0, false);
		Robot.m_DriveTrain.zeroEncoders();
		
		// access controller
		source.setPIDSourceType(PIDSourceType.kDisplacement);
		c = new PIDController(p, i, d, source, output);
		
		// convert setpoint distance to native units for encoders
		nu_dist = (distance*4096)/(6*Math.PI);
		c.setSetpoint(nu_dist);		
		// set minimum and maximum inputs
		//setInputRange(-0.5, 0.5);
		
		// set timeout to 15 sec
		//setTimeout(15);
		
		System.out.println("PID drive constructed");
		
		initialize();
	}
	
	@Override
	protected void initialize () {
		Robot.m_DriveTrain.drive(0, 0,true);
		c.enable();
		Robot.m_DriveTrain.enableDisablePID(true);
	}

	
	protected double returnPIDInput() {
		double input = Robot.m_DriveTrain.getEncoders();
		System.out.println("input = " +input);
		return input;
	}

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
	protected void execute() {
		double output = c.get();
		usePIDOutput(output);
		
	}

	@Override
	protected boolean isFinished() {
		
		// apparently never runs either???
		if (Robot.m_DriveTrain.getEncoders() >= nu_dist ) {
			System.out.println("at setpoint");
			return true; // if you go to the setpoint, stop
		} 
//		else if (isTimedOut()) {
//			System.out.println("past time");
//			return true; // will safely end command after 15 seconds. can make shorter up in constructor
//		}
		else {
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
