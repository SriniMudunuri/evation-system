package com.evation.drive.system.components;

/**
 * This is the POJO class for Remote
 * 
 * @author Srinivasa Raju
 *
 */
public class Remote {
	private int serialNumber;
	private short hmiBoardSerialNumber;
	
	public Remote(int serialNumber, short hMIBoardSerialNumber) {
		super();
		this.serialNumber = serialNumber;
		hmiBoardSerialNumber = hMIBoardSerialNumber;
	}

	public int getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(int serialNumber) {
		this.serialNumber = serialNumber;
	}

	public short getHMIBoardSerialNumber() {
		return hmiBoardSerialNumber;
	}

	public void setHMIBoardSerialNumber(short hMIBoardSerialNumber) {
		hmiBoardSerialNumber = hMIBoardSerialNumber;
	}

}
