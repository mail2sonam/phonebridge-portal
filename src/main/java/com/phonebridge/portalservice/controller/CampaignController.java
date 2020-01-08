package com.phonebridge.portalservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.phonebridge.portalservice.repo.CampaignRepository;
import com.phonebridge.portalservice.row.CallDirection;
import com.phonebridge.portalservice.row.Campaign;
import com.phonebridge.portalservice.row.ServerDetails;
import com.phonebridge.portalservice.service.CampaignService;

@RestController
public class CampaignController {

	@Autowired
	CampaignService service;
	
	@Autowired
	CampaignRepository repository;
	
	@GetMapping(value = "/",produces="application/json")
	public @ResponseBody Campaign getCampaignData() {
		System.out.println("Adding sample data");
		Campaign c1 = new Campaign();
		c1.setCampaignName("Third");
		c1.setExtensionWise("extensionWise");
		c1.setServer(ServerDetails.Eupraxia);
		c1.setAccount("O3mdm.com");
		c1.setBranchWise("branchwise");
		c1.setCalldirection(CallDirection.Both);
		
	
		//service.saveData(c1);
		//repository.findAll().forEach(u -> System.out.println(u));
		return c1;
	}
	
	@PostMapping(path =  "/campaign",produces="application/json",consumes = "application/json")
	public @ResponseBody Campaign saveCampaignDetails(@RequestBody Campaign jsonCampString) {
		return service.saveData(jsonCampString);
	}
	
	@GetMapping(path =  "/getCampaignDetails")
	public @ResponseBody List<Campaign> getCampaignDetails() {
		return repository.findAll();
	}
	
	/*
	 * @PutMapping(path ="/updateCampaignDetails") public Campaign
	 * updateByCampaignName(@RequestParam String name) {
	 * 
	 * }
	 */

}
