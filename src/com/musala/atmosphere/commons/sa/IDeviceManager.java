package com.musala.atmosphere.commons.sa;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface IDeviceManager extends Remote {

    /**
     * Gets a list of all published and available device wrapper RMI string identifiers on the current Agent.
     * 
     * @return List of the DeviceInformation objects, one for every available device on the current Agent.
     * @throws RemoteException
     */
    public List<String> getAllDeviceWrappers() throws RemoteException;

    public String getAgentId() throws RemoteException;
}
