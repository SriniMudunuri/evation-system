package com.evation.drive.system.service;

import com.evation.drive.system.components.BottomBracket;
import com.evation.drive.system.components.Drivepack;
import com.evation.drive.system.components.EvationDriveSystem;
import com.evation.drive.system.components.Remote;
import com.evation.drive.system.cycle.MotorCycle;
import com.evation.drive.system.exceptions.MotorException;
import com.evation.drive.system.exceptions.MotorRuntimeException;
import com.evation.drive.system.validator.BottomBracketValidator;
import com.evation.drive.system.validator.DrivepackValidator;
import com.evation.drive.system.validator.RemoteValidator;
import com.evation.drive.system.validator.ValidatorUtility;

public class MotorService {

	public String driveSystem(Drivepack drivepack, BottomBracket bottomBracket, Remote remote) throws MotorException {

		String driveSystemStatus = null;

		boolean driveValidateStatus = validateDriveSystem(drivepack, bottomBracket, remote);

		EvationDriveSystem evationDriveSystem = null;
		MotorCycle motorCycle = null;

		if (driveValidateStatus) {
			evationDriveSystem = new EvationDriveSystem(drivepack, bottomBracket, remote);
		} else {
			System.out.println("Evation system is not built due to invalid production values");
		}

		if (evationDriveSystem != null) {
			motorCycle = new MotorCycle(evationDriveSystem);
			System.out.println("Motor cycle is moving");

			int moveStatus = motorCycle.move();
			if (moveStatus >= 85 && moveStatus <= 140) {
				driveSystemStatus = "Motor Cycle is moved successfully" + " with Motor output " + moveStatus + " W";
			} else {
				throw new MotorException("Motoer cycle is failed to move " + "due to " + moveStatus + " W");
			}
		} else {
			throw new MotorException("Evation Drive System is not constructed");
		}
		return driveSystemStatus;
	}

	private boolean validateDriveSystem(Drivepack drivepack, BottomBracket bottomBracket, Remote remote) {
		DrivepackValidator drivepackValidator = ValidatorUtility.getDrivepackValidator(drivepack);
		BottomBracketValidator bottomBracketValidator = ValidatorUtility.getBottomBracketValidator(bottomBracket);
		RemoteValidator remoteValidator = ValidatorUtility.getRemoteValidator(remote);

		boolean drivePackValidate = drivepackValidator.validate();
		boolean bottomBracketValidate = bottomBracketValidator.validate();
		boolean remoteValidate = remoteValidator.validate();

		if (!drivePackValidate) {
			throw new MotorRuntimeException("Drivepack production values are not valid");
		}
		if (!bottomBracketValidate) {
			throw new MotorRuntimeException("Bottom Bracket production values are not valid");
		}
		if (!remoteValidate) {
			throw new MotorRuntimeException("Remote production values are not valid");
		}

		if (drivePackValidate && bottomBracketValidate && remoteValidate) {
			return true;
		} else {
			return false;
		}
	}

}
