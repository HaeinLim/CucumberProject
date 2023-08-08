package com.three.cucumber.service;

import java.util.ArrayList;

import com.three.cucumber.vo.BuyVO;
import com.three.cucumber.vo.PostVO;
import com.three.cucumber.vo.RevVO;

public interface ProfileService {

	ArrayList<PostVO> getAllPostByLikey(int session);

	ArrayList<BuyVO> getAllPostByBuy(int session);
	
	void inRev(RevVO rvo);

	ArrayList<RevVO> getAllRev(Integer memId, String revRad);

	void delBuyPost(int buyId);

	void delRev(int revId);

	void repRev(int revId);

	ArrayList<PostVO> getAllMyPost(String postRad, int memId);

	ArrayList<PostVO> getAllOtherPost(int memId);

}
