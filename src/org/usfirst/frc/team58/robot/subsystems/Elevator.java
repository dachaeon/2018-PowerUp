// Created by Emma and Joe on 01/13/18

package org.usfirst.frc.team58.robot.subsystems;

import org.usfirst.frc.team58.robot.RobotMap;
import org.usfirst.frc.team58.robot.commands.Drive;
import org.usfirst.frc.team58.robot.commands.VariableElevate;

import com.ctre.phoenix.ParamEnum;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.*;

import edu.wpi.first.wpilibj.command.Subsystem;

public class Elevator extends Subsystem {
	// Put methods for controlling this subsystem
	// here. Call these from Commands.
	
	private WPI_TalonSRX m_ElevatorMotor;
	
	public Elevator() {
		// Create motor instances
		m_ElevatorMotor = new WPI_TalonSRX(RobotMap.elevator); //numbers to be added once we know what is on CANbus - Joe
		
		// Add encoders
		m_ElevatorMotor.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Absolute, 0, 10);
		m_ElevatorMotor.setInverted(true);
		m_ElevatorMotor.setSensorPhase(true);
		zeroEncoder();
		
		//Configure Talon to clear sensor position on Reverse Limit
		m_ElevatorMotor.configSetParameter(ParamEnum.eClearPositionOnLimitR, 1, 0, 0, 10);
		
		// Configure PID constants
		m_ElevatorMotor.selectProfileSlot(0, 0); // Need to determine PID constants
		m_ElevatorMotor.config_kP(0,  1,  10);
		m_ElevatorMotor.config_kI(0,  0,  10);
		m_ElevatorMotor.config_kD(0,  1,  10);
		//m_ElevatorMotor.config_kF(0, 1, 10);
		m_ElevatorMotor.configAllowableClosedloopError(0, 500, 10);
		
		// Configure MotionMagic cruise velocity and acceleration
		m_ElevatorMotor.configMotionCruiseVelocity(8000, 10); // Need to determine appropriate velocity and acceleration
		m_ElevatorMotor.configMotionAcceleration(2000, 10);
		
		// reduces current to X when it exceeds & for Z milliseconds -- added by Emma 2/3
		m_ElevatorMotor.configContinuousCurrentLimit(40, 0);
		m_ElevatorMotor.configPeakCurrentLimit(50, 0);
		m_ElevatorMotor.configPeakCurrentDuration(100, 0);
		m_ElevatorMotor.enableCurrentLimit(true);
	
	}

	public void initDefaultCommand() {
		setDefaultCommand(new VariableElevate());
	}
	
	public void variableControl(double moveValue) {
		if (moveValue > 0) {
			moveValue = moveValue*0.75; // down speed limit -- negative is UP
		}
		m_ElevatorMotor.set(-moveValue); 
		
		System.out.println(getEncoder()+"   "+ moveValue);
	}
	
	public void PIDControl (double height) {
		m_ElevatorMotor.overrideLimitSwitchesEnable(false); // override limit switch
		m_ElevatorMotor.set(ControlMode.MotionMagic, height);
	}
	
	public void returnToVariableControl () {
		m_ElevatorMotor.overrideLimitSwitchesEnable(true); // stop overriding limit switch
		m_ElevatorMotor.set(ControlMode.PercentOutput, 0);
	}
	
	public void zeroEncoder() {
		m_ElevatorMotor.setSelectedSensorPosition(0, 0, 10);
	}
	
	
	public double getEncoder() {
		return m_ElevatorMotor.getSelectedSensorPosition(0);
	}
}

