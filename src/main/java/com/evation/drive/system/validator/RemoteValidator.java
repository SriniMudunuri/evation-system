package com.evation.drive.system.validator;

import com.evation.drive.system.components.Remote;

/**
 * This is for validating the Remote production values
 * 
 * @author Srinivasa Raju
 *
 */
public class RemoteValidator {

	private Remote remote;

	public RemoteValidator(Remote remote) {
		super();
		this.remote = remote;
	}

	public boolean validate() {
		if (remote.getSerialNumber() >= 0 && remote.getHMIBoardSerialNumber() >= 0) {
			return true;
		} else {
			System.out.println("Remote production values are not valid");
			return false;
		}

	}
}
