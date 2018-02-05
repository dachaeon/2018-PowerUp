package org.usfirst.frc.team58.robot.subsystems;

import org.usfirst.frc.team58.robot.RobotMap;
import org.usfirst.frc.team58.robot.commands.Climb;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;

public class Climber extends Subsystem{
	
	private WPI_TalonSRX m_climbMotor;
	
	public Climber() {
		
		m_climbMotor = new WPI_TalonSRX(RobotMap.climber);
		
	}
	
	public void initDefaultCommand() {
			
		// Nothing goes here! Thats pretty good!	
		
	}
	
	public void climb(double speed){
		m_climbMotor.set(speed);
	}
}
