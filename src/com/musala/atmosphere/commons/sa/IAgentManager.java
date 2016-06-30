package com.musala.atmosphere.commons.sa;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import com.musala.atmosphere.commons.sa.exceptions.DeviceNotFoundException;
import com.musala.atmosphere.commons.sa.exceptions.NotPossibleForDeviceException;

/**
 * <p>
 * Common interface for all AgentManagers; used in RMI.
 * </p>
 * 
 * @author georgi.gaydarov
 * 
 */
public interface IAgentManager extends Remote
{
	/**
	 * Gets a list of DeviceInformation for all available devices on the current Agent.
	 * 
	 * @return List of the DeviceInformation objects, one for every available device on the current Agent.
	 * @throws RemoteException
	 */
	public List<DeviceInformation> getAllDevicesInformation() throws RemoteException;

	/**
	 * Creates a wrapper for the device with serial number SN and publishes it in the RMI registry.
	 * 
	 * @param serialNumber
	 *        Serial number of the device which we want wrapped.
	 * @return The string, which the device wrapper is published in the registry under.
	 * @throws RemoteException
	 */
	public String createWrapperForDevice(String serialNumber) throws RemoteException, DeviceNotFoundException;

	/**
	 * Checks if a device with exact serial number is present on this Agent.
	 * 
	 * @param serialNumber
	 *        Serial number of the device we are searching for.
	 * @return True if device with the passed serial number is available on the current agent, false otherwise.
	 * @throws RemoteException
	 */
	public boolean isDevicePresent(String serialNumber) throws RemoteException;

	/**
	 * Gets the DeviceInformation object for a device by it's exact serial number.
	 * 
	 * @param serialNumber
	 *        Serial number of the device.
	 * @return DeviceInformation for the requested device.
	 * @throws RemoteException
	 */
	public DeviceInformation getDeviceInformation(String serialNumber) throws RemoteException, DeviceNotFoundException;

	/**
	 * Creates and starts a new emulator with specific DeviceParameters or just starts an emulator with the
	 * DeviceParameters if such an emulator already exists.
	 * 
	 * @param parameters
	 *        DeviceParameters of the device we want created.
	 * @return DeviceInformation for the started device.
	 * @throws RemoteException
	 */
	public DeviceInformation createEmulator(DeviceParameters parameters) throws RemoteException;

	/**
	 * Closes the process of an emulator specified by it's serial number.
	 * 
	 * @param serialNumber
	 *        Serial number of the emulator we want closed.
	 * @throws RemoteException
	 * @throws NotPossibleForDeviceException
	 * @throws DeviceNotFoundException
	 */
	public void closeEmulator(String serialNumber)
		throws RemoteException,
			DeviceNotFoundException,
			NotPossibleForDeviceException,
			DeviceNotFoundException;

	/**
	 * Wipes all user information of an emulator specified by it's serial number.
	 * 
	 * @param serialNumber
	 *        Serial number of the emulator we want wiped.
	 * @throws RemoteException
	 */
	public void wipeEmulator(String serialNumber) throws RemoteException;

	/**
	 * Erases all emulator files by specified emulator serial number.
	 * 
	 * @param serialNumber
	 *        Serial number of the emulator we want erased.
	 * @throws RemoteException
	 */
	public void eraseEmulator(String serialNumber) throws RemoteException;

	/**
	 * Gets the unique identifier of the current Agent.
	 * 
	 * @return Unique identifier for the current Agent.
	 * @throws RemoteException
	 */
	public String getAgentId() throws RemoteException;

	/**
	 * Registers the server for events, related to changes in the devices on the agent. Should be called after the
	 * server has published it's IAgentEventSender.
	 * 
	 * @param serverIPAddress
	 *        The server's RMI IP address.
	 * @param serverRmiPort
	 *        Port on which the RMI registry is opened.
	 * @throws RemoteException
	 */
	public void registerServer(String serverIPAddress, int serverRmiPort) throws RemoteException;
}