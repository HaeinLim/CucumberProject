package com.three.cucumber.vo;

import java.util.List;

public class PhoneReqSMSVO {
    private String type;
    private String contentType;
    private String countryCode;
    private String from;
    private String content;
    private List<PhoneMesVO> messages;
    
    
    
	public PhoneReqSMSVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PhoneReqSMSVO(String type, String contentType, String countryCode, String from, String content,
			List<PhoneMesVO> messages) {
		super();
		this.type = type;
		this.contentType = contentType;
		this.countryCode = countryCode;
		this.from = from;
		this.content = content;
		this.messages = messages;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getContentType() {
		return contentType;
	}
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}
	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public List<PhoneMesVO> getMessages() {
		return messages;
	}
	public void setMessages(List<PhoneMesVO> messages) {
		this.messages = messages;
	}
    
    
    
    
}
