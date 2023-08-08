package com.three.cucumber.serviceImpl;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.three.cucumber.service.MemberService;
import com.three.cucumber.service.QnaService;
import com.three.cucumber.service.ReportQnaService;
import com.three.cucumber.service.dao.ReportQnaDAO;
import com.three.cucumber.vo.QnaVO;
import com.three.cucumber.vo.ReportQnaVO;

@Service("reportQnaService")
public class ReportQnaServiceImpl implements ReportQnaService {

	@Autowired
	private ReportQnaDAO rqdao;
	
	@Resource(name = "memberService")
	private MemberService mSer;
	
	@Resource(name = "qnaService")
	private QnaService qSer;
	
	@Override
	public void reportInsertofQna(ReportQnaVO rqvo) {
		// TODO Auto-generated method stub
		
		rqdao.reportInsertofQna(rqvo);
	}

	@Override
	public ArrayList<ReportQnaVO> allReportQna(ReportQnaVO qrvo) {
		return rqdao.allReportQna(qrvo);
	}

	@Override
	public ArrayList<ReportQnaVO> getEveryReportQna() {
		// TODO Auto-generated method stub
		ArrayList<ReportQnaVO> rqarray = rqdao.getEveryReportQna();
		for(int i=0; i<rqarray.size(); i++) {
			String qnaContent = qSer.findContent(rqarray.get(i).getQnaId());
			String reporterNick = mSer.findNick(rqarray.get(i).getQnaReportMem());
			
			rqarray.get(i).setQnaContent(qnaContent);
			rqarray.get(i).setReporterNick(reporterNick);
		}
		
		return rqarray;
	}

}
