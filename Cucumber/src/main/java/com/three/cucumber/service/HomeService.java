package com.three.cucumber.service;

import java.util.ArrayList;

import com.three.cucumber.vo.CateVO;
import com.three.cucumber.vo.Criteria;
import com.three.cucumber.vo.PostVO;

public interface HomeService {

	
	ArrayList<CateVO> getAllCate() throws Exception;

	Criteria allSearch(Criteria cri) throws Exception;
	
	void viewCount(int postId) throws Exception;
	
	PostVO detail(int postId);

}
