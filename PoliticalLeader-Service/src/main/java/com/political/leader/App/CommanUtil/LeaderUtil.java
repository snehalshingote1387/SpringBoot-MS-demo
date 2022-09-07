package com.political.leader.App.CommanUtil;

public class LeaderUtil {



	public static StatusDto getStatusDetails(int statusCode, boolean flag, String message, String exceptMsg) {
		StatusDto status=new StatusDto();
		status.setStatusCode(statusCode);
		status.setIsSuccess(flag);
		status.setMessage(message);
		status.setExceptionMessage(exceptMsg);
		return status;
	}
	



}
