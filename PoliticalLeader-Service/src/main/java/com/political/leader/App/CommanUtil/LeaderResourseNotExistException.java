package com.political.leader.App.CommanUtil;

@SuppressWarnings("serial")
public class LeaderResourseNotExistException extends RuntimeException{
	
	public LeaderResourseNotExistException(String str) {
		super(str);
	}

}
