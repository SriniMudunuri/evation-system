package com.evation.drive.system.cycle;

import com.evation.drive.system.components.EvationDriveSystem;
import com.evation.drive.system.exceptions.MotorRuntimeException;

/**
 * This program is for implementing the move functionality
 * 
 * @author Srinivasa Raju
 * 
 */
public class MotorCycle {
	EvationDriveSystem evationDriveSystem;

	public MotorCycle(EvationDriveSystem evationDriveSystem) {
		super();
		this.evationDriveSystem = evationDriveSystem;
	}

	/**
	 * This method is used for testing the motor
	 */
	public int move() {
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			throw new MotorRuntimeException("Application is interrupted");
		}
		int min = 80;
		int max = 150;
		return (int) ((Math.random() * (max - min)) + min);
	}

}
