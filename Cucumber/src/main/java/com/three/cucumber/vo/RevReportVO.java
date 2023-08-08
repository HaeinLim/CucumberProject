package com.three.cucumber.vo;

public class RevReportVO {
	private int revRepId;
	private int revId;
	private String revRepContent;
	
	
	public RevReportVO(int revRepId, int revId, String revRepContent) {
		super();
		this.revRepId = revRepId;
		this.revId = revId;
		this.revRepContent = revRepContent;
	}
	public RevReportVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getRevRepId() {
		return revRepId;
	}
	public void setRevRepId(int revRepId) {
		this.revRepId = revRepId;
	}
	public int getRevId() {
		return revId;
	}
	public void setRevId(int revId) {
		this.revId = revId;
	}
	public String getRevRepContent() {
		return revRepContent;
	}
	public void setRevRepContent(String revRepContent) {
		this.revRepContent = revRepContent;
	}
	
	

}
