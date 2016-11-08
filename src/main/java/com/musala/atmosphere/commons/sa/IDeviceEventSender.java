package com.musala.atmosphere.commons.sa;

import java.rmi.RemoteException;

public interface IDeviceEventSender {

    /**
     * Indicates that device(s) have been connected or removed from an agent. Invoked by agents that handled ADB's
     * IDeviceChangeListener events.
     *
     * @param agentId
     *        The calling agent's ID.
     * @param changedDeviceRmiId
     *        The wrapper RMI ID of the device that changed.
     * @param available
     *        Passed true if the device that changed is now available (connected), false otherwise (disconnected).
     * @throws RemoteException
     *         thrown when an error during the execution of a remote method call.
     */
    public void deviceListChanged(String agentId, String changedDeviceRmiId, boolean available) throws RemoteException;

}
