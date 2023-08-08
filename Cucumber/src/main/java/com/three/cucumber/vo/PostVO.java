package com.three.cucumber.vo;

import java.util.Date;

public class PostVO {
	private int postId;
	private int cateId;
	private int memId;
	private String postState;
	private String mainPipath;
	private String pipath2;
	private String pipath3;
	private String postTitle;
	private int postPrice;
	private String postContent;
	private int likey;
	private String revcheck;
	private Date postDate;
	private int postView;
	
	public PostVO() {}

	public PostVO(int postId, int cateId, int memId, String postState, String mainPipath, String pipath2,
			String pipath3, String postTitle, int postPrice, String postContent, int likey, String revcheck,
			Date postDate, int postView) {
		super();
		this.postId = postId;
		this.cateId = cateId;
		this.memId = memId;
		this.postState = postState;
		this.mainPipath = mainPipath;
		this.pipath2 = pipath2;
		this.pipath3 = pipath3;
		this.postTitle = postTitle;
		this.postPrice = postPrice;
		this.postContent = postContent;
		this.likey = likey;
		this.revcheck = revcheck;
		this.postDate = postDate;
		this.postView = postView;
	}

	public int getPostId() {
		return postId;
	}

	public void setPostId(int postId) {
		this.postId = postId;
	}

	public int getCateId() {
		return cateId;
	}

	public void setCateId(int cateId) {
		this.cateId = cateId;
	}

	public int getMemId() {
		return memId;
	}

	public void setMemId(int memId) {
		this.memId = memId;
	}

	public String getPostState() {
		return postState;
	}

	public void setPostState(String postState) {
		this.postState = postState;
	}

	public String getMainPipath() {
		return mainPipath;
	}

	public void setMainPipath(String mainPipath) {
		this.mainPipath = mainPipath;
	}

	public String getPipath2() {
		return pipath2;
	}

	public void setPipath2(String pipath2) {
		this.pipath2 = pipath2;
	}

	public String getPipath3() {
		return pipath3;
	}

	public void setPipath3(String pipath3) {
		this.pipath3 = pipath3;
	}

	public String getPostTitle() {
		return postTitle;
	}

	public void setPostTitle(String postTitle) {
		this.postTitle = postTitle;
	}

	public int getPostPrice() {
		return postPrice;
	}

	public void setPostPrice(int postPrice) {
		this.postPrice = postPrice;
	}

	public String getPostContent() {
		return postContent;
	}

	public void setPostContent(String postContent) {
		this.postContent = postContent;
	}

	public int getLikey() {
		return likey;
	}

	public void setLikey(int likey) {
		this.likey = likey;
	}

	public String getRevcheck() {
		return revcheck;
	}

	public void setRevcheck(String revcheck) {
		this.revcheck = revcheck;
	}

	public Date getPostDate() {
		return postDate;
	}

	public void setPostDate(Date postDate) {
		this.postDate = postDate;
	}

	public int getPostView() {
		return postView;
	}

	public void setPostView(int postView) {
		this.postView = postView;
	}
	
	
}
