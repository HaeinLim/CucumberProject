package com.three.cucumber.serviceImpl;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.three.cucumber.service.MemberService;
import com.three.cucumber.service.QnaService;
import com.three.cucumber.service.dao.QnaDAO;
import com.three.cucumber.vo.QnaVO;

@Service("qnaService")
public class QnaServiceImpl implements QnaService {

	@Autowired
	private QnaDAO qdao;
	
	@Resource(name="memberService")
	private MemberService mSer;

	
	@Override
	public ArrayList<QnaVO> findMainQna(int postId) {
		// TODO Auto-generated method stub
		ArrayList<QnaVO> qarray = qdao.findMainQna(postId);

		for(int i=0; i<qarray.size(); i++) {
			String nick = mSer.findNick(qarray.get(i).getMemId());
			qarray.get(i).setNick(nick);
		}
		return qarray;
	}
	
	@Override
	public ArrayList<QnaVO> findReply(int postId) {
		// TODO Auto-generated method stub
		ArrayList<QnaVO> qarray = qdao.findReply(postId);

		for(int i=0; i<qarray.size(); i++) {
			String nick = mSer.findNick(qarray.get(i).getMemId());
			qarray.get(i).setNick(nick);
		}
		return qarray;
	}

	@Override
	public void insertQna(QnaVO qvo) {
		// TODO Auto-generated method stub
		qdao.insertQna(qvo);
	}

	@Override
	public void insertReply(QnaVO qvo) {
		// TODO Auto-generated method stub
		qdao.insertReply(qvo);
	}

	@Override
	public ArrayList<QnaVO> findMemId(int qnaId) {
		// TODO Auto-generated method stub
		return qdao.findMemId(qnaId);
	}

	@Override
	public ArrayList<QnaVO> allQna(int postId) {
		// TODO Auto-generated method stub
		return qdao.allQna(postId);
	}

	@Override
	public void delQna(int qnaId, int depth) {
		if(depth == 0) {
			qdao.delMainQna(qnaId);
		}
		else qdao.delSubQna(qnaId);
	}

	@Override
	public String findContent(int qnaId) {
		// TODO Auto-generated method stub
		return qdao.findContent(qnaId);
	}

}
