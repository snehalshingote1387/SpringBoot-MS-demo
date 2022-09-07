package com.political.party.App.util;

public class PartyUtil {

	public static StatusDto getStatusDetails(int statusCode, boolean flag, String message, String exceptMsg) {
		StatusDto status=new StatusDto();
		status.setStatusCode(statusCode);
		status.setIsSuccess(flag);
		status.setMessage(message);
		status.setExceptionMessage(exceptMsg);
		return status;
	}
	


}
