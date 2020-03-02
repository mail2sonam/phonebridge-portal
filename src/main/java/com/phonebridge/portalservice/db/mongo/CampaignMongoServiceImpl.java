package com.phonebridge.portalservice.db.mongo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import com.phonebridge.portalservice.db.mongo.v1.MongoCampaignUtils;
import com.phonebridge.portalservice.db.mongo.v1.row.campaign.MongoCampaignRow;
import com.phonebridge.portalservice.row.campaign.Campaign;
import com.phonebridge.portalservice.service.ICampaignService;

@Qualifier("campaignMongoRepositoryImpl")
@Component
public class CampaignMongoServiceImpl implements ICampaignService{

	/*
	 * @Autowired private Environment env;
	 */	
	@Autowired
	MongoTemplate primaryMongoTemplate;

	@Override
	public String saveData(Campaign campaign) {
		MongoCampaignRow mongoCampaignRow = MongoCampaignUtils.convertIntoMongoCampaign(campaign);
		primaryMongoTemplate.save(mongoCampaignRow);
		return mongoCampaignRow.getCampaignId().toString();
	}
}
