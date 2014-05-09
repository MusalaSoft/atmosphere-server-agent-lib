package com.musala.atmosphere.commons.sa;

import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import com.musala.atmosphere.commons.sa.exceptions.DeviceNotFoundException;
import com.musala.atmosphere.commons.sa.exceptions.TimeoutReachedException;

/**
 * <p>
 * Common interface for all DeviceManager; used in RMI.
 * </p>
 * 
 * @author yordan.petrov
 * 
 */
public interface IDeviceManager extends Remote {

    /**
     * Gets a list of all published and available device wrapper RMI string identifiers on the current Agent.
     * 
     * @return List of the DeviceInformation objects, one for every available device on the current Agent.
     * @throws RemoteException
     */
    public List<String> getAllDeviceWrappers() throws RemoteException;

    /**
     * Gets the unique identifier of the current Agent.
     * 
     * @return Unique identifier for the current Agent.
     * @throws RemoteException
     */
    public String getAgentId() throws RemoteException;

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
     * @throws DeviceNotFoundException
     */
    public IWrapDevice getFirstAvailableDeviceWrapper()
        throws RemoteException,
            NotBoundException,
            DeviceNotFoundException;

    /**
     * Gets the first available emulator device that is present on the agent (current machine).
     * 
     * @return the first available emulator wrapper ({@link IWrapDevice} interface).
     * @throws RemoteException
     * @throws NotBoundException
     * @throws DeviceNotFoundException
     */
    public IWrapDevice getFirstAvailableEmulatorDeviceWrapper()
        throws RemoteException,
            NotBoundException,
            DeviceNotFoundException;
}
