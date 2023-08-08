package com.three.cucumber.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.three.cucumber.vo.CateVO;
import com.three.cucumber.vo.PostVO;

public interface PostService {
	
	ArrayList<CateVO> getAllCate() throws Exception;
	
	public void insertPost(PostVO postvo) throws SQLException;
	
	public String getMemNickPost(int memId) throws SQLException;
	
	PostVO getPostVO(int postId) throws SQLException;
	
	public void updatePost(PostVO postvo) throws SQLException;
	
	public int deletePost(int postId) throws SQLException;
	
	String findTitle(int postId);
}
