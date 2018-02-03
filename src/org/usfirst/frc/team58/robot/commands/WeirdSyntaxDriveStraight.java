package org.usfirst.frc.team58.robot.commands;

import org.usfirst.frc.team58.robot.subsystems.*;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team58.robot.Robot;

public class WeirdSyntaxDriveStraight extends Command {
	
	// Create PIDController named m_pid - Tyler 01/29/18
	private PIDController m_pid;
	
	// DriveStraight constructor - Tyler 01/29/18
	public WeirdSyntaxDriveStraight(double distance) {
		requires(Robot.m_DriveTrain);
		m_pid = new PIDController(4, 0, 0, new PIDSource() {
			PIDSourceType m_sourceType = PIDSourceType.kDisplacement;

			@Override
			public double pidGet() {
				//return Robot.m_DriveTrain.getEncoders();
				return 0;
			}

			@Override
			public void setPIDSourceType(PIDSourceType pidSource) {
				m_sourceType = pidSource;
			}

			@Override
			public PIDSourceType getPIDSourceType() {
				return m_sourceType;
			}
		}, d -> Robot.m_DriveTrain.drive(d, d));
		
		m_pid.setAbsoluteTolerance(0.01);
		m_pid.setSetpoint(distance);
	}
	
	
	
	// Called just before this Command runs the first time
		@Override
		protected void initialize() {
			// Get everything in a safe starting state.
			//Robot.m_DriveTrain.reset();
			m_pid.reset();
			m_pid.enable();
		}

		// Make this return true when this Command no longer needs to run execute()
		@Override
		protected boolean isFinished() {
			return m_pid.onTarget();
		}

		// Called once after isFinished returns true
		@Override
		protected void end() {
			// Stop PID and the wheels
			m_pid.disable();
			Robot.m_DriveTrain.drive(0, 0);
		} 
}
