package com.musala.atmosphere.commons.sa.exceptions;

/**
 * Thrown when the connection to the Android Debug Bridge has failed for some reason.
 * 
 * 
 * @author georgi.gaydarov
 * 
 */
public class ADBridgeFailException extends Exception {
    /**
	 * 
	 */
    private static final long serialVersionUID = 1021075011386922097L;

    public ADBridgeFailException() {
    }

    public ADBridgeFailException(String message) {
        super(message);
    }

    public ADBridgeFailException(String message, Throwable inner) {
        super(message, inner);
    }
}
