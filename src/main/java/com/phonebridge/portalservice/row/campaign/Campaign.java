package com.phonebridge.portalservice.row.campaign;

import com.phonebridge.portalservice.row.BasePojo;
import com.phonebridge.portalservice.row.account.Account;

import lombok.Data;

@Data
public class Campaign extends BasePojo{

	private Account account;
	private String campaignId;
	private String campaignName;
	private EnumAssocDirection callDirection;
	private EnumStatus campaignStatus;
	private boolean isEnabledForPopup;
	/* Defines the type of Campaign */
	private EnumTypeOfCall typeOfCall;
	/* Default campaigns are generic those which don't fit into other campaigns */
	private boolean isDefault;
	
	private CampaignIncomingSettings campaignIncomingSettings;
	private CampaignOutgoingSettings campaignOutgoingSettings;
	private CampaignPopup campaignPopup;
}
