package com.musala.atmosphere.commons.sa;

import java.rmi.Remote;
import java.rmi.RemoteException;

import com.musala.atmosphere.commons.RoutingAction;
import com.musala.atmosphere.commons.exceptions.CommandFailedException;

/**
 * <p>
 * Common interface for all device wrappers, used in RMI.
 * </p>
 * 
 * @author georgi.gaydarov
 * 
 */
public interface IWrapDevice extends Remote {
    /**
     * Requests an action invocation on the device wrapper.
     * 
     * @param action
     *        - a {@link RoutingAction} instance that specifies the action to be invoked.
     * @param args
     *        - the action parameters (if required).
     * @return the result from the action invocation.
     * @throws RemoteException
     * @throws CommandFailedException
     */
    public Object route(RoutingAction action, Object... args) throws RemoteException, CommandFailedException;
}
