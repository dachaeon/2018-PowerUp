
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
	private double p = 3;
	private double i = 0;
	private double d = 0;
	
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
    

	public PIDdrive(double distance, double maxSpeed) {
		
		// Require Drivetrain
		requires(Robot.m_DriveTrain);
		// Stop any driving
		Robot.m_DriveTrain.drive(0, 0, false);
		// Zero encoders
		Robot.m_DriveTrain.zeroEncoders();
		
		// Access controller
		source.setPIDSourceType(PIDSourceType.kDisplacement);
		c = new PIDController(p, i, d, source, output);
		
		// Convert the setpoint distance to native units for encoders
		nu_dist = (distance*4096)/(6*Math.PI);
		// Set setpoint
		c.setSetpoint(nu_dist);		
		// Set tolerance
		c.setAbsoluteTolerance((2048)/(6*Math.PI));
		// Set minimum and maximum inputs
		c.setOutputRange(-(maxSpeed), (maxSpeed));
		
		// Set timeout to 15 sec
		//setTimeout(15);
		
		System.out.println("PID drive constructed");
		
		//setInterruptible(false);
		
		//initialize();
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
			angle = angle/30; // scale down angle to make it a small correction. Change scale factor as needed - Emma
		}
		
		System.out.println("output = " + output + "angle = " + angle);
		// send to drive train
		Robot.m_DriveTrain.drive(-output, 0, true); // has to be negative output
		
		//if (isFinished()) {
			//end();
		//} 
	}
	
	@Override
	protected void execute() {
		double output = c.get();
		usePIDOutput(output);

	}

	@Override
	protected boolean isFinished() {
		
		// this was initially Robot.m_DriveTrain.getEncoders() >= nu_dist
		if (c.onTarget()) {
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
		System.out.println("THIS IS THE END");
		c.disable();
		//c.free();
		Robot.m_DriveTrain.drive(0, 0, true);
		Robot.m_DriveTrain.enableDisablePID(false);
	}
	
	@Override
	protected void interrupted() {
		end();
	}

}
