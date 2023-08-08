package com.three.cucumber.serviceImpl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.three.cucumber.service.ReportService;
import com.three.cucumber.service.dao.MemberDAO;
import com.three.cucumber.service.dao.QnaDAO;
import com.three.cucumber.service.dao.ReportDAO;
import com.three.cucumber.vo.ChatReportVO;
import com.three.cucumber.vo.ChatVO;
import com.three.cucumber.vo.MemberVO;
import com.three.cucumber.vo.RevReportVO;

@Service("reportService")
public class ReportServiceImpl implements ReportService{
	
	@Autowired
	private ReportDAO repDAO;
	
	@Autowired
	private MemberDAO memDAO;
	
	@Autowired
	private QnaDAO qnaDAO;
	
	@Autowired
	private MailSendService mailService;

	@Override
	public void insertChatRep(ChatReportVO crvo) {
		repDAO.insertChatRep(crvo);	
	}

	@Override
	public void updateMemRep(int memId) {
		repDAO.updateMemRep(memId);	
	}

	@Override
	public ArrayList<MemberVO> getAllMem() {
		// TODO Auto-generated method stub
		return repDAO.getAllMem();
	}

	@Override
	public void adDelMem(int memId) {
		MemberVO mvo = memDAO.findMem(memId);
		int re = 1;//mailService.sendDel(mvo.getEmail());
		if (re ==1)
			memDAO.deleteMem(memId);
		
	}

	@Override
	public ArrayList<ChatReportVO> getAllChatRep() {
		return repDAO.getAllChatRep();
	
	}

	@Override
	public void delRepChat(int chatReportId) {
		repDAO.delRepChat(chatReportId);
		
	}

	@Override
	public ArrayList<RevReportVO> getAllRevRep() {
		// TODO Auto-generated method stub
		return repDAO.getAllRevRep();
	}

	@Override
	public void delrevRep(int revRepId) {
		// TODO Auto-generated method stub
		repDAO.delrevRep(revRepId);
	}

	@Override
	public void adDelQna(int qnaId) {
		int depth = repDAO.getQnaDepth(qnaId);
		if(depth ==0 )
			qnaDAO.delMainQna(qnaId);
		else
			qnaDAO.delSubQna(qnaId);
		
	}

	@Override
	public void delQnaRep(int qnaReportId) {
		repDAO.delQnaRep(qnaReportId);
		
	}

}
