// Created by Emma and Joe on 01/13/18

package org.usfirst.frc.team58.robot.subsystems;

import org.usfirst.frc.team58.robot.commands.Drive;
import org.usfirst.frc.team58.robot.commands.VariableElevate;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.*;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Elevator extends Subsystem {
	// Put methods for controlling this subsystem
	// here. Call these from Commands.
	
	private WPI_TalonSRX m_ElevatorMotor;
	
	public Elevator() {
		// Create motor instances
		m_ElevatorMotor = new WPI_TalonSRX(8); //numbers to be added once we know what is on CANbus - Joe
		
		// Add encoders
		m_ElevatorMotor.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 10);
		
		// Configure PID constants
		m_ElevatorMotor.selectProfileSlot(0, 0); // Need to determine PID constants
		m_ElevatorMotor.config_kP(0,  0,  10);
		m_ElevatorMotor.config_kI(0,  0,  10);
		m_ElevatorMotor.config_kD(0,  0,  10);
		
		// Configure MotionMagic cruise velocity and acceleration
		m_ElevatorMotor.configMotionCruiseVelocity(15000, 10); // Need to determine appropriate velocity and acceleration
		m_ElevatorMotor.configMotionAcceleration(6000, 10);
	
	}

	public void initDefaultCommand() {
		setDefaultCommand(new VariableElevate());
	}
	
	public void variableControl(double moveValue) {
		m_ElevatorMotor.set(moveValue);
	}
	
	public void PIDControl (double height) {
		m_ElevatorMotor.set(ControlMode.MotionMagic, height);
	}
	
	public void returnToVariableControl () {
		m_ElevatorMotor.set(ControlMode.PercentOutput, 0);
	}
}

