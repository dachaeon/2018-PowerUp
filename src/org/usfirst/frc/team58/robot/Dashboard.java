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
	// public static double elevatorSpeed; <-- Stuff like this
	
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
		autoChooser.addDefault("Default Program: Middle Switch", new MiddleSwitch());
		//autoChooser.addObject("Cross Line", new DriveForward(distance));
		//autoChooser.addObject("Left Switch", new LeftSwitch());
		//autoChooser.addObject("Right Switch", new RightSwitch());
		//autoChooser.addObject("Left Adventurous", new LeftAdventurous());
		//autoChooser.addObject("Right Adventurous", new LeftAdventurous());
		SmartDashboard.putData("Autonomous Mode Chooser", autoChooser);
		
	}
	
	public static Command getAutoProgram() {
		autoCommand = autoChooser.getSelected();
		return autoCommand;
	}
	
}
