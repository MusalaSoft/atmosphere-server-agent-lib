package com.musala.atmosphere.commons.sa;

public enum RmiStringConstants
{
	/**
	 * String, under which the AgentManager class is published in the Agent's RMI registry
	 */
	AGENT_MANAGER("AgentManager"),
	/**
	 * String, under which the server's AgentEventSender class is published in the RMI registry.
	 */
	AGENT_EVENT_SENDER("AgentEventSender");

	private String value;

	private RmiStringConstants(String value)
	{
		this.value = value;
	}

	@Override
	public String toString()
	{
		return value;
	}
}
