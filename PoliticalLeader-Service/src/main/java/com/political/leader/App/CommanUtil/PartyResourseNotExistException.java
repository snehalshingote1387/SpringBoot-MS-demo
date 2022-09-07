package com.political.leader.App.CommanUtil;

@SuppressWarnings("serial")
public class PartyResourseNotExistException extends RuntimeException{
	
	public PartyResourseNotExistException(String str) {
		super(str);
	}
}
