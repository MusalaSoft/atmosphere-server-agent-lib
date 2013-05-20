package com.musala.atmosphere.commons.sa;

import java.io.Serializable;

import com.musala.atmosphere.commons.sa.util.Pair;

/**
 * <p>
 * Information container for the basic device properties, which will be used in the device selection process.
 * </p>
 * 
 * @author georgi.gaydarov
 * 
 */
public class DeviceInformation implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6289200803789024053L;

	/**
	 * Serial number of the device.
	 */
	private String serialNumber;

	/**
	 * True if this device is an emulator, false if the device is physical.
	 */
	private boolean isEmulator;

	/**
	 * Device screen resolution.
	 */
	private Pair<Integer, Integer> resolution;

	/**
	 * Operating system of the device.
	 */
	private String os;

	/**
	 * Device model.
	 */
	private String model;

	/**
	 * Dots per inch on the device screen.
	 */
	private int dpi;

	/**
	 * Random access memory (RAM) available to the device.
	 */
	private int ram;

	public String getSerialNumber()
	{
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber)
	{
		this.serialNumber = serialNumber;
	}

	public boolean isEmulator()
	{
		return isEmulator;
	}

	public void setEmulator(boolean isEmulator)
	{
		this.isEmulator = isEmulator;
	}

	public Pair<Integer, Integer> getResolution()
	{
		return resolution;
	}

	public void setResolution(Pair<Integer, Integer> resolution)
	{
		this.resolution = resolution;
	}

	public String getOS()
	{
		return os;
	}

	public void setOs(String os)
	{
		this.os = os;
	}

	public String getModel()
	{
		return model;
	}

	public void setModel(String model)
	{
		this.model = model;
	}

	public int getDpi()
	{
		return dpi;
	}

	public void setDpi(int dpi)
	{
		this.dpi = dpi;
	}

	public int getRam()
	{
		return ram;
	}

	public void setRam(int ram)
	{
		this.ram = ram;
	}
}
