package com.three.cucumber.vo;

import java.util.ArrayList;

public class Criteria {

	private int pageNum;
	private ArrayList<PostVO> plist;
	private ArrayList<Integer> pagelist;
	private int cateId;
	private String keyword;
	private int endpage;
	private String order;

	public Criteria() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Criteria(int pageNum, ArrayList<PostVO> plist, ArrayList<Integer> pagelist, int cateId, 
			String keyword, int endpage, String order) {
		super();
		this.pageNum = pageNum;
		this.plist = plist;
		this.pagelist = pagelist;
		this.cateId = cateId;
		this.keyword = keyword;
		this.endpage = endpage;
		this.order = order;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public ArrayList<Integer> getPagelist() {
		return pagelist;
	}

	public void setPagelist(ArrayList<Integer> pagelist) {
		this.pagelist = pagelist;
	}

	public ArrayList<PostVO> getPlist() {
		return plist;
	}

	public void setPlist(ArrayList<PostVO> plist) {
		this.plist = plist;
	}

	public int getCateId() {
		return cateId;
	}

	public void setCateId(int cateId) {
		this.cateId = cateId;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public int getEndpage() {
		return endpage;
	}

	public void setEndpage(int endpage) {
		this.endpage = endpage;
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}

	
}
