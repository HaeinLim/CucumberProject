package com.three.cucumber.vo;

public class ChatLogVO {
	private int memId;
	private int chatId;
	public int getMemId() {
		return memId;
	}
	public void setMemId(int memId) {
		this.memId = memId;
	}
	public int getChatId() {
		return chatId;
	}
	public void setChatId(int chatId) {
		this.chatId = chatId;
	}
	public ChatLogVO(int memId, int chatId) {
		super();
		this.memId = memId;
		this.chatId = chatId;
	}
	public ChatLogVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
