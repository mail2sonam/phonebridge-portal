package com.phonebridge.portalservice.rest.v1.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.phonebridge.portalservice.rest.v1.req.NewCampaignRq;
import com.phonebridge.portalservice.rest.v1.resp.NewCampaignRs;
import com.phonebridge.row.account.Account;
import com.phonebridge.row.campaign.Campaign;
import com.phonebridge.row.campaign.CampaignIncomingSettings;
import com.phonebridge.row.campaign.CampaignOutgoingSettings;
import com.phonebridge.row.campaign.CampaignPopup;
import com.phonebridge.row.campaign.CampaignPopupIncoming;
import com.phonebridge.row.campaign.Disposition;
import com.phonebridge.row.campaign.EnumAssocDirection;
import com.phonebridge.row.campaign.EnumCampaignSource;
import com.phonebridge.row.campaign.EnumStatus;
import com.phonebridge.row.campaign.EnumTypeOfCall;
import com.phonebridge.row.campaign.ShowField;

public class CampaignUtil {
	
	public static NewCampaignRs convertIntoNewCampaignRs(Campaign campaign) {
		if(campaign==null) {
			return null;
		}
		NewCampaignRs newCampaignRs = new NewCampaignRs();
		newCampaignRs.setCampaignId(campaign.getCampaignId());
		return newCampaignRs;
	}

	public static Campaign convertIntoCampaign(String accountId, NewCampaignRq ncr) {
		Campaign campaign=new Campaign();
		
		Account account = new Account();
		account.setAccountId(accountId);
		campaign.setAccount(account);
		
		campaign.setCampaignName(ncr.getCampaignName());
		campaign.setCallDirection(EnumAssocDirection.valueOf(ncr.getCallDirection()));
		campaign.setCampaignStatus(EnumStatus.valueOf(ncr.getCampaignStatus()));
		campaign.setEnabledForPopup(ncr.isEnabledForPopup());
		campaign.setTypeOfCall(EnumTypeOfCall.valueOf(ncr.getTypeOfCall()));
		campaign.setDefault(ncr.isDefault());
		
		if(campaign.isEnabledForPopup()) {
			CampaignPopup campaignPopup = new CampaignPopup();
			campaignPopup.setModuleLinked(ncr.getCampaignPopup().isModuleLinked());
			if(campaignPopup.isModuleLinked()) {
				campaignPopup.setModuleName(ncr.getCampaignPopup().getModuleName());
			}
			if(ncr.getCampaignPopup().getDirectoryInfoURL()!=null && ncr.getCampaignPopup().getDirectoryInfoURL().length()>0) {
				campaignPopup.setDirectoryInfoURL(ncr.getCampaignPopup().getDirectoryInfoURL());
			}
			campaignPopup.setWrapUpTimeInSecs(ncr.getCampaignPopup().getWrapUpTimeInSecs());
			campaignPopup.setCampaignFeedSource(EnumCampaignSource.valueOf(ncr.getCampaignPopup().getCampaignFeedSource()));
			
			campaignPopup.setDispositions(copyDispositions(ncr.getCampaignPopup().getDispositions()));
			campaignPopup.setShowFields(copyShowFields(ncr.getCampaignPopup().getShowFields()));
			campaign.setCampaignPopup(campaignPopup);
			
			if(EnumAssocDirection.INCOMING == campaign.getCallDirection() 
					&& ncr.getCampaignPopup()!=null && ncr.getCampaignPopup().getCampaignPopupIncoming()!=null 
					&& ncr.getCampaignPopup().getCampaignPopupIncoming().getIFrameUrl()!=null) {
				CampaignPopupIncoming campaignPopupIncoming = new CampaignPopupIncoming();
				campaignPopupIncoming.setIFrameUrl(ncr.getCampaignPopup().getCampaignPopupIncoming().getIFrameUrl());
				campaignPopup.setCampaignPopupIncoming(campaignPopupIncoming);
			}
		}
		
		if(EnumAssocDirection.INCOMING == campaign.getCallDirection()) {
			CampaignIncomingSettings campaignIncomingSettings=new CampaignIncomingSettings();
			campaignIncomingSettings.setDidNumber(ncr.getCampaignIncomingSettings().getDidNumber());
			campaignIncomingSettings.setQueueName(ncr.getCampaignIncomingSettings().getQueueName());
			campaignIncomingSettings.setCtiPostBackUrl(ncr.getCampaignIncomingSettings().getCtiPostBackUrl());
			campaign.setCampaignIncomingSettings(campaignIncomingSettings);
		}
		if(EnumAssocDirection.OUTGOING == campaign.getCallDirection()) {
			CampaignOutgoingSettings campaignOutgoingSettings=new CampaignOutgoingSettings();
			campaignOutgoingSettings.setExtensionWise(ncr.getCampaignOutgoingSettings().isExtensionWise());
			campaignOutgoingSettings.setNoOfClientTries(ncr.getCampaignOutgoingSettings().getNoOfClientTries());
			campaignOutgoingSettings.setNoOfAgentTries(ncr.getCampaignOutgoingSettings().getNoOfAgentTries());
			campaignOutgoingSettings.setRetryAfter(ncr.getCampaignOutgoingSettings().getRetryAfter());
			campaignOutgoingSettings.setTrunkName(ncr.getCampaignOutgoingSettings().getTrunkName());
			campaignOutgoingSettings.setPrefix(ncr.getCampaignOutgoingSettings().getPrefix());
			campaignOutgoingSettings.setDialOutWaitTimeInSecs(ncr.getCampaignOutgoingSettings().getDialOutWaitTimeInSecs());
		}
		return campaign;
	}

	private static List<ShowField> copyShowFields(
			List<com.phonebridge.portalservice.rest.v1.row.campaign.ShowField> reqShowFields) {
		if(reqShowFields==null || reqShowFields.isEmpty()) {
			return Collections.emptyList();
		}
		List<ShowField> resultShowFields = new ArrayList<>(reqShowFields.size());
		reqShowFields.forEach(reqSf -> {
			ShowField sf = new ShowField();
			sf.setShowFieldID(UUID.randomUUID().toString());
			sf.setFieldLabel(reqSf.getFieldLabel());
			sf.setFieldValue(reqSf.getFieldValue());
			sf.setDisplayValue(reqSf.getDisplayValue());
			sf.setUrl(reqSf.isUrl());
		});
		return resultShowFields;
	}

	private static List<Disposition> copyDispositions(
			List<com.phonebridge.portalservice.rest.v1.row.campaign.Disposition> reqDispositions) {
		if(reqDispositions==null || reqDispositions.isEmpty()) {
			return Collections.emptyList();
		}
		List<Disposition> resultShowFields = new ArrayList<>(reqDispositions.size());
		reqDispositions.forEach(reqDis -> {
			Disposition disp = new Disposition();
			disp.setDispositionID(UUID.randomUUID().toString()); 
			disp.setFieldValue(reqDis.getFieldValue());
			disp.setFieldLabel(reqDis.getFieldLabel());
			disp.setCallWorkFlow(reqDis.getCallWorkFlow());
			disp.setSendSMS(reqDis.isSendSMS());
			disp.setSmsText(reqDis.getSmsText());
			disp.setConversion(reqDis.isConversion());
			//Reccursion
			disp.setDependantDisp(copyDispositions(reqDis.getDependantLst()));
		});
		return resultShowFields;
	}


	public static Map<String, String> validateSaveCampaign(NewCampaignRq newCampaignRq) {
		//Need to implement
		return Collections.emptyMap();
	}
}
