package com.three.cucumber.serviceImpl;



import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.three.cucumber.service.PostService;
import com.three.cucumber.service.dao.PostDAO;
import com.three.cucumber.vo.CateVO;
import com.three.cucumber.vo.PostVO;

@Service("PostService")
public class PostServiceImpl implements PostService {
	
	@Autowired
	private PostDAO pdao;
	
	
	@Transactional
	public ArrayList<CateVO> getAllCate(){
		return pdao.getAllCate();
	}
	
	@Override
	public void insertPost(PostVO postvo) throws SQLException{
		
		pdao.insertPost(postvo);
	}
	
	@Override
	public String getMemNickPost(int memId) {
		return pdao.getMemNickPost(memId);
	}
	
	@Override
	public PostVO getPostVO(int postId) {
		return pdao.getPostVO(postId);
	}
	
	@Override
	public void updatePost(PostVO postvo) throws SQLException{
		pdao.updatePost(postvo);
	};
	
	@Override
	public int deletePost(int postId) {
		return pdao.deletePost(postId);
	}
	
	@Override
	public String findTitle(int postId) {
		// TODO Auto-generated method stub
		return pdao.findTitle(postId);
	}
}




