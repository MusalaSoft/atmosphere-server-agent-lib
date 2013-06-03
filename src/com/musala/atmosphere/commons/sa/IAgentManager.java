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
	 * Gets a list of all published and available device wrapper RMI string identifiers on the current Agent.
	 * 
	 * @return List of the DeviceInformation objects, one for every available device on the current Agent.
	 * @throws RemoteException
	 */
	public List<String> getAllDeviceWrappers() throws RemoteException;

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