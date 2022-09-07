package com.political.party.App.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.political.party.App.dto.LeadDetailsRespVo;
import com.political.party.App.dto.LeaderVO;
import com.political.party.App.dto.PartyRequectVO;
import com.political.party.App.dto.PartyVO;
import com.political.party.App.entity.PartyEntity;
import com.political.party.App.repo.PartyRepository;
import com.political.party.App.service.PartyService;
import com.political.party.App.util.PartyUtil;
import com.political.party.App.util.StatusDto;

@Service
public class PartyServiceImpl implements PartyService{

	@Autowired
	private PartyRepository partyRepository;
	
	@Autowired
	private RestTemplate rt;
	
	@Override
	public StatusDto savePartyDetails(PartyVO partyVO) {
		StatusDto statusDto=new StatusDto();
		try {
		PartyEntity partyEntity=new PartyEntity();
		partyEntity.setPartyId(partyVO.getPartyId());
		partyEntity.setPartyName(partyVO.getPartyName());
		partyEntity.setFounderName(partyVO.getFounderName());
		partyEntity.setFounderYear(partyVO.getFounderYear());
		partyEntity=partyRepository.save(partyEntity);
		statusDto=PartyUtil.getStatusDetails(200,true,"Party Registred Successfully","");
		}catch(Exception ex) {
			
		}
		return statusDto;
	}

	@Override
	public PartyRequectVO getPartyDetailsById(PartyRequectVO partyRequestVO) {
		PartyRequectVO statusVo=new PartyRequectVO();
		StatusDto status=new StatusDto();
		Optional<PartyEntity> party= partyRepository.findById(partyRequestVO.getPartyId());
		if(party.isPresent()) {
			status=PartyUtil.getStatusDetails(200,true,"Party Already Registred","");	
			statusVo.setStatusVo(status);
			statusVo.setPartyId(partyRequestVO.getPartyId());
		}else {
			status=PartyUtil.getStatusDetails(404,false,"Party Need to Register Before Leader Registaration","");	
			statusVo.setStatusVo(status);
			statusVo.setPartyId(partyRequestVO.getPartyId());
		}
		return statusVo;
	}

	@Override
	public StatusDto deletePartyById(Number partyId) {
		StatusDto status=new StatusDto();
		try {
			partyRepository.deleteById(Integer.parseInt(partyId.toString()));
			status=PartyUtil.getStatusDetails(200,true,"Party Details Deleted SuccessFully","");
		}catch(Exception Ex) {
			status=PartyUtil.getStatusDetails(500,false,"Party Details Deleted Fail due to Internal Server Issue","");
		}
		return status;
	}

	@Override
	public boolean isPartyExist(Number partyId) {
		return partyRepository.existsById(Integer.parseInt(partyId.toString()));
	}

	@Override
	public List<LeaderVO> getAllLeadersParty(Number partyId) {
		LeadDetailsRespVo reqResp=new LeadDetailsRespVo();
		List<LeaderVO> ldVo=new ArrayList<>();
		reqResp.setPartyId(Integer.parseInt(partyId.toString()));
		try {
		 reqResp=this.rt.postForObject("http://Leader-Service/leader/getAllLeadersParty", reqResp,LeadDetailsRespVo.class);
		if(reqResp.getStatus().getIsSuccess() &&reqResp.getStatus().getStatusCode()==200 ) {
			ldVo=reqResp.getLeadVoList();
		    }
		
		}catch(Exception ex) {
			
		}
		return ldVo;
	}

}
