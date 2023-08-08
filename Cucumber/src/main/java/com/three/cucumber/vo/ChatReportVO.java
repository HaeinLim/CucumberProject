package com.three.cucumber.vo;

public class ChatReportVO {
    private  int chatReportId;
    private int chatReported;
    private int chatReporter;
    private String chatReportPipath;
    private String chatReportContent;
    
    
	public ChatReportVO() {
		super();
		// TODO Auto-generated constructor stub
	}


	public ChatReportVO(int chatReportId, int chatReported, int chatReporter, String chatReportPipath,
			String chatReportContent) {
		super();
		this.chatReportId = chatReportId;
		this.chatReported = chatReported;
		this.chatReporter = chatReporter;
		this.chatReportPipath = chatReportPipath;
		this.chatReportContent = chatReportContent;
	}


	public int getChatReportId() {
		return chatReportId;
	}


	public void setChatReportId(int chatReportId) {
		this.chatReportId = chatReportId;
	}


	public int getChatReported() {
		return chatReported;
	}


	public void setChatReported(int chatReported) {
		this.chatReported = chatReported;
	}


	public int getChatReporter() {
		return chatReporter;
	}


	public void setChatReporter(int chatReporter) {
		this.chatReporter = chatReporter;
	}


	public String getChatReportPipath() {
		return chatReportPipath;
	}


	public void setChatReportPipath(String chatReportPipath) {
		this.chatReportPipath = chatReportPipath;
	}


	public String getChatReportContent() {
		return chatReportContent;
	}


	public void setChatReportContent(String chatReportContent) {
		this.chatReportContent = chatReportContent;
	}

	

	
	
}