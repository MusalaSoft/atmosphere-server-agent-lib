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
public class DeviceParameters implements Serializable {
    /**
	 * 
	 */
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

    public int getApiLevel() {
        return apiLevel;
    }

    public void setApiLevel(int apiLevel) {
        this.apiLevel = apiLevel;
    }

    public Pair<Integer, Integer> getResolution() {
        return resolution;
    }

    public void setResolution(Pair<Integer, Integer> resolution) {
        this.resolution = resolution;
    }

    public int getDpi() {
        return dpi;
    }

    public void setDpi(int dpi) {
        this.dpi = dpi;
    }

    public long getRam() {
        return ram;
    }

    public void setRam(long ram) {
        this.ram = ram;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }
}
