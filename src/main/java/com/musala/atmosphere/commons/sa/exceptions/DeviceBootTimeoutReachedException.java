package com.musala.atmosphere.commons.sa.exceptions;

/**
 * Thrown when the device boot timeout has been reached.
 * 
 * @author yordan.petrov
 * 
 */
public class DeviceBootTimeoutReachedException extends Exception {
    private static final long serialVersionUID = -4939626628484939841L;

    public DeviceBootTimeoutReachedException() {
    }

    public DeviceBootTimeoutReachedException(String messgae) {
        super(messgae);
    }

    public DeviceBootTimeoutReachedException(String message, Throwable inner) {
        super(message, inner);
    }
}
