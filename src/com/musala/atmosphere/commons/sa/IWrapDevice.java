package com.musala.atmosphere.commons.sa;

import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;

import com.musala.atmosphere.commons.BatteryState;
import com.musala.atmosphere.commons.CommandFailedException;
import com.musala.atmosphere.commons.DeviceInformation;
import com.musala.atmosphere.commons.DeviceOrientation;
import com.musala.atmosphere.commons.Pair;

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
	 * Gets the amount of free RAM on the device.
	 * 
	 * @return Memory amount in MB.
	 * @throws RemoteException
	 * @throws CommandFailedException
	 */
	public long getFreeRAM() throws RemoteException, CommandFailedException;

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
	 * Executes a list of shell commands one right after the previous.
	 * 
	 * @param commandsList
	 *        List of string commands that should be executed in the shell of the device.
	 * @return List of string responses, one for each executed shell command.
	 * @throws RemoteException
	 * @throws CommandFailedException
	 */
	public java.util.List<String> executeSequenceOfShellCommands(java.util.List<String> commandsList)
		throws RemoteException,
			CommandFailedException;

	/**
	 * Sets the maximum upload/download speed for the device.
	 * 
	 * @param speeds
	 *        A pair of ints - first for upload, second for download speed.
	 * @throws RemoteException
	 * @throws CommandFailedException
	 */
	public void setNetworkSpeed(Pair<Integer, Integer> speeds) throws RemoteException, CommandFailedException;

	/**
	 * Sets the battery level for this emulator. Available for emulators only.
	 * 
	 * @param level
	 *        The new battery level in percents.
	 * @throws RemoteException
	 * @throws CommandFailedException
	 */
	public void setBatteryLevel(int level) throws RemoteException, CommandFailedException;

	/**
	 * Returns a JPEG compressed display screenshot.
	 * 
	 * @return Image in an array of bytes that, when dumped to a file, shows the device display.
	 * @throws RemoteException
	 * @throws CommandFailedException
	 */
	public byte[] getScreenshot() throws RemoteException, CommandFailedException;

	/**
	 * Creates a new .apk file that will be installed on the current device. Use appendToAPK(Byte[]) and
	 * buildAndInstallAPK() to transfer the file. If another file is being transfered, it will be discarded.
	 * 
	 * @throws RemoteException
	 * @throws IOException
	 *         when a file system error occurs on the agent.
	 */
	public void initAPKInstall() throws RemoteException, IOException;

	/**
	 * Appends bytes to the .apk file that is currently being built. Use buildAndInstallAPK() to install the transfered
	 * .apk file or discardAPK() to discard all transfered data.
	 * 
	 * @param bytes
	 *        Byte array to be appended to the .apk file that is being built.
	 * @throws RemoteException
	 * @throws IOException
	 *         when a file system error occurs on the agent.
	 */
	public void appendToAPK(byte[] bytes) throws RemoteException, IOException;

	/**
	 * Builds the transfered .apk file, uploads and then installs it on the current device.
	 * 
	 * @throws RemoteException
	 * @throws CommandFailedException
	 *         when the install command fails on the device.
	 * @throws IOException
	 *         when a file system error occurs on the agent.
	 */
	public void buildAndInstallAPK() throws RemoteException, IOException, CommandFailedException;

	/**
	 * Discards all transfered .apk file data.
	 * 
	 * @throws RemoteException
	 */
	public void discardAPK() throws RemoteException;

	/**
	 * Gets a {@link DeviceInformation DeviceInformation} structure for the wrapped IDevice in this wrapper.
	 * 
	 * @return The populated {@link DeviceInformation DeviceInformation}.
	 * @throws RemoteException
	 */
	public DeviceInformation getDeviceInformation() throws RemoteException;

	/**
	 * Gets the uiautomator XML dump from a device and returns it as a string.
	 * 
	 * @return UI XML file dump in a string.
	 * @throws RemoteException
	 * @throws CommandFailedException
	 */
	public String getUiXml() throws RemoteException, CommandFailedException;

	/**
	 * Gets the device network latency.
	 * 
	 * @return latency, in ms.
	 * @throws RemoteException
	 */
	public int getNetworkLatency() throws RemoteException;

	/**
	 * Sets the network latency of the device.
	 * 
	 * @param latency
	 *        network latency, in ms.
	 * @throws RemoteException
	 */
	public void setNetworkLatency(int latency) throws RemoteException;

	/**
	 * Gets the battery state of the device.
	 * 
	 * @return a member of the {@link BatteryState BatteryState} enumeration.
	 * @throws RemoteException
	 * @throws CommandFailedException
	 */
	public BatteryState getBatteryState() throws RemoteException, CommandFailedException;

	/**
	 * Sets the battery state of the device.
	 * 
	 * @param state
	 *        new battery state.
	 * @throws RemoteException
	 * @throws CommandFailedException
	 */
	public void setBatteryState(BatteryState state) throws RemoteException, CommandFailedException;

	/**
	 * Gets the power state of the device.
	 * 
	 * @return boolean value; true if power is connected and false if power is disconnected.
	 * @throws CommandFailedException
	 * @throws RemoteException
	 */
	public boolean getPowerState() throws RemoteException, CommandFailedException;

	/**
	 * Sets the power state of the device
	 * 
	 * @param state
	 *        new power state
	 * @throws CommandFailedException
	 * @throws RemoteException
	 */
	public void setPowerState(boolean state) throws RemoteException, CommandFailedException;

	/**
	 * Sets the airplane mode of the testing device.
	 * 
	 * @param airplaneMode
	 *        True if in airplane mode, false if not.
	 * @throws CommandFailedException
	 * @throws RemoteException
	 */
	public void setAirplaneMode(boolean airplaneMode) throws CommandFailedException, RemoteException;

	/**
	 * Sets new orientation of the testing device. Can only be applied on emulators.
	 * 
	 * @param deviceOrientation
	 *        - new device orientation to be set
	 * @throws RemoteException
	 * @throws CommandFailedException
	 */
	public void setOrientation(DeviceOrientation deviceOrientation) throws CommandFailedException, RemoteException;
}
