package com.three.cucumber.service.dao;


import java.util.ArrayList;

import com.three.cucumber.vo.CateVO;
import com.three.cucumber.vo.PostVO;

public interface PostDAO {
	
	ArrayList<CateVO> getAllCate();
	
	void insertPost(PostVO postvo);
	
	String getMemNickPost(int memId);
	
	PostVO getPostVO(int postId);
	
	void updatePost(PostVO postvo);
	
	int deletePost(int postId);

	String findTitle(int postId);
	
}
