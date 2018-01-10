// Created by Tyler, Emma, and Joe on 01/08/18

package org.usfirst.frc.team58.robot.subsystems;

import org.usfirst.frc.team58.robot.commands.Drive;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class DriveTrain extends Subsystem {
	// Put methods for controlling this subsystem
	// here. Call these from Commands.
	
	private WPI_TalonSRX m_FrontRightMotor;
	private WPI_TalonSRX m_FrontLeftMotor;
	private WPI_TalonSRX m_RightSlave;
	private WPI_TalonSRX m_LeftSlave;
	
	
	public DriveTrain() {
		m_FrontRightMotor = new WPI_TalonSRX(3); //numbers to be added once we know what is on CANbus - Tyler
		m_FrontLeftMotor = new WPI_TalonSRX(4);
		m_RightSlave = new WPI_TalonSRX(5);
		m_LeftSlave = new WPI_TalonSRX(6);
		
		m_RightSlave.set(com.ctre.pheonix.MotorControl.ControlMode.Follower, 3);
		m_LeftSlave.set(com.ctre.pheonix.MotorControl.ControlMode.Follower, 4);
	}

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		setDefaultCommand(new Drive());
	}
}

