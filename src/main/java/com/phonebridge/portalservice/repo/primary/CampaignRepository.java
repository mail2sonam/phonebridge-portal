package com.phonebridge.portalservice.repo.primary;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.phonebridge.portalservice.row.Campaign;

public interface CampaignRepository extends MongoRepository<Campaign, String>{

}
