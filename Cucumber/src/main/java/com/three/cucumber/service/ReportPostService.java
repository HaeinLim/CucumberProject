package com.three.cucumber.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.three.cucumber.vo.ReportPostVO;

public interface ReportPostService {

	void reportInsertatPost(ReportPostVO rpvo);
	
	ArrayList<ReportPostVO> allReportPost(int postId);
	
	ArrayList<ReportPostVO> getEveryReportPost();

	void AdDelPost(int postId) throws SQLException;

	void delRepPost(int postReportId);
}
