package com.musala.atmosphere.commons.sa;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Common interface for the events sent by the Server to the agents, used in RMI.
 *
 * @author filareta.yordanova
 *
 */
public interface IServerEventSender extends Remote {
    /**
     * Tests whether connection between server and agent still exists.
     *
     * @throws RemoteException
     *         - if an error during the execution of a remote method call
     */
    public void pingAgent() throws RemoteException;
}
