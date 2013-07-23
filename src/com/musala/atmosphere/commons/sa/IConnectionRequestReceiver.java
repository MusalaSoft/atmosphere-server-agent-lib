package com.musala.atmosphere.commons.sa;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * <p>
 * Common interface for the connection request event receiver on the Server, used in RMI.
 * </p>
 * 
 * @author georgi.gaydarov
 * 
 */
public interface IConnectionRequestReceiver extends Remote
{
	/**
	 * Posts a new request for the Server to connect to the invoking machine's IP address at a specified port.
	 * 
	 * @param toPort
	 *        the port at which the Agent's RMI registry is available.
	 * @throws RemoteException
	 */
	public void postConnectionRequest(int toPort) throws RemoteException;
}
