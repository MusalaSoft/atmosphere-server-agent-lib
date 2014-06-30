package com.musala.atmosphere.commons.sa.exceptions;

/**
 * Thrown when a command for real devices only was attempted on an emulator and vice versa.
 * 
 * @author georgi.gaydarov
 * 
 */
public class NotPossibleForDeviceException extends Exception {
    /**
	 * 
	 */
    private static final long serialVersionUID = -5770462758201830157L;

    public NotPossibleForDeviceException() {
    }

    public NotPossibleForDeviceException(String message) {
        super(message);
    }

    public NotPossibleForDeviceException(String message, Throwable inner) {
        super(message, inner);
    }

}
