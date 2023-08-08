package com.three.cucumber.service.dao;

import java.util.ArrayList;

import com.three.cucumber.vo.BuyVO;
import com.three.cucumber.vo.PostVO;
import com.three.cucumber.vo.RevVO;

public interface ProfileDAO {

	ArrayList<PostVO> getAllPostByLikey(int userId);

	ArrayList<BuyVO> getAllPostByBuy(int memId);

	void inRev(RevVO rvo);

	void upBuyRevCheck(int buyId);

	void upMemPoint(int receiver, int revPoint);

	ArrayList<RevVO> getAllRevByRec(int memId);

	ArrayList<RevVO> getAllRevByWri(int memId);

	void delBuyPost(int buyId);

	void delRev(int revId);

	RevVO findRev(int revId);

	void inRepRev(RevVO rvo);

	void upBuyRevCheckByRev(int revId);

	int findBuy(int revId);

	ArrayList<PostVO> getAllMyPostNow(int memId);

	ArrayList<PostVO> getAllMyPostDone(int memId);

	ArrayList<PostVO> getAllMyPostHide(int memId);

}
