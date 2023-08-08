package com.three.cucumber.service.dao;

import java.util.ArrayList;

import com.three.cucumber.vo.MemberVO;

public interface MemberDAO {
	int getMemseq();

	int nickCheck(String nick);

	int insertMem(MemberVO mvo);

	int emailCheck(String email);

	String findEmail(String phone);

	int updateMemPw(MemberVO mvo);

	MemberVO login(MemberVO mvo);

	int updateMem(MemberVO mvo);

	MemberVO findMem(int memId);

	boolean updateMemTel(MemberVO mvo);

	boolean updateMemNick(MemberVO mvo);

	boolean deleteMem(int memId);

	String findNick(int memId);
}
