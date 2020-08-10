package com.evation.drive.system.components;

/**
 * This is for assembling Drivepack, Bottom Bracket and Remote components
 * 
 * @author Srinivasa Raju
 *
 */
public class EvationDriveSystem {
	Drivepack drivepack;
	BottomBracket bottomBracket;
	Remote remote;
	public EvationDriveSystem(Drivepack drivepack, BottomBracket bottomBracket, Remote remote) {
		super();
		this.drivepack = drivepack;
		this.bottomBracket = bottomBracket;
		this.remote = remote;
	}
	
	

}
