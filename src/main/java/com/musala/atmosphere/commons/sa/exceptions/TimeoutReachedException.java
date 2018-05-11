// This file is part of the ATMOSPHERE mobile testing framework.
// Copyright (C) 2016 MusalaSoft
//
// ATMOSPHERE is free software: you can redistribute it and/or modify
// it under the terms of the GNU General Public License as published by
// the Free Software Foundation, either version 3 of the License, or
// (at your option) any later version.
//
// ATMOSPHERE is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
// GNU General Public License for more details.
//
// You should have received a copy of the GNU General Public License
// along with ATMOSPHERE.  If not, see <http://www.gnu.org/licenses/>.

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
