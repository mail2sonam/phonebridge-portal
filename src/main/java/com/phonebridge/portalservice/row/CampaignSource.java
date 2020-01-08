package com.phonebridge.portalservice.row;

public enum CampaignSource {
	WithExcelBase("With Excel Base"),ModuleLinked("Module Linked"),PopupInCRM("Popup In CRM"),APICampaign("API Campaign");
	
	private final String CampSource;
	
	CampaignSource(String CampSource) {
		this.CampSource = CampSource;
	}
	
	public String getCampSource() {
		return CampSource;
	}
}
