package com.three.cucumber.vo;

public class ChatVO {
	private int chatId;
	private int postId;
	private int chatTo;
	private int chatFrom;
	private String chatContent;
	private int status;	
	
	public ChatVO() {
	}
	
	public ChatVO(int chatId, int postId, int chatTo, int chatFrom, String chatContent, int status) {
		super();
		this.chatId = chatId;
		this.postId = postId;
		this.chatTo = chatTo;
		this.chatFrom = chatFrom;
		this.chatContent = chatContent;
		this.status = status;
	}
	
	public int getChatId() {
		return chatId;
	}
	public void setChatId(int chatId) {
		this.chatId = chatId;
	}
	public int getPostId() {
		return postId;
	}
	public void setPostId(int postId) {
		this.postId = postId;
	}
	public int getChatTo() {
		return chatTo;
	}
	public void setChatTo(int chatTo) {
		this.chatTo = chatTo;
	}
	public int getChatFrom() {
		return chatFrom;
	}
	public void setChatFrom(int chatFrom) {
		this.chatFrom = chatFrom;
	}
	public String getChatContent() {
		return chatContent;
	}
	public void setChatContent(String chatContent) {
		this.chatContent = chatContent;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
}
