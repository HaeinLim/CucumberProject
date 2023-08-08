package com.three.cucumber.vo;

import java.util.Date;

public class BuyVO {
    private int buyId;
    private int buyer;
    private int seller;
    private String title;
    private int price;
    private String pipath;
    private int revCheck;
    
    
    
	public BuyVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BuyVO(int buyId, int buyer, int seller, String title, int price, String pipath, int revCheck) {
		super();
		this.buyId = buyId;
		this.buyer = buyer;
		this.seller = seller;
		this.title = title;
		this.price = price;
		this.pipath = pipath;
		this.revCheck = revCheck;
	}
	public int getBuyId() {
		return buyId;
	}
	public void setBuyId(int buyId) {
		this.buyId = buyId;
	}
	public int getBuyer() {
		return buyer;
	}
	public void setBuyer(int buyer) {
		this.buyer = buyer;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getPipath() {
		return pipath;
	}
	public void setPipath(String pipath) {
		this.pipath = pipath;
	}
	public int getRevCheck() {
		return revCheck;
	}
	public void setRevChek(int revCheck) {
		this.revCheck = revCheck;
	}
	public int getSeller() {
		return seller;
	}
	public void setSeller(int seller) {
		this.seller = seller;
	}
    
    
    
}
