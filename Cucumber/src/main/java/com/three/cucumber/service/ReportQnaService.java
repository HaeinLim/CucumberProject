package com.three.cucumber.service;

import java.util.ArrayList;

import com.three.cucumber.vo.ReportQnaVO;

public interface ReportQnaService {

	void reportInsertofQna(ReportQnaVO rqvo);
	
	ArrayList<ReportQnaVO> getEveryReportQna();

	ArrayList<ReportQnaVO> allReportQna(ReportQnaVO qrvo);
}
