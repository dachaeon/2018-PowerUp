package org.usfirst.frc.team58.robot.subsystems;

import org.usfirst.frc.team58.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;

public class RearElevator extends Subsystem {
	
	private WPI_TalonSRX m_ElevatorMotor;
	private DigitalInput m_limitSwitch;

	public RearElevator() {
		m_ElevatorMotor = new WPI_TalonSRX(RobotMap.rearElevator);
		m_limitSwitch = new DigitalInput(0);
	}
	
	public void initDefaultCommand() {
		//None
		
	}
	
	public void driveElevator(double speed) {
		m_ElevatorMotor.set(speed);
	}
	
	public boolean checkSwitch() {
		return !m_limitSwitch.get();
		//return false;
	}
	
}
