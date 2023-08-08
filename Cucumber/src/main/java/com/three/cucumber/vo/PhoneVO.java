package com.three.cucumber.vo;

public class PhoneVO {
	private String accessKey;
	private String serviceId;
	private String secretKey;
	private String from;
	
	
	public PhoneVO() {
		this.accessKey="";
		this.serviceId="";
		this.secretKey="";
		this.from="";
	}


	public String getAccessKey() {
		return this.accessKey;
	}

	public String getServiceId() {
		return this.serviceId;
	}

	public String getSecretKey() {
		return this.secretKey;
	}

	public String getFrom() {
		return this.from;
	}	
	
}
