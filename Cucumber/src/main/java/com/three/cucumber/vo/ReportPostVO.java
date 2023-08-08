package com.three.cucumber.vo;

public class ReportPostVO {
	private int postReportId;
	private int postReportMem;
	private int postId;
	private String postReportContent;
	private String postTitle;
	private String reporterNick;
	
	public ReportPostVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ReportPostVO(int postReportId, int postReportMem, int postId, String postReportContent
							, String postTitle, String reporterNick) {
		super();
		this.postReportId = postReportId;
		this.postReportMem = postReportMem;
		this.postId = postId;
		this.postReportContent = postReportContent;
		this.postTitle = postTitle;
		this.reporterNick = reporterNick;
	}

	public int getPostReportId() {
		return postReportId;
	}

	public void setPostReportId(int postReportId) {
		this.postReportId = postReportId;
	}

	public int getPostReportMem() {
		return postReportMem;
	}

	public void setPostReportMem(int postReportMem) {
		this.postReportMem = postReportMem;
	}

	public int getPostId() {
		return postId;
	}

	public void setPostId(int postId) {
		this.postId = postId;
	}

	
	public String getPostReportContent() {
		return postReportContent;
	}

	public void setPostReportContent(String postReportContent) {
		this.postReportContent = postReportContent;
	}
	
	public String getPostTitle() {
		return postTitle;
	}

	public void setPostTitle(String postTitle) {
		this.postTitle = postTitle;
	}

	public String getReporterNick() {
		return reporterNick;
	}

	public void setReporterNick(String reporterNick) {
		this.reporterNick = reporterNick;
	}

	@Override
	public String toString() {
		return "ReportPostVO [postReportId=" + postReportId + ", postReportMem=" + postReportMem + ", postId=" + postId
				+ ", postReportContent=" + postReportContent + ", postTitle=" + postTitle + ", reporterNick="
				+ reporterNick + "]";
	}
	
}
