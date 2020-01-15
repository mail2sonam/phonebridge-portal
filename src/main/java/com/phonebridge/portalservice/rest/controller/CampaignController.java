package com.phonebridge.portalservice.rest.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.phonebridge.portalservice.repo.primary.CampaignRepository;
import com.phonebridge.portalservice.rest.v1.req.NewCampaignRq;
import com.phonebridge.portalservice.rest.v1.resp.NewCampaignRs;
import com.phonebridge.portalservice.rest.v1.util.CampaignUtil;
import com.phonebridge.portalservice.service.CampaignService;
import com.phonebridge.row.campaign.Campaign;

@RestController(value = "/campaign/v1")
public class CampaignController {

	@Autowired
	CampaignService service;
	
	@Autowired
	CampaignRepository repository;
	
	/*
	 * @GetMapping(value = "/",produces="application/json") public @ResponseBody
	 * CampaignRq getCampaignData() { System.out.println("Adding sample data");
	 * Campaign c1 = new Campaign(); c1.setCampaignName("Third");
	 * c1.setExtensionWise("extensionWise"); c1.setServer(ServerDetails.Eupraxia);
	 * c1.setAccount("O3mdm.com"); c1.setBranchWise("branchwise");
	 * c1.setCalldirection(CallDirection.Both);
	 * 
	 * com.phonebridge.row.campaign.Campaign c=new
	 * com.phonebridge.row.campaign.Campaign();
	 * 
	 * //service.saveData(c1); //repository.findAll().forEach(u ->
	 * System.out.println(u)); return c1; }
	 */
	
	@PostMapping(path =  "/newCampaign",produces="application/json",consumes = "application/json")
	public @ResponseBody ResponseEntity<NewCampaignRs> insertCampaign(@RequestHeader("accountId") String accountId
			,@RequestBody NewCampaignRq newCampaignRq) {
		Map<String,String> validationResults= CampaignUtil.validateSaveCampaign(newCampaignRq);
		if(!validationResults.isEmpty()){
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
		Campaign campaign = CampaignUtil.convertIntoCampaign(accountId,newCampaignRq);
		campaign=service.saveData(campaign);
		NewCampaignRs response= CampaignUtil.convertIntoNewCampaignRs(campaign);
		return new ResponseEntity<>(response,HttpStatus.CREATED);
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
