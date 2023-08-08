package com.three.cucumber.vo;

public class ReportQnaVO {
	private int qnaReportId;
	private int qnaReportMem;
	private int postId;
	private int qnaId;
	private String qnaContent;
	private String reporterNick;
	
	public ReportQnaVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ReportQnaVO(int qnaReportId, int qnaReportMem, int postId, int qnaId
					, String qnaContent, String reporterNick) {
		super();
		this.qnaReportId = qnaReportId;
		this.qnaReportMem = qnaReportMem;
		this.postId = postId;
		this.qnaId = qnaId;
		this.qnaContent = qnaContent;
		this.reporterNick = reporterNick;
	}

	public int getQnaReportId() {
		return qnaReportId;
	}

	public void setQnaReportId(int qnaReportId) {
		this.qnaReportId = qnaReportId;
	}

	public int getQnaReportMem() {
		return qnaReportMem;
	}

	public void setQnaReportMem(int qnaReportMem) {
		this.qnaReportMem = qnaReportMem;
	}

	public int getPostId() {
		return postId;
	}

	public void setPostId(int postId) {
		this.postId = postId;
	}

	public int getQnaId() {
		return qnaId;
	}

	public void setQnaId(int qnaId) {
		this.qnaId = qnaId;
	}
	
	public String getQnaContent() {
		return qnaContent;
	}

	public void setQnaContent(String qnaContent) {
		this.qnaContent = qnaContent;
	}

	public String getReporterNick() {
		return reporterNick;
	}

	public void setReporterNick(String reporterNick) {
		this.reporterNick = reporterNick;
	}

	@Override
	public String toString() {
		return "ReportQnaVO [qnaReportId=" + qnaReportId + ", qnaReportMem=" + qnaReportMem + ", postId=" + postId
				+ ", qnaId=" + qnaId + ", qnaContent=" + qnaContent + ", reporterNick=" + reporterNick + "]";
	}
	
}	
