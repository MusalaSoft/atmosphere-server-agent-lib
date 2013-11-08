package com.musala.atmosphere.commons.sa;

import java.io.Serializable;

/**
 * A container class that holds information about the system specifications of a device.
 * 
 * @author yordan.petrov
 * 
 */
public class SystemSpecification implements Serializable
{

	private static final long serialVersionUID = 857835791742349779L;

	/**
	 * Total RAM memory available on the device.
	 */
	private long totalRam;

	/**
	 * Free RAM memory available on the device.
	 */
	private long freeRam;

	/**
	 * The number of CPUs available on the device.
	 */
	private int cpuCount;

	/**
	 * Is Intel® HAXM (Hardware Accelerated Execution Manager) is available on the device.
	 */
	private boolean isHaxm;

	/**
	 * Score returned by a SciMark benchmark ran on the device.
	 */
	private double scimarkScore;

	/**
	 * Free disk space available on the device.
	 */
	private long freeDiskSpace;

	/**
	 * Gets the total RAM memory available on the device.
	 * 
	 * @return the total RAM memory available on the device in MBs.
	 */
	public long getTotalRam()
	{
		return totalRam;
	}

	/**
	 * Sets the total RAM memory available on the device.
	 * 
	 * @param totalRam
	 *        - the total RAM memory available on the device in MBs.
	 */
	public void setTotalRam(long totalRam)
	{
		this.totalRam = totalRam;
	}

	/**
	 * Gets the number of CPUs available on the device.
	 * 
	 * @return the number of CPUs available on the device.
	 */
	public int getCpuCount()
	{
		return cpuCount;
	}

	/**
	 * Sets the number of CPUs available on the device.
	 * 
	 * @param cpuCount
	 *        - the number of CPUs available on the device.
	 */
	public void setCpuCount(int cpuCount)
	{
		this.cpuCount = cpuCount;
	}

	/**
	 * A flag showing if Intel® HAXM (Hardware Accelerated Execution Manager) is available on the device.
	 * 
	 * @return true if HAXM is available; false if not.
	 */
	public boolean isHaxm()
	{
		return isHaxm;
	}

	/**
	 * Sets a flag showing if Intel® HAXM (Hardware Accelerated Execution Manager) is available on the device.
	 * 
	 * @param isHaxm
	 *        - true if HAXM is available; false if not.
	 */
	public void setHaxm(boolean isHaxm)
	{
		this.isHaxm = isHaxm;
	}

	/**
	 * Gets the free RAM memory available on the device.
	 * 
	 * @return the free RAM memory available on the device in MBs.
	 */
	public long getFreeRam()
	{
		return freeRam;
	}

	/**
	 * Sets the free RAM memory available on the device.
	 * 
	 * @param freeRam
	 *        - the free RAM memory available on the device in MBs.
	 */
	public void setFreeRam(long freeRam)
	{
		this.freeRam = freeRam;
	}

	/**
	 * Gets a score returned by a SciMark benchmark ran on the device.
	 * 
	 * @return a score returned by a SciMark benchmark ran on the device.
	 */
	public double getScimarkScore()
	{
		return scimarkScore;
	}

	/**
	 * 
	 * Sets the score returned by a SciMark benchmark ran on the device.
	 * 
	 * @param scimarkScore
	 *        - a score returned by a SciMark benchmark ran on the device.
	 */
	public void setScimarkScore(double scimarkScore)
	{
		this.scimarkScore = scimarkScore;
	}

	/**
	 * Gets the free disk space available on the device.
	 * 
	 * @return the free disk space available on the device in MBs.
	 */
	public long getFreeDiskSpace()
	{
		return freeDiskSpace;
	}

	/**
	 * Sets the free disk space available on the device.
	 * 
	 * @param freeDiskSpace
	 *        - the free disk space available on the device in MBs.
	 */
	public void setFreeDiskSpace(long freeDiskSpace)
	{
		this.freeDiskSpace = freeDiskSpace;
	}
}
