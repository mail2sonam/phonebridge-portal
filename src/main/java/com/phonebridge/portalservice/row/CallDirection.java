package com.phonebridge.portalservice.row;

public enum CallDirection {
	Outgoing("Outgoing"), Incoming("Incoming"), Both("Outgoing,Incoming");
	private final String calldir;

	CallDirection(String calldir) {
		this.calldir = calldir;
	}
	public String getCalldir() {
		return calldir;
	}
}
