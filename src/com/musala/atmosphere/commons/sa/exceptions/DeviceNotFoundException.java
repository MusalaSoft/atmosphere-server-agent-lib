package com.musala.atmosphere.commons.sa.exceptions;

/**
 * Thrown when a method an Agent method was invoked with serial number of a device that is not present on the Agent.
 * 
 * @author georgi.gaydarov
 * 
 */
public class DeviceNotFoundException extends Exception
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2912674159916966023L;

	public DeviceNotFoundException()
	{
	}

	// Constructor that accepts a message
	public DeviceNotFoundException(String message)
	{
		super(message);
	}

	public DeviceNotFoundException(String message, Throwable inner)
	{
		super(message, inner);
	}
}
