package com.three.cucumber.vo;

import java.util.Date;

public class QnaVO {
	private int qnaId;
	private int memId;
	private int postId;
	private int depth;	// ´ñ±Û°ú ´ë´ñ±Û ±¸ºÐ(0, 1)
	private int bundleId;	// ÇÑ ´ñ±Û°ú ´ë´ñ±Û ¹­À½
	private int bundleOrder;	// ´ë´ñ±Û °£ÀÇ ¼ø¼­
	private String qnaContent;
	private Date qnaDate;
	private String nick;
	
	public QnaVO() {
		super();
	}

	public QnaVO(int qnaId, int memId, int postId, int depth, int bundleId, int bundleOrder, String qnaContent,
			Date qnaDate, String nick) {
		super();
		this.qnaId = qnaId;
		this.memId = memId;
		this.postId = postId;
		this.depth = depth;
		this.bundleId = bundleId;
		this.bundleOrder = bundleOrder;
		this.qnaContent = qnaContent;
		this.qnaDate = qnaDate;
		this.nick = nick;
	}

	public int getQnaId() {
		return qnaId;
	}

	public void setQnaId(int qnaId) {
		this.qnaId = qnaId;
	}

	public int getMemId() {
		return memId;
	}

	public void setMemId(int memId) {
		this.memId = memId;
	}

	public int getPostId() {
		return postId;
	}

	public void setPostId(int postId) {
		this.postId = postId;
	}

	public int getDepth() {
		return depth;
	}

	public void setDepth(int depth) {
		this.depth = depth;
	}

	public int getBundleId() {
		return bundleId;
	}

	public void setBundleId(int bundleId) {
		this.bundleId = bundleId;
	}

	public int getBundleOrder() {
		return bundleOrder;
	}

	public void setBundleOrder(int bundleOrder) {
		this.bundleOrder = bundleOrder;
	}

	public String getQnaContent() {
		return qnaContent;
	}

	public void setQnaContent(String qnaContent) {
		this.qnaContent = qnaContent;
	}

	public Date getQnaDate() {
		return qnaDate;
	}

	public void setQnaDate(Date qnaDate) {
		this.qnaDate = qnaDate;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	@Override
	public String toString() {
		return "QnaVO [qnaId=" + qnaId + ", memId=" + memId + ", postId=" + postId + ", depth=" + depth + ", bundleId="
				+ bundleId + ", bundleOrder=" + bundleOrder + ", qnaContent=" + qnaContent + ", qnaDate=" + qnaDate
				+ ", nick=" + nick + "]";
	}
	
}
