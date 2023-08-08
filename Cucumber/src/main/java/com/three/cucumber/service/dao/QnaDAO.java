package com.three.cucumber.service.dao;

import java.util.ArrayList;

import com.three.cucumber.vo.QnaVO;

public interface QnaDAO {

	ArrayList<QnaVO> findMainQna(int postId);
	
	ArrayList<QnaVO> findReply(int postId);
	
	void insertQna(QnaVO qvo);
	
	void insertReply(QnaVO qvo);
	
	ArrayList<QnaVO> findMemId(int qnaId);
	
	ArrayList<QnaVO> allQna(int postId);

	void delMainQna(int qnaId);

	void delSubQna(int qnaId);
	
	String findContent(int qnaId);
}
