package com.political.party.App.service;

import java.util.List;

import com.political.party.App.dto.LeaderVO;
import com.political.party.App.dto.PartyRequectVO;
import com.political.party.App.dto.PartyVO;
import com.political.party.App.util.StatusDto;

public interface PartyService {

	StatusDto savePartyDetails(PartyVO partyVO);
	
	PartyRequectVO getPartyDetailsById(PartyRequectVO partyRequectVO);

	StatusDto deletePartyById(Number partyId);

	boolean isPartyExist(Number partyId);

	List<LeaderVO> getAllLeadersParty(Number partyId);
	

}
