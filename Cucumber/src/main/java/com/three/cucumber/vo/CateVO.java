package com.three.cucumber.vo;

public class CateVO {
	private int cateId;
	private String cateName;

	public CateVO() {
	}

	public CateVO(int cateId, String cateName) {
		super();
		this.cateId = cateId;
		this.cateName = cateName;
	}

	public int getCateId() {
		return cateId;
	}

	public void setCateId(int cateId) {
		this.cateId = cateId;
	}

	public String getCateName() {
		return cateName;
	}

	public void setCateName(String cateName) {
		this.cateName = cateName;
	}

}
