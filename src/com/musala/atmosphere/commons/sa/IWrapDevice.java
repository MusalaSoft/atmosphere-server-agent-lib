package com.musala.atmosphere.commons.sa;

import java.rmi.Remote;
import java.rmi.RemoteException;

import com.musala.atmosphere.commons.sa.exceptions.CommandFailedException;
import com.musala.atmosphere.commons.sa.util.Pair;

/**
 * <p>
 * Common interface for all device wrappers, used in RMI.
 * </p>
 * 
 * @author georgi.gaydarov
 * 
 */
public interface IWrapDevice extends Remote
{
	/**
	 * Gets the maximum upload/download speed of the data network, available to the device.
	 * 
	 * @return Network bandwidth in kbit/s.
	 * @throws RemoteException
	 */
	public Pair<Integer, Integer> getNetworkSpeed() throws RemoteException;

	/**
	 * Gets the battery level of the device.
	 * 
	 * @return Capacity in percents.
	 * @throws RemoteException
	 * @throws CommandFailedException
	 */
	public int getBatteryLevel() throws RemoteException, CommandFailedException;

	/**
	 * Gets the CPU type string of the device.
	 * 
	 * @return CPU name identifier.
	 * @throws RemoteException
	 */
	public String getCPUType() throws RemoteException;

	/**
	 * Gets the amount of free RAM on the device.
	 * 
	 * @return Memory amount in MB.
	 * @throws RemoteException
	 */
	public int getFreeRAM() throws RemoteException;

	/**
	 * Executes a command on the device's shell and returns the result of the execution.
	 * 
	 * @param command
	 *        Shell command to be executed
	 * @return Shell response from the command execution.
	 * @throws RemoteException
	 * @throws CommandFailedException
	 */
	public String executeShellCommand(String command) throws RemoteException, CommandFailedException;

	/**
	 * Sets the maximum upload/download speed for the device.
	 * 
	 * @param speeds
	 *        A pair of ints - first for upload, second for download speed.
	 * @throws RemoteException
	 */
	public void setNetworkSpeed(Pair<Integer, Integer> speeds) throws RemoteException;

	/**
	 * Sets the battery level for this emulator. Available for emulators only.
	 * 
	 * @param level
	 *        The new battery level in percents.
	 * @throws RemoteException
	 */
	public void setBatteryLevel(int level) throws RemoteException;

	/**
	 * Returns a JPEG compressed display screenshot.
	 * 
	 * @return Image in an array of bytes that, when dumped to a file, shows the device display.
	 * @throws RemoteException
	 */
	public Byte[] getScreenshot() throws RemoteException;

	/**
	 * Creates a new .apk file that will be installed on the current device. Use appendToAPK(Byte[]) and
	 * buildAndInstallAPK() to tranfer the file. If another file is being tranfered, it will be discarded.
	 * 
	 * @throws RemoteException
	 */
	public void initAPKInstall() throws RemoteException;

	/**
	 * Appends bytes to the .apk file that is currently being built. Use buildAndInstallAPK() to install the transfered
	 * .apk file or discardAPK() to discard all transfered data.
	 * 
	 * @param bytes
	 *        Byte array to be appended to the .apk file that is being built.
	 * @throws RemoteException
	 */
	public void appendToAPK(Byte[] bytes) throws RemoteException;

	/**
	 * Builds the transfered .apk file, uploads and then installs it on the current device.
	 * 
	 * @throws RemoteException
	 */
	public void buildAndInstallAPK() throws RemoteException;

	/**
	 * Discards all transfered .apk file data.
	 * 
	 * @throws RemoteException
	 */
	public void discardAPK() throws RemoteException;

}
