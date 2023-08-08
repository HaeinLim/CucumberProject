package com.three.cucumber.vo;

public class MemberVO {

	private int memId;
	private String email;
	private String pw;
	private String pwSalt;
	private String nick;
	private String tel;
	private int memPoint;
	private int report;
	private String admin;
		
	public MemberVO() { }

	public MemberVO(int memId, String email, String pw, String pwSalt, String nick, String tel, int memPoint, int report, String admin) {
		super();
		this.memId = memId;
		this.email = email;
		this.pw = pw;
		this.pwSalt = pwSalt;
		this.nick = nick;
		this.tel = tel;
		this.memPoint = memPoint;
		this.report=report;
		this.admin=admin;
	}
	
	public int getMemId() {
		return memId;
	}
	public void setMemId(int memId) {
		this.memId = memId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getPwSalt() {
		return pwSalt;
	}
	public void setPwSalt(String pwSalt) {
		this.pwSalt = pwSalt;
	}
	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public int getMemPoint() {
		return memPoint;
	}
	public void setMemPoint(int memPoint) {
		this.memPoint = memPoint;
	}
	public int getReport() {
		return report;
	}

	public void setReport(int report) {
		this.report = report;
	}

	public String getAdmin() {
		return admin;
	}

	public void setAdmin(String admin) {
		this.admin = admin;
	}	
	
}
