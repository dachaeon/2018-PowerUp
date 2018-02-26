// Created by Tyler, Emma, and Joe on 01/08/18

package org.usfirst.frc.team58.robot.subsystems;

import org.usfirst.frc.team58.robot.commands.Drive;
import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.SPI;


import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.*;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DriveTrain extends Subsystem {
	// Put methods for controlling this subsystem
	// here. Call these from Commands.
	
	private WPI_TalonSRX m_FrontRightMotor;
	private WPI_TalonSRX m_FrontLeftMotor;
	private WPI_VictorSPX m_RightSlave;
	private WPI_VictorSPX m_LeftSlave;
	private DifferentialDrive m_drive;
	private Solenoid m_SpeedSolenoid;
	private AHRS navx;
	boolean PIDEnabled;
	
	public DriveTrain() {
		// not using PID at start;
		PIDEnabled = false;
		
		// Create motor instances
		m_FrontRightMotor = new WPI_TalonSRX(2); //numbers to be added once we know what is on CANbus - Tyler
		m_FrontLeftMotor = new WPI_TalonSRX(4);
		m_RightSlave = new WPI_VictorSPX(3);
		m_LeftSlave = new WPI_VictorSPX(5);
		m_SpeedSolenoid = new Solenoid(1); 
		
		// Config Victors to follow Talons
		m_RightSlave.follow(m_FrontRightMotor);
		m_LeftSlave.follow(m_FrontLeftMotor);
		
		// Add encoders
		m_FrontRightMotor.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 10);
		m_FrontLeftMotor.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 10);
		m_FrontRightMotor.setSensorPhase(false);
		m_FrontLeftMotor.setSensorPhase(true);
		
		// Create drive object	
		m_drive = new DifferentialDrive(m_FrontRightMotor, m_FrontLeftMotor);
		

		//set PID
		config(); // tells motor controllers what nominal and max signals are

		// add navx
		navx = new AHRS(SPI.Port.kMXP);
		
	}

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		setDefaultCommand(new Drive());
		
	}
	
	public void drive (double moveValue, double rotateValue, boolean usesPID) {
		if (PIDEnabled == usesPID) {
			m_drive.arcadeDrive(moveValue, rotateValue);
		}
		// output data for phase check (only use when setting up)
		SmartDashboard.putNumber("right drive position", m_FrontRightMotor.getSelectedSensorPosition(0));
		SmartDashboard.putNumber("right drive velocity", m_FrontRightMotor.getSelectedSensorVelocity(0));
		SmartDashboard.putNumber("left drive position", m_FrontLeftMotor.getSelectedSensorPosition(0));
		SmartDashboard.putNumber("left drive velocity", m_FrontLeftMotor.getSelectedSensorVelocity(0));
		
	}
	 
	public void boost (boolean boostOn) {
		m_SpeedSolenoid.set (boostOn);
	}
	
	public void zeroEncoders() {
		m_FrontLeftMotor.setSelectedSensorPosition(0,0,10);
		m_FrontRightMotor.setSelectedSensorPosition(0,0,10);
	}
	
	private void config() {
		m_FrontLeftMotor.configNominalOutputForward(0, 10);
		m_FrontLeftMotor.configNominalOutputReverse(0, 10);
		m_FrontLeftMotor.configPeakOutputForward(1, 10);
		m_FrontLeftMotor.configPeakOutputReverse(-1, 10);
		
		m_FrontRightMotor.configNominalOutputForward(0, 10);
		m_FrontRightMotor.configNominalOutputReverse(0, 10);
		m_FrontRightMotor.configPeakOutputForward(1, 10);
		m_FrontRightMotor.configPeakOutputReverse(-1, 10);
	}
	
	public double getEncoders() {
		double left = m_FrontLeftMotor.getSelectedSensorPosition(0);
		double right =  m_FrontRightMotor.getSelectedSensorPosition(0);
		System.out.println("left=" + left);
		System.out.println("right=" + right);
		//return distance in native units (4096/rev)
		return ((left+right)/2);
	}
	
	public double getAngle() {
		return navx.getAngle();
	}
	
	public void zeroNavx() {
		navx.reset();
	}
	
	public void enableDisablePID(boolean b) {
		PIDEnabled = b;
	}
	
}

