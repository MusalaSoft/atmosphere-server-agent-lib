package com.musala.atmosphere.commons.sa;

/**
 * Represents the power states of a device.
 * 
 * @author georgi.gaydarov
 * 
 */
public enum BatteryState
{
	UNKNOWN("unknown"), CHARGING("charging"), DISCHARGING("discharging"), NOT_CHARGING("not-charging"), FULL("full");

	private String value;

	private BatteryState(String state)
	{
		this.value = state;
	}

	@Override
	public String toString()
	{
		return value;
	}
}
