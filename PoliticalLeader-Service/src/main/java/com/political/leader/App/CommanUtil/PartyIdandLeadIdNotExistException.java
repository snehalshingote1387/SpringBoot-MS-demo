package com.political.leader.App.CommanUtil;

@SuppressWarnings("serial")
public class PartyIdandLeadIdNotExistException extends RuntimeException{
	
	public PartyIdandLeadIdNotExistException(String str) {
		super(str);
	}
}
