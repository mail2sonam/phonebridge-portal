package com.phonebridge.portalservice.row;

public enum Account {
	Brandcare("Brandcare"), eupraxia("eupraxia"), kritilabs("kritilabs"), puruvalan("puruvalan"), Ramcons("Ramcons"),
	O3mdmcom("O3mdm.com"), capstoneclinic("capstoneclinic"), ssn("ssn");
	
	private final String account;

	Account(String account) {
		this.account = account;
	}

	public String getAccount() {
		return account;
	}
}
