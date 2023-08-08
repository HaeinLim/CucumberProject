package com.three.cucumber.vo;

public class LikeyVO {

	private int likeyPost;
	private int memId;

	public LikeyVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LikeyVO(int likeyPost, int memId) {
		super();
		this.likeyPost = likeyPost;
		this.memId = memId;
	}

	public int getLikeyPost() {
		return likeyPost;
	}

	public void setLikeyPost(int likeyPost) {
		this.likeyPost = likeyPost;
	}

	public int getMemId() {
		return memId;
	}

	public void setMemId(int memId) {
		this.memId = memId;
	}

}
