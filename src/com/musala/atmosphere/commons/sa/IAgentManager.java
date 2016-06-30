package com.musala.atmosphere.commons.sa;

import java.io.IOException;
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
	 * Creates and starts a new emulator with specific DeviceParameters or just starts an emulator with the
	 * DeviceParameters if such an emulator already exists.
	 * 
	 * @param parameters
	 *        DeviceParameters of the device we want created.
	 * @return Device wrapper identifier.
	 * @throws RemoteException
	 * @throws IOException
	 */
	public void createAndStartEmulator(DeviceParameters parameters) throws RemoteException, IOException;

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
	 * @throws IOException
	 * @throws DeviceNotFoundException
	 * @throws NotPossibleForDeviceException
	 */
	public void eraseEmulator(String serialNumber)
		throws RemoteException,
			IOException,
			DeviceNotFoundException,
			NotPossibleForDeviceException;

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

	/**
	 * Returns the address of the machine that invokes this method.
	 * 
	 * @return IP address identifier.
	 * @throws RemoteException
	 */
	public String getInvokerIpAddress() throws RemoteException;
}