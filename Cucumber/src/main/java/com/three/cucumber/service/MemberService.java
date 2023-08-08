package com.three.cucumber.service;

import javax.servlet.http.HttpServletRequest;

import com.three.cucumber.vo.MemberVO;
import com.three.cucumber.vo.RevVO;

public interface MemberService {
	int getSession(HttpServletRequest request);
	int getMemseq();

	String nickCheck(String nick);

	boolean insertMem(MemberVO mvo);

	int emailCheck(String email);

	String findEmail(String phone);

	boolean updateMemPw(String pw, String email);

	MemberVO login(MemberVO mvo);

	boolean update(MemberVO mvo);

	MemberVO findMem(int memId);

	boolean updateMemTel(MemberVO mvo);
	boolean updateMemNick(MemberVO mvo);
	boolean deleteMem(int memId);
	String findNick(int memId);

}
