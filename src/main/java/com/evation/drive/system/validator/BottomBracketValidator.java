package com.evation.drive.system.validator;

import com.evation.drive.system.components.BottomBracket;

/**
 * This is for validating the Bottom Bracket production values
 * 
 * @author Srinivasa Raju
 *
 */
public class BottomBracketValidator {

	private BottomBracket bottomBracket;

	public BottomBracketValidator(BottomBracket bottomBracket) {
		super();
		this.bottomBracket = bottomBracket;
	}

	public boolean validate() {
		if (bottomBracket.getSerialNumber() >= 0 && bottomBracket.getTorqueSensorSerialNumber() >= 0) {
			return true;
		} else {
			System.out.println("Bottom Bracket production values are not valid");
			return false;
		}

	}
}
