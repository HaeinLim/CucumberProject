package com.three.cucumber.service.dao;

import java.util.ArrayList;

import com.three.cucumber.vo.ReportQnaVO;

public interface ReportQnaDAO {

	void reportInsertofQna(ReportQnaVO rqvo);
	
	ArrayList<ReportQnaVO> allReportQna(ReportQnaVO qrvo);

	ArrayList<ReportQnaVO> getEveryReportQna();
}
