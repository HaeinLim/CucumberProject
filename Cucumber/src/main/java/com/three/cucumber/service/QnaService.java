package com.three.cucumber.service;

import java.util.ArrayList;

import com.three.cucumber.vo.QnaVO;

public interface QnaService {

	ArrayList<QnaVO> findMainQna(int postId);

	ArrayList<QnaVO> findReply(int postId);

	void insertQna(QnaVO qvo);

	void insertReply(QnaVO qvo);

	ArrayList<QnaVO> findMemId(int qnaId);

	ArrayList<QnaVO> allQna(int postId);

	void delQna(int qnaId, int depth);
	
	String findContent(int qnaId);
}
