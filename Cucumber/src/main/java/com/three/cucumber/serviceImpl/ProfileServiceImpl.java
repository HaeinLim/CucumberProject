package com.three.cucumber.serviceImpl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.three.cucumber.service.ProfileService;
import com.three.cucumber.service.dao.ChatDAO;
import com.three.cucumber.service.dao.MemberDAO;
import com.three.cucumber.service.dao.ProfileDAO;
import com.three.cucumber.vo.BuyVO;
import com.three.cucumber.vo.PostVO;
import com.three.cucumber.vo.RevVO;

@Service("profileService")
public class ProfileServiceImpl implements ProfileService{

	@Autowired
	private ProfileDAO proDAO;
	
	@Autowired
	private MemberDAO memDAO;
	
	
	
	@Override
	public ArrayList<PostVO> getAllPostByLikey(int session) {
		// TODO Auto-generated method stub
		return proDAO.getAllPostByLikey(session);
	}

	@Override
	public ArrayList<BuyVO> getAllPostByBuy(int session) {
		// TODO Auto-generated method stub
		return proDAO.getAllPostByBuy(session);
	}

	@Override
	public void inRev(RevVO rvo) {
		proDAO.inRev(rvo);
		proDAO.upMemPoint(rvo.getRevReceiver(),rvo.getRevPoint());
		proDAO.upBuyRevCheck(rvo.getBuyId());
		
	}

	@Override
	public ArrayList<RevVO> getAllRev(Integer memId, String revRad) {
		if(revRad.equals("receive")) {
			ArrayList<RevVO> rrev = proDAO.getAllRevByRec(memId);
			for(int i=0; i<rrev.size(); i++) {
				rrev.get(i).setNick(memDAO.findNick(rrev.get(i).getRevWriter()) );
			}
			return rrev;
		}
		else {
			ArrayList<RevVO> wrev = proDAO.getAllRevByWri(memId);
			for(int i=0; i<wrev.size(); i++) {
				wrev.get(i).setNick(memDAO.findNick(wrev.get(i).getRevReceiver()) );
			}
			return wrev;
		}
	}

	@Override
	public void delBuyPost(int buyId) {
		proDAO.delBuyPost(buyId);
		
	}

	@Override
	public void delRev(int revId) {
		proDAO.delRev(revId);
		if(proDAO.findBuy(revId) != 0)
		proDAO.upBuyRevCheckByRev(revId);
	}

	@Override
	public void repRev(int revId) {
		RevVO rvo = proDAO.findRev(revId);
		proDAO.inRepRev(rvo);
		
	}

	@Override
	public ArrayList<PostVO> getAllMyPost(String postRad, int memId) {
		if(postRad.equals("판매중"))
			return proDAO.getAllMyPostNow(memId);
		else if(postRad.equals("거래완료"))
			return proDAO.getAllMyPostDone(memId);
		else 
			return proDAO.getAllMyPostHide(memId);
	}

	@Override
	public ArrayList<PostVO> getAllOtherPost(int memId) {
		// TODO Auto-generated method stub
		return proDAO.getAllMyPostNow(memId);
	}
	

}
