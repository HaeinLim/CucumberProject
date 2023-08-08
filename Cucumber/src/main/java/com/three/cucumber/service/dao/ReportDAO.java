package com.three.cucumber.service.dao;

import java.util.ArrayList;

import com.three.cucumber.vo.ChatReportVO;
import com.three.cucumber.vo.ChatVO;
import com.three.cucumber.vo.MemberVO;
import com.three.cucumber.vo.RevReportVO;

public interface ReportDAO {

	void insertChatRep(ChatReportVO crvo);

	void updateMemRep(int memId);

	ArrayList<MemberVO> getAllMem();

	ArrayList<ChatReportVO> getAllChatRep();

	void delRepChat(int chatReportId);

	ArrayList<RevReportVO> getAllRevRep();

	void delrevRep(int revRepId);

	void delQnaRep(int qnaReportId);

	int getQnaDepth(int qnaId);

}
