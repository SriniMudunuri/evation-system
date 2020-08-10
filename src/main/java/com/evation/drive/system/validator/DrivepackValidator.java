package com.evation.drive.system.validator;

import com.evation.drive.system.components.Drivepack;

/**
 * This is for validating the Drivepack production values
 * 
 * @author Srinivasa Raju
 * 
 */
public class DrivepackValidator {
	private Drivepack drivePack;

	public DrivepackValidator(Drivepack drivePack) {
		super();
		this.drivePack = drivePack;
	}

	public boolean validate() {
		if (drivePack.getSerialNumber() >= 0 && drivePack.getSoftwareVersion() >= 0
				&& drivePack.getMotorSerialNumber() >= 0) {
			return true;
		} else {
			System.out.println("Drivepack production values are not valid");

			return false;
		}

	}
}
