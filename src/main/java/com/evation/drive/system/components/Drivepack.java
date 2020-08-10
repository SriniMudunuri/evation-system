package com.evation.drive.system.components;

/**
 * This is the POJO class for Drivepack
 * 
 * @author Srinivasa Raju
 *
 */
public class Drivepack {
	private int serialNumber;
	private short softwareVersion;
	private short motorSerialNumber;

	public Drivepack(int serialNumber, short softwareVersion, short motorSerialNumber) {
		super();
		this.serialNumber = serialNumber;
		this.softwareVersion = softwareVersion;
		this.motorSerialNumber = motorSerialNumber;
	}

	public int getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(int serialNumber) {
		this.serialNumber = serialNumber;
	}

	public short getSoftwareVersion() {
		return softwareVersion;
	}

	public void setSoftwareVersion(short softwareVersion) {
		this.softwareVersion = softwareVersion;
	}

	public short getMotorSerialNumber() {
		return motorSerialNumber;
	}

	public void setMotorSerialNumber(short motorSerialNumber) {
		this.motorSerialNumber = motorSerialNumber;
	}

}
