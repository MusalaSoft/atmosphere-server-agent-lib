package com.musala.atmosphere.commons.sa;

import java.io.IOException;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import com.musala.atmosphere.commons.exceptions.CommandFailedException;
import com.musala.atmosphere.commons.sa.exceptions.DeviceBootTimeoutReachedException;
import com.musala.atmosphere.commons.sa.exceptions.DeviceNotFoundException;
import com.musala.atmosphere.commons.sa.exceptions.NotPossibleForDeviceException;
import com.musala.atmosphere.commons.sa.exceptions.TimeoutReachedException;

/**
 * <p>
 * Common interface for all AgentManagers; used in RMI.
 * </p>
 * 
 * @author georgi.gaydarov
 * 
 */
public interface IAgentManager extends Remote {
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
    public String createAndStartEmulator(EmulatorParameters parameters) throws RemoteException, IOException;

    /**
     * Closes the process of an emulator specified by it's serial number.
     * 
     * @param serialNumber
     *        Serial number of the emulator we want closed.
     * @throws RemoteException
     * @throws NotPossibleForDeviceException
     * @throws DeviceNotFoundException
     */
    public void closeAndEraseEmulator(String serialNumber)
        throws RemoteException,
            DeviceNotFoundException,
            IOException,
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

    /**
     * Gets the hardware specifications of the device the agent is running on.
     * 
     * @return {@link SystemSpecification} object describing the specifications of the device the agent is running on.
     * @throws RemoteException
     */
    public SystemSpecification getSpecification() throws RemoteException;

    /**
     * Returns a score based on how well an emulator with given parameters will perform on the agent.
     * 
     * @param requiredDeviceParameters
     *        - the parameters of the emulator device.
     * @return a score based on how well the emulator will perform on the agent.
     * @throws RemoteException
     */
    public double getPerformanceScore(EmulatorParameters requiredDeviceParameters) throws RemoteException;

    /**
     * Checks whether any emulator device is present on the agent.
     * 
     * @return true if an emulator device is found on the agent, false if not.
     * @throws RemoteException
     */
    public boolean isAnyEmulatorPresent() throws RemoteException;

    /**
     * Gets the serial number of an emulator with given AVD name.
     * 
     * @param emulatorName
     *        - the AVD name of the emulator.
     * @return the serial number of the emulator.
     * @throws RemoteException
     * @throws DeviceNotFoundException
     */
    public String getSerialNumberOfEmulator(String emulatorName) throws RemoteException, DeviceNotFoundException;

    /**
     * Waits until an emulator device with given AVD name is present on the agent or the timeout is reached.
     * 
     * @param emulatorName
     *        - the AVD name of the emulator.
     * @param timeout
     *        - the timeout in milliseconds.
     * @throws RemoteException
     * @throws TimeoutReachedException
     */
    public void waitForEmulatorExists(String emulatorName, long timeout)
        throws RemoteException,
            TimeoutReachedException;

    /**
     * Waits until an emulator device with given AVD name boots or the timeout is reached. Make sure you have called
     * {@link #waitForEmulatorExists(String, long)} first.
     * 
     * @param emulatorName
     *        - the AVD name of the emulator.
     * @param timeout
     *        - the timeout in milliseconds.
     * @throws RemoteException
     * @throws CommandFailedException
     * @throws DeviceBootTimeoutReachedException
     * @throws DeviceNotFoundException
     */
    public void waitForEmulatorToBoot(String emulatorName, long timeout)
        throws RemoteException,
            CommandFailedException,
            DeviceBootTimeoutReachedException,
            DeviceNotFoundException;

    /**
     * Gets a list of all published and available device wrapper RMI string identifiers on the current Agent.
     * 
     * @return List of the DeviceInformation objects, one for every available device on the current Agent.
     * @throws RemoteException
     */
    public List<String> getAllDeviceRmiIdentifiers() throws RemoteException;

    /**
     * Waits until a device with given serial number is present on the agent or the timeout is reached.
     * 
     * @param serialNumber
     *        - the serial number of the device.
     * @param timeout
     *        - the timeout in milliseconds.
     * @throws RemoteException
     * @throws TimeoutReachedException
     */
    public void waitForDeviceExists(String serialNumber, long timeout) throws RemoteException, TimeoutReachedException;

    /**
     * Checks if any device is present on the agent (current machine).
     * 
     * @return true if a device is present, false otherwise.
     * @throws RemoteException
     */
    public boolean isAnyDevicePresent() throws RemoteException;

    /**
     * Gets the first available device that is present on the agent (current machine).
     * 
     * @return the first available device wrapper ({@link IWrapDevice} interface).
     * @throws RemoteException
     * @throws NotBoundException
     */
    public IWrapDevice getFirstAvailableDeviceWrapper() throws RemoteException, NotBoundException;

    /**
     * Gets the first available emulator device that is present on the agent (current machine).
     * 
     * @return the first available emulator wrapper ({@link IWrapDevice} interface).
     * @throws RemoteException
     * @throws NotBoundException
     */
    public IWrapDevice getFirstAvailableEmulatorDeviceWrapper() throws RemoteException, NotBoundException;

    /**
     * Returns a unique identifier for this device, which will be used as a publishing string for the wrapper of the
     * device in RMI.
     * 
     * @param deviceSerialNumber
     *        serial numver of the device we want to get unique identifier for.
     * @return unique identifier for the device.
     */
    public String getRmiWrapperBindingIdentifier(String deviceSerialNumber)
        throws RemoteException,
            DeviceNotFoundException;
}