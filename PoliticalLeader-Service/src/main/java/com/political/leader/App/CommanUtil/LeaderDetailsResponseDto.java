package com.political.leader.App.CommanUtil;

import java.util.List;

import com.political.leader.App.vo.LeaderVO;


public class LeaderDetailsResponseDto {

	private Integer partyId;
	
	private List<LeaderVO> leadVoList;
    
	private StatusDto status;

	
	public Integer getPartyId() {
		return partyId;
	}

	public void setPartyId(Integer partyId) {
		this.partyId = partyId;
	}

	public List<LeaderVO> getLeadVoList() {
		return leadVoList;
	}

	public void setLeadVoList(List<LeaderVO> leadVoList) {
		this.leadVoList = leadVoList;
	}

	public StatusDto getStatus() {
		return status;
	}

	public void setStatus(StatusDto status) {
		this.status = status;
	}

	
	
	
	
}
