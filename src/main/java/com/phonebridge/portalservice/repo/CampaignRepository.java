package com.phonebridge.portalservice.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.phonebridge.portalservice.row.Campaign;

public interface CampaignRepository extends MongoRepository<Campaign, String>{

}
