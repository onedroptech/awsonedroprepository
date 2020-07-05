package com.aws.codestar.projecttemplates.model;

import org.springframework.stereotype.Component;

@Component
public class OtpInputVO 
{

	private String mobileNumber;
	private String otpNumber;
	
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getOtpNumber() {
		return otpNumber;
	}
	public void setOtpNumber(String otpNumber) {
		this.otpNumber = otpNumber;
	}
	
	
	
}
