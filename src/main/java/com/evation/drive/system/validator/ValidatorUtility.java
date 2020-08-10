package com.evation.drive.system.validator;

import com.evation.drive.system.components.BottomBracket;
import com.evation.drive.system.components.Drivepack;
import com.evation.drive.system.components.Remote;

/**
 * @author Srinivasa Raju
 *
 */
public interface ValidatorUtility {

	public static DrivepackValidator getDrivepackValidator(Drivepack drivepack) {
		return new DrivepackValidator(drivepack);
	}

	public static BottomBracketValidator getBottomBracketValidator(BottomBracket bottomBracket) {
		return new BottomBracketValidator(bottomBracket);
	}

	public static RemoteValidator getRemoteValidator(Remote remote) {
		return new RemoteValidator(remote);
	}
}
