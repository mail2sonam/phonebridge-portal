package com.phonebridge.portalservice.rest.v1.req;

import com.phonebridge.portalservice.rest.v1.row.campaign.CampaignIncomingSettings;
import com.phonebridge.portalservice.rest.v1.row.campaign.CampaignOutgoingSettings;
import com.phonebridge.portalservice.rest.v1.row.campaign.CampaignPopup;

import lombok.Data;

@Data
public class NewCampaignRq{

	private String campaignName;
	private String callDirection;
	private String campaignStatus;
	private boolean isEnabledForPopup;
	/* Defines the type of Campaign */
	private String typeOfCall;
	/* Default campaigns are generic those which don't fit into other campaigns */
	private boolean isDefault;
	
	private CampaignIncomingSettings campaignIncomingSettings;
	private CampaignOutgoingSettings campaignOutgoingSettings;
	private CampaignPopup campaignPopup;
}
