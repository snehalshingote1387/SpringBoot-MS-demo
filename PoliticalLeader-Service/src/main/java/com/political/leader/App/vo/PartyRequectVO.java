package com.political.leader.App.vo;

import com.political.leader.App.CommanUtil.StatusDto;

public class PartyRequectVO {
	
	private Integer partyId;
	
	private StatusDto statusDto;

	public Integer getPartyId() {
		return partyId;
	}

	public void setPartyId(Integer partyId) {
		this.partyId = partyId;
	}

	public StatusDto getStatusVo() {
		return statusDto;
	}

	public void setStatusVo(StatusDto statusDto) {
		this.statusDto = statusDto;
	}
  
	
	
}
