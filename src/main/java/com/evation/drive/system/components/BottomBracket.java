package com.evation.drive.system.components;

/**
 * This is the POJO class for Bottom Bracket
 * 
 * @author Srinivasa Raju
 *
 */
public class BottomBracket {
	
	private int serialNumber;
	private int torqueSensorSerialNumber;

	
	public BottomBracket(int serialNumber, int torqueSensorSerialNumber) {
		super();
		this.serialNumber = serialNumber;
		this.torqueSensorSerialNumber = torqueSensorSerialNumber;
	}

	public int getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(int serialNumber) {
		this.serialNumber = serialNumber;
	}

	public int getTorqueSensorSerialNumber() {
		return torqueSensorSerialNumber;
	}

	public void setTorqueSensorSerialNumber(int torqueSensorSerialNumber) {
		this.torqueSensorSerialNumber = torqueSensorSerialNumber;
	}

}
