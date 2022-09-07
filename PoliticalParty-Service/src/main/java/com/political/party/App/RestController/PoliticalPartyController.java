package com.political.party.App.RestController;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.political.party.App.dto.LeaderVO;
import com.political.party.App.dto.PartyRequectVO;
import com.political.party.App.dto.PartyVO;
import com.political.party.App.service.PartyService;
import com.political.party.App.util.PartyResourseNotExistException;
import com.political.party.App.util.StatusDto;

@RestController
@RequestMapping("/politicalparty")
public class PoliticalPartyController {

	@Autowired
	private PartyService partyService;

	@PostMapping(value="/register",produces=MediaType.APPLICATION_JSON_VALUE)
	public StatusDto registerPartyDetails(@RequestBody PartyVO partyVO) {
		StatusDto statusDto=partyService.savePartyDetails(partyVO);
		return statusDto;
	}

	@PostMapping("/getParty")
	public PartyRequectVO getPartyDetails(@RequestBody PartyRequectVO PartyRequectVO) {
		PartyRequectVO statusVo=partyService.getPartyDetailsById(PartyRequectVO);
		return statusVo;
	}


	@DeleteMapping(value="/deleteParty/{partyId}",produces=MediaType.APPLICATION_JSON_VALUE)
	public StatusDto deletePartyById(@PathVariable Number partyId) {
		StatusDto status=null;
		try {
			boolean flag=partyService.isPartyExist(partyId);
			if(flag) {
				status=partyService.deletePartyById(partyId);
			}else {
				throw new PartyResourseNotExistException("Resource Not Available");
			}
		}catch(Exception ex) {
			throw new PartyResourseNotExistException("Resource Not Available");
		}
		return status;
	}


	@GetMapping(value="/getAllLeadersParty/{partyId}",produces=MediaType.APPLICATION_JSON_VALUE)
	public List<LeaderVO> getAllLeadersParty(@PathVariable Number partyId) {
		List<LeaderVO> leaderList=new ArrayList<>();
		try {
			boolean flag=partyService.isPartyExist(partyId);
			if(flag) {
				leaderList=partyService.getAllLeadersParty(partyId);
			}else {
				throw new PartyResourseNotExistException("Party Id not exist");	
			}
		}catch (Exception ex) {
			throw new PartyResourseNotExistException("Party Id not exist");	
		}
		return leaderList;
	}


}
