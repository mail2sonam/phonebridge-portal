package com.phonebridge.portalservice.row.account;

import com.phonebridge.portalservice.row.BasePojo;

import lombok.Data;

@Data
public class AccountAssoc extends BasePojo{
	Account parentAccount;
	Account childAccount;
	boolean isActive;
	//Extra Settings
}
