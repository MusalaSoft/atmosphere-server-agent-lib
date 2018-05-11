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

package com.musala.atmosphere.commons.sa;

import java.io.Serializable;

import com.musala.atmosphere.commons.util.Pair;

/**
 * <p>
 * Information container for properties, which will be used for emulator creation.
 * </p>
 *
 * @author georgi.gaydarov
 *
 */
public class EmulatorParameters implements Serializable {
    private static final long serialVersionUID = -5084666297559414668L;

    /**
     * Desired Android API level.
     */
    private Integer apiLevel;

    /**
     * Desired screen resolution.
     */
    private Pair<Integer, Integer> resolution;

    /**
     * Desired screen dots per inch.
     */
    private Integer dpi;

    /**
     * Desired available random access memory.
     */
    private Long ram;

    /**
     * Desired Android target.
     */
    private String target;

    public Integer getApiLevel() {
        return apiLevel;
    }

    public void setApiLevel(Integer apiLevel) {
        this.apiLevel = apiLevel;
    }

    public Pair<Integer, Integer> getResolution() {
        return resolution;
    }

    public void setResolution(Pair<Integer, Integer> resolution) {
        this.resolution = resolution;
    }

    public Integer getDpi() {
        return dpi;
    }

    public void setDpi(Integer dpi) {
        this.dpi = dpi;
    }

    public Long getRam() {
        return ram;
    }

    public void setRam(Long ram) {
        this.ram = ram;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }
}
