package com.musala.atmosphere.commons.sa.exceptions;

/**
 * Thrown when the timeout for an action is reached.
 * 
 * @author yordan.petrov
 * 
 */
public class TimeoutReachedException extends Exception {
    private static final long serialVersionUID = -577310366861237052L;

    public TimeoutReachedException() {
    }

    public TimeoutReachedException(String messgae) {
        super(messgae);
    }

    public TimeoutReachedException(String message, Throwable inner) {
        super(message, inner);
    }
}
