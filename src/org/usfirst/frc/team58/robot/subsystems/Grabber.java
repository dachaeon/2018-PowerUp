// Created by Emma and Joe on 01/14/18

package org.usfirst.frc.team58.robot.subsystems;

import org.usfirst.frc.team58.robot.commands.Drive;
import org.usfirst.frc.team58.robot.commands.Grab;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.*;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

public class Grabber extends Subsystem {
	// Put methods for controlling this subsystem
	// here. Call these from Commands.
	
	private WPI_TalonSRX m_RightMotor;
	private WPI_TalonSRX m_LeftMotor;
	//private Solenoid m_releaseSolenoid;
	
	
	public Grabber() {
		// Create motor instances
		m_RightMotor = new WPI_TalonSRX(8); //numbers to be added once we know what is on CANbus
		m_LeftMotor = new WPI_TalonSRX(9);
		//m_releaseSolenoid = new Solenoid(2);
		
		// Add encoders
		m_RightMotor.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 10);
		m_LeftMotor.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 10);
		
	}

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		setDefaultCommand(new Grab());
		
	}
	 
	public void release (boolean releaseActivate) {
		//m_releaseSolenoid.set (releaseActivate);
	}
	
	
	public void grabWheels (double moveValue) {
		m_RightMotor.set (moveValue);
		m_LeftMotor.set (moveValue);
	}
	
	public void turnCube (double turnSpeed) {
		// Passing in 1 will turn cube right
		// Passing in -1 will turn cube left
		m_LeftMotor.set(turnSpeed);
		m_RightMotor.set(-turnSpeed);
	}

}

