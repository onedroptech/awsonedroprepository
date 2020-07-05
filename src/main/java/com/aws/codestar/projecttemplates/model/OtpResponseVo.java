package com.aws.codestar.projecttemplates.model;

import org.springframework.stereotype.Component;

@Component
public class OtpResponseVo 
{

	private boolean status;
	private String message;
	
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
