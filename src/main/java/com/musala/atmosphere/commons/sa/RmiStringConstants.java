package com.musala.atmosphere.commons.sa;

public enum RmiStringConstants {
    /**
     * String, under which the AgentManager class is published in the Agent's RMI registry
     */
    AGENT_MANAGER("AgentManager"),
    /**
     * String, under which the DeviceManager class is published in the Agent's RMI registry
     */
    DEVICE_MANAGER("DeviceManager"),
    /**
     * String, under which the server's AgentEventSender class is published in the RMI registry.
     */
    AGENT_EVENT_SENDER("AgentEventSender"),
    /**
     * String, under which the server's DeviceEventSender class is published in the RMI registry.
     */
    DEVICE_EVENT_SENDER("DeviceEventSender"),
    /**
     * String, under which the server's {@link ConnectionRequestReceiver ConnectionRequestReceiver} class is published
     * in the RMI registry.
     */
    CONNECTION_REQUEST_RECEIVER("ConnectionRequestReceiver"),
    /**
     * String, under which the {@link AgentEventReceiver AgentEventReceiver} class is published in the RMI registry.
     */
    AGENT_EVENT_RECEIVER("AgentEventReceiver");

    private String value;

    private RmiStringConstants(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
