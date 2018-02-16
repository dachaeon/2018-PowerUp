// Created by Tyler on 01/10/18.

package org.usfirst.frc.team58.robot;
import edu.wpi.first.wpilibj.smartdashboard.*;
import edu.wpi.first.wpilibj.command.*;
import org.usfirst.frc.team58.robot.commands.*;
import org.usfirst.frc.team58.robot.subsystems.*;
import edu.wpi.first.wpilibj.Preferences;

public class Dashboard {
	
	// Autonomous variables for the autonomous mode chooser. - Tyler 01/10/18
	static Command autoCommand;
	public static Preferences prefs;
	static SendableChooser<Command> autoChooser;
	
	// Preferences variables to be edited in the SmartDashboard. - Tyler 01/10/18
	// public static double elevatorSpeed; 
	public static double ScaleHeight = -39900;
	public static double SwitchHeight = 8000;
	public static double ExchangeHeight;
	public static double RestHeight = 0;
	public double rotate_kP;
	public double rotate_kI;
	public double rorate_kD;
	public double drive_kP;
	public double drive_kI;
	public double drive_kD;
	public double elevate_kP;
	public double elevate_kI;
	public double elevate_kD;
	
	// Start the dashboard, add preferences and the autonomous mode chooser. - Tyler 01/10/18
	public static void initDashboard() {
		addPreferences();
		addAutoChooser();
		
	}
	
	// Add preferences. Allows you to edit variables directly from SmartDashboard. - Tyler 01/10/18
	public static void addPreferences(){
		prefs = Preferences.getInstance();
		
	}
	
	// Choose autonomous mode from SmartDashboard before match begins. - Tyler 01/10/18
	public static void addAutoChooser(){
		autoChooser = new SendableChooser<Command>();
		// Make the default auto program Middle Switch. Might change to Cross Line. - Tyler 01/10/18
		autoChooser.addDefault("Default Program: Cross Line", new PIDdrive(3,3,0,125));
		autoChooser.addObject("Middle Switch", new MiddleSwitch());
		autoChooser.addObject("Left Switch", new LeftSwitch());
		autoChooser.addObject("Right Switch", new RightSwitch());
		SmartDashboard.putData("Autonomous Mode Chooser", autoChooser);
		
	}
	
	// Get the autonomous program from the chooser on the Smart Dashboard. - Tyler 01/10/18
	public static Command getAutoProgram() {
		autoCommand = autoChooser.getSelected();
		return autoCommand;
	}
	
	
}
