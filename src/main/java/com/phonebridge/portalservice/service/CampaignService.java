package com.phonebridge.portalservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import com.phonebridge.portalservice.repo.primary.CampaignRepository;
import com.phonebridge.row.campaign.Campaign;

@Service
public class CampaignService {
	@Autowired
	CampaignRepository repository;
	
	@Autowired
	MongoTemplate mongoTemplate;
	
	public Campaign saveData(Campaign campaign) {
		return repository.save(campaign);
	}
	
	/*
	 * public Campaign updateCampaignByName(String name) { mongoTemplate.u }
	 */
}
