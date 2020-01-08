package com.phonebridge.portalservice.row;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Campaign {

	@Id
	private String id;
	private String campaignName;
	private String extensionWise;
	private ServerDetails server;
	private String branchWise;
	private CallDirection calldirection;
	private int noOfClientTiers;
	private String newClientURL;
	private double didNumber;
	private String cdrUrl;
	private String queueName;
	private Status status;
	private DialMethod dialMethod;
	private String resourceURL;
	private String iFrameUrl;
	private long noOfAgentTries;
	private boolean isDefault;
	private int retryAfter;
	private Date waitTimeBefore;
	private Date wrapUpTime;
	private CampaignSource campaignSource;
	// private SortField field;
	private String callBackCampaign;
	private String existingClientUrl;
	//Mode
	private String trunkName;
	private String account;

	public String getCampaignName() {
		return campaignName;
	}

	public void setCampaignName(String campaignName) {
		this.campaignName = campaignName;
	}

	public String getExtensionWise() {
		return extensionWise;
	}

	public void setExtensionWise(String extensionWise) {
		this.extensionWise = extensionWise;
	}

	public ServerDetails getServer() {
		return server;
	}

	public void setServer(ServerDetails server) {
		this.server = server;
	}

	public String getBranchWise() {
		return branchWise;
	}

	public void setBranchWise(String branchWise) {
		this.branchWise = branchWise;
	}

	public CallDirection getCalldirection() {
		return calldirection;
	}

	public void setCalldirection(CallDirection calldirection) {
		this.calldirection = calldirection;
	}

	public int getNoOfClientTiers() {
		return noOfClientTiers;
	}

	public void setNoOfClientTiers(int noOfClientTiers) {
		this.noOfClientTiers = noOfClientTiers;
	}

	public String getNewClientURL() {
		return newClientURL;
	}

	public void setNewClientURL(String newClientURL) {
		this.newClientURL = newClientURL;
	}

	public double getDidNumber() {
		return didNumber;
	}

	public void setDidNumber(double didNumber) {
		this.didNumber = didNumber;
	}

	public String getCdrUrl() {
		return cdrUrl;
	}

	public void setCdrUrl(String cdrUrl) {
		this.cdrUrl = cdrUrl;
	}

	public String getQueueName() {
		return queueName;
	}

	public void setQueueName(String queueName) {
		this.queueName = queueName;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public DialMethod getDialMethod() {
		return dialMethod;
	}

	public void setDialMethod(DialMethod dialMethod) {
		this.dialMethod = dialMethod;
	}

	public String getResourceURL() {
		return resourceURL;
	}

	public void setResourceURL(String resourceURL) {
		this.resourceURL = resourceURL;
	}

	public String getiFrameUrl() {
		return iFrameUrl;
	}

	public void setiFrameUrl(String iFrameUrl) {
		this.iFrameUrl = iFrameUrl;
	}

	public long getNoOfAgentTries() {
		return noOfAgentTries;
	}

	public void setNoOfAgentTries(long noOfAgentTries) {
		this.noOfAgentTries = noOfAgentTries;
	}

	public boolean isDefault() {
		return isDefault;
	}

	public void setDefault(boolean isDefault) {
		this.isDefault = isDefault;
	}

	public int getRetryAfter() {
		return retryAfter;
	}

	public void setRetryAfter(int retryAfter) {
		this.retryAfter = retryAfter;
	}

	public Date getWaitTimeBefore() {
		return waitTimeBefore;
	}

	public void setWaitTimeBefore(Date waitTimeBefore) {
		this.waitTimeBefore = waitTimeBefore;
	}

	public Date getWrapUpTime() {
		return wrapUpTime;
	}

	public void setWrapUpTime(Date wrapUpTime) {
		this.wrapUpTime = wrapUpTime;
	}

	public CampaignSource getCampaignSource() {
		return campaignSource;
	}

	public void setCampaignSource(CampaignSource campaignSource) {
		this.campaignSource = campaignSource;
	}

	public String getCallBackCampaign() {
		return callBackCampaign;
	}

	public void setCallBackCampaign(String callBackCampaign) {
		this.callBackCampaign = callBackCampaign;
	}

	public String getExistingClientUrl() {
		return existingClientUrl;
	}

	public void setExistingClientUrl(String existingClientUrl) {
		this.existingClientUrl = existingClientUrl;
	}

	public String getTrunkName() {
		return trunkName;
	}

	public void setTrunkName(String trunkName) {
		this.trunkName = trunkName;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

}
