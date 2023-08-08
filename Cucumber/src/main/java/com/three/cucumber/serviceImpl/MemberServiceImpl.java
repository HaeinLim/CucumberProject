package com.three.cucumber.serviceImpl;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.three.cucumber.service.MemberService;
import com.three.cucumber.service.dao.MemberDAO;
import com.three.cucumber.vo.MemberVO;

@Service("memberService")
public class MemberServiceImpl implements MemberService{
	
	@Autowired
	private MemberDAO memDAO; 
	
	@Transactional
	public int getMemseq() {
		return memDAO.getMemseq();
	}

	@Transactional
	public String nickCheck(String nick) {
		if (nick == null) return "no";
		int result = memDAO.nickCheck(nick);
		if (result == 0) {
			return "yes";
		}
		else {
			return "no";
		}
	}

	@Transactional
	public boolean insertMem(MemberVO mvo) {
		PwRSA rsa = new PwRSA();
		String salt = rsa.saltMake();
		String secretpw = rsa.sha256(mvo.getPw(), salt);
		mvo.setPw(secretpw);
		mvo.setPwSalt(salt);
		int re = memDAO.insertMem(mvo);
		if(re == 1) return true;
		else return false;
	}

	@Transactional
	public int emailCheck(String email) {
		return memDAO.emailCheck(email);
	}

	@Override
	public String findEmail(String phone) {
		return memDAO.findEmail(phone);
	}

	@Override
	public boolean updateMemPw(String pw, String email) {
		MemberVO mvo = new MemberVO();
		PwRSA rsa = new PwRSA();
		String salt = rsa.saltMake();
		String secretpw = rsa.sha256(pw, salt);
		mvo.setPw(secretpw);
		mvo.setPwSalt(salt);	
		mvo.setEmail(email);
		int re = memDAO.updateMemPw(mvo);
		if(re == 1) return true;
		else return false;
	}

	@Override
	public MemberVO login(MemberVO mvo) {
		MemberVO logmem = memDAO.login(mvo);
		if(logmem == null) {
			return null;
		}
		else {
			PwRSA rsa = new PwRSA();
			String secretpw = rsa.sha256(mvo.getPw(), logmem.getPwSalt());
			if(secretpw.equals(logmem.getPw()))
				return logmem;
			else return null;
		}
	}

	@Override
	public boolean update(MemberVO mvo) {
		if(mvo.getPw().equals("no")) {
			MemberVO mem = memDAO.login(mvo);
			String pw = mem.getPw();
			String salt = mem.getPwSalt();
			mvo.setPw(pw);
			mvo.setPwSalt(salt);
		}
		else {
			PwRSA rsa = new PwRSA();
			String salt = rsa.saltMake();
			String secretpw = rsa.sha256(mvo.getPw(), salt);
			mvo.setPw(secretpw);
			mvo.setPwSalt(salt);
		}
		int re = memDAO.updateMem(mvo);
		if(re == 1) return true;
		else return false;
	}

	@Override
	public MemberVO findMem(int memId) {
		// TODO Auto-generated method stub
		return memDAO.findMem(memId);
	}

	@Override
	public boolean updateMemTel(MemberVO mvo) {
		// TODO Auto-generated method stub
		return memDAO.updateMemTel(mvo);
	}

	@Override
	public int getSession(HttpServletRequest request) {
		HttpSession session = request.getSession();
		int memId = 0;
		if(session.getAttribute("sesId")!=null)
			memId = (Integer) session.getAttribute("sesId");
		return memId;
	}

	@Override
	public boolean updateMemNick(MemberVO mvo) {
		// TODO Auto-generated method stub
		return memDAO.updateMemNick(mvo);
	}

	@Override
	public boolean deleteMem(int memId) {
		// TODO Auto-generated method stub
		return memDAO.deleteMem(memId);
	}
	
	@Override
	public String findNick(int memId) {
		// TODO Auto-generated method stub
		return memDAO.findNick(memId);
	}

}
