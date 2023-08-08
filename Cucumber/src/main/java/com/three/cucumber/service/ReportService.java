package com.three.cucumber.service;

import java.util.ArrayList;

import com.three.cucumber.vo.ChatReportVO;
import com.three.cucumber.vo.ChatVO;
import com.three.cucumber.vo.MemberVO;
import com.three.cucumber.vo.RevReportVO;

public interface ReportService {

	void insertChatRep(ChatReportVO crvo);

	void updateMemRep(int memId);

	ArrayList<MemberVO> getAllMem();

	void adDelMem(int memId);

	ArrayList<ChatReportVO> getAllChatRep();

	void delRepChat(int chatReportId);

	ArrayList<RevReportVO> getAllRevRep();

	void delrevRep(int revRepId);

	void adDelQna(int qnaId);

	void delQnaRep(int qnaReportId);

}
