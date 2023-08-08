package com.three.cucumber.service.dao;

import java.util.ArrayList;

import com.three.cucumber.vo.ReportPostVO;

public interface ReportPostDAO {
	
	void reportInsertatPost(ReportPostVO rpvo);
	
	ArrayList<ReportPostVO> allReportPost(int postId);
	
	ArrayList<ReportPostVO> getEveryReportPost();

	void delRepPostByPost(int postId);

	void delRepPost(int postReportId);
}
