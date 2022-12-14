package com.political.party.App.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class PartyVO {

    
	@Pattern(regexp ="^[0-9]+$")
	private Integer partyId;

	@NotNull
	@Size(min=5,max=100)
	private String partyName;
	
	@NotNull
	@Size(min=5,max=100)
	private String founderName;
	
	@Pattern(regexp ="^[0-9]+$")
	@NotNull
	private Integer founderYear;

	public Integer getPartyId() {
		return partyId;
	}

	public void setPartyId(Integer partyId) {
		this.partyId = partyId;
	}

	public String getPartyName() {
		return partyName;
	}

	public void setPartyName(String partyName) {
		this.partyName = partyName;
	}

	public String getFounderName() {
		return founderName;
	}

	public void setFounderName(String founderName) {
		this.founderName = founderName;
	}

	public Integer getFounderYear() {
		return founderYear;
	}

	public void setFounderYear(Integer founderYear) {
		this.founderYear = founderYear;
	}
	
	
}
