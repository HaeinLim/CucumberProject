package com.three.cucumber.vo;

import java.sql.Timestamp;

public class PhoneResSMSVO {
    private String statusCode;
    private String statusName;
    private String requestId;
    private Timestamp requestTime;
    private String content;
    
    
	public PhoneResSMSVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PhoneResSMSVO(String statusCode, String statusName, String requestId, Timestamp requestTime, String content) {
		super();
		this.statusCode = statusCode;
		this.statusName = statusName;
		this.requestId = requestId;
		this.requestTime = requestTime;
		this.content = content;
	}
	public String getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}
	public String getStatusName() {
		return statusName;
	}
	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}
	public String getRequestId() {
		return requestId;
	}
	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}
	public Timestamp getRequestTime() {
		return requestTime;
	}
	public void setRequestTime(Timestamp requestTime) {
		this.requestTime = requestTime;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
    
    
}
