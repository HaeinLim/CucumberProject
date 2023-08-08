package com.three.cucumber.vo;

import java.util.Date;

public class RevVO {
    private int revId;
    private int buyId;
    private int revWriter;
    private int revReceiver;
    private String revContent;
    private int revPoint;
    private String nick;

	public RevVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public RevVO(int revId, int butId, int revWriter, int revReceiver, String revContent, int revPoint, String nick) {
		super();
		this.revId = revId;
		this.buyId = butId;
		this.revWriter = revWriter;
		this.revReceiver = revReceiver; 
		this.revContent = revContent;
		this.revPoint = revPoint;
		this.nick = nick;
	}


	public int getRevId() {
		return revId;
	}

	public void setRevId(int revId) {
		this.revId = revId;
	}

	public int getBuyId() {
		return buyId;
	}


	public void setBuyId(int buyId) {
		this.buyId = buyId;
	}


	public int getRevWriter() {
		return revWriter;
	}

	public void setRevWriter(int revWriter) {
		this.revWriter = revWriter;
	}

	public int getRevReceiver() {
		return revReceiver;
	}

	public void setRevReceiver(int revReceiver) {
		this.revReceiver = revReceiver;
	}

	public String getRevContent() {
		return revContent;
	}

	public void setRevContent(String revContent) {
		this.revContent = revContent;
	}

	public int getRevPoint() {
		return revPoint;
	}

	public void setRevPoint(int revPoint) {
		this.revPoint = revPoint;
	}


	public String getNick() {
		return nick;
	}


	public void setNick(String nick) {
		this.nick = nick;
	}
	
}