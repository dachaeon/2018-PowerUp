// Created by Tyler, Emma, and Joe on 01/08/18

package org.usfirst.frc.team58.robot.subsystems;

import org.usfirst.frc.team58.robot.commands.Drive;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.*;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

public class DriveTrain extends Subsystem {
	// Put methods for controlling this subsystem
	// here. Call these from Commands.
	
	private WPI_TalonSRX m_FrontRightMotor;
	private WPI_TalonSRX m_FrontLeftMotor;
	private WPI_VictorSPX m_RightSlave;
	private WPI_VictorSPX m_LeftSlave;
	private DifferentialDrive m_drive;
	private Solenoid m_SpeedSolenoid;
	
	
	public DriveTrain() {
		// Create motor instances
		m_FrontRightMotor = new WPI_TalonSRX(2); //numbers to be added once we know what is on CANbus - Tyler
		m_FrontLeftMotor = new WPI_TalonSRX(4);
		m_RightSlave = new WPI_VictorSPX(3);
		m_LeftSlave = new WPI_VictorSPX(5);
		m_SpeedSolenoid = new Solenoid(1);
		
		// Config Victors to follow Talons
		m_RightSlave.follow(m_FrontRightMotor);
		m_LeftSlave.follow(m_FrontLeftMotor);
		
		// Create drive object	
		m_drive = new DifferentialDrive(m_FrontRightMotor, m_FrontLeftMotor);
		
		// Add encoders
		m_FrontRightMotor.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 10);
		m_FrontLeftMotor.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 10);
		
	}

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		setDefaultCommand(new Drive());
		
	}
	
	public void drive (double moveValue, double rotateValue) {
		m_drive.arcadeDrive(moveValue, rotateValue);
		
	}
	 
	public void boost (boolean boostOn) {
		m_SpeedSolenoid.set (boostOn);
	}
	
	
}

