package com.three.cucumber.vo;

import java.util.Date;

public class MsgVO {

	private int msgId;
	private int chatId;
	private int msgWriter;
	private String msgContent;
	private Date msgDate ;
	private int msgRead;
	private int msgStatus;
	
	
	public MsgVO() {
		super();
		// TODO Auto-generated constructor stub
	}


	public MsgVO(int msgId, int chatId, int msgWriter, String msgContent, Date msgDate, int msgRead, int msgStatus) {
		super();
		this.msgId = msgId;
		this.chatId = chatId;
		this.msgWriter = msgWriter;
		this.msgContent = msgContent;
		this.msgDate = msgDate;
		this.msgRead = msgRead;
		this.msgStatus = msgStatus;
	}


	public int getMsgId() {
		return msgId;
	}


	public void setMsgId(int msgId) {
		this.msgId = msgId;
	}


	public int getChatId() {
		return chatId;
	}


	public void setChatId(int chatId) {
		this.chatId = chatId;
	}


	public int getMsgWriter() {
		return msgWriter;
	}


	public void setMsgWriter(int msgWriter) {
		this.msgWriter = msgWriter;
	}


	public String getMsgContent() {
		return msgContent;
	}


	public void setMsgContent(String msgContent) {
		this.msgContent = msgContent;
	}


	public Date getMsgDate() {
		return msgDate;
	}


	public void setMsgDate(Date msgDate) {
		this.msgDate = msgDate;
	}


	public int getMsgRead() {
		return msgRead;
	}


	public void setMsgRead(int msgRead) {
		this.msgRead = msgRead;
	}


	public int getMsgStatus() {
		return msgStatus;
	}


	public void setMsgStatus(int msgStatus) {
		this.msgStatus = msgStatus;
	}
	
}