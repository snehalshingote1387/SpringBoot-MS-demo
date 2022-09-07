package com.political.party.App.util;

@SuppressWarnings("serial")
public class PartyResourseNotExistException extends RuntimeException{
	
	public PartyResourseNotExistException(String str) {
		super(str);
	}

}
