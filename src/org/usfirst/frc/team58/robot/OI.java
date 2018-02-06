/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team58.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.buttons.Trigger;
import org.usfirst.frc.team58.robot.commands.*;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	//// CREATING BUTTONS
	// One type of button is a joystick button which is any button on a
	//// joystick.
	// You create one by telling it which joystick it's on and which button
	// number it is.
	// Joystick stick = new Joystick(port);
	// Button button = new JoystickButton(stick, buttonNumber);

	// There are a few additional built in buttons you can use. Additionally,
	// by subclassing Button you can create custom triggers and bind those to
	// commands the same as any other Button.

	//// TRIGGERING COMMANDS WITH BUTTONS
	// Once you have a button, it's trivial to bind it to a button in one of
	// three ways:

	// Start the command when the button is pressed and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenPressed(new ExampleCommand());

	// Run the command while the button is being held down and interrupt it once
	// the button is released.
	// button.whileHeld(new ExampleCommand());

	// Start the command when the button is released and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenReleased(new ExampleCommand());
	
	// Create joysticks driver and operator. Added by Tyler 01/08/18
	public Joystick driver = new Joystick(RobotMap.driver);
	public Joystick operator = new Joystick(RobotMap.operator);

	// Mapping buttons for Elevator. Added by Emma/Joe 01/13/18
	public JoystickButton ScaleHeight = new JoystickButton (operator, RobotMap.y);
	public JoystickButton SwitchHeight = new JoystickButton (operator, RobotMap.b);
	public JoystickButton ExchangeHeight = new JoystickButton (operator, RobotMap.x);
	public JoystickButton RestHeight = new JoystickButton (operator, RobotMap.a);
	public JoystickButton Climb = new JoystickButton (operator, RobotMap.rightBumper);
	public JoystickButton RearElevateUP = new JoystickButton (driver, RobotMap.rightBumper);
	public JoystickButton RearElevateDOWN = new JoystickButton (driver, RobotMap.leftBumper);
	public JoystickButton SpitOutCube = new JoystickButton(operator, 9);
	
	public OI() {
		ScaleHeight.whenPressed(new PIDElevate(Dashboard.ScaleHeight));
		SwitchHeight.whenPressed(new PIDElevate(Dashboard.SwitchHeight));
		ExchangeHeight.whenPressed(new PIDElevate(Dashboard.ExchangeHeight));
		RestHeight.whenPressed(new PIDElevate(Dashboard.RestHeight));
		Climb.whileHeld(new Climb());
		RearElevateUP.whileHeld(new RunRearElevator(0.8));
		RearElevateDOWN.whileHeld(new RunRearElevator(-0.8));
		SpitOutCube.whenPressed(new SpitCube());
		
	}
	
}

