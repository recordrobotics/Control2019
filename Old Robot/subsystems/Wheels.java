/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team6731.robot.subsystems;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team6731.robot.commands.ManualDrive;

/**
 * An example subsystem.  You can replace me with your own Subsystem.
 */
public class Wheels extends Subsystem {
	// Put methods for controlling this subsystem
	// here. Call these from Commands.
	
	Spark frontRight = new Spark(2);
	Spark backRight = new Spark(3);
	SpeedControllerGroup right = new SpeedControllerGroup(frontRight, backRight);
	
	Spark frontLeft = new Spark(0);
	Spark backLeft = new Spark(1);
	SpeedControllerGroup left = new SpeedControllerGroup(frontLeft, backLeft);
	
	public void curvatureDrive(double forward, double rotation) {
		double sens = 0.5;
		left.set(0.2 * (forward - sens*rotation));
		right.set(0.2 * (forward + sens*rotation));
	}
	
	public void stop() {
		left.set(0);
		right.set(0);
	}

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
		setDefaultCommand(new ManualDrive());
	}
}
