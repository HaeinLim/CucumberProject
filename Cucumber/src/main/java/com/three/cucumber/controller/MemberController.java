package com.three.cucumber.controller;


import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.three.cucumber.service.MemberService;
import com.three.cucumber.serviceImpl.MailSendService;
import com.three.cucumber.serviceImpl.SmsService;
import com.three.cucumber.vo.MemberVO;
import com.three.cucumber.vo.PhoneResSMSVO;

@Controller
public class MemberController {
	 
	@Resource(name="memberService")
	private MemberService memSer;

	@Resource(name="smsService")
	private SmsService smsSer;
	
	@Autowired
	private MailSendService mailService;
	
	@RequestMapping(value = "join.do", method = RequestMethod.GET)
	public String getAllMem(MemberVO mvo, Model model) {
		// 넘어올 값은 없음
		int num = memSer.getMemseq();
		model.addAttribute("num", num);
		return "/member/join";
	}
	
	@RequestMapping(value="mailcheck.do", method=RequestMethod.POST)
	@ResponseBody
	public String email(String email) {
		int re = memSer.emailCheck(email);
		if (re == 0) {
			String rannum = mailService.joinEmail(email);
			return rannum;
		}
		else return "no";
	}
	
	@RequestMapping(value="nickcheck.do", method=RequestMethod.POST)
	@ResponseBody
	public String nick(String nick) {
		String result = memSer.nickCheck(nick);
		return result;
	}
	
	@RequestMapping(value="phonecheck.do", method=RequestMethod.POST)
	@ResponseBody
	public String phone(String phone) throws JsonProcessingException, InvalidKeyException, UnsupportedEncodingException, NoSuchAlgorithmException, ParseException, URISyntaxException {
		// 휴대폰 인증
		PhoneResSMSVO vo = smsSer.sendSms(phone); // 인증번호 담겨있음
		String rannum = vo.getContent();
		return rannum;
	}
	
	@RequestMapping(value = "insertMem.do", method = RequestMethod.POST)
	public String insertMem(String Femail, String Lemail, String Ftel, String Mtel, String Ltel,@ModelAttribute("memberVO") MemberVO mvo, Model model) {
		mvo.setEmail(Femail + "@" + Lemail);
		mvo.setTel(Ftel+"-"+Mtel+"-"+Ltel);
		mvo.setAdmin("no");
		boolean re = memSer.insertMem(mvo);
		return "/member/login";
	}
	
	@RequestMapping(value = "findEmail.do", method = RequestMethod.GET)
	public String findEmail() {
		return "/member/findEmail";
	}
	
	@RequestMapping(value="phoneToEmail.do", method=RequestMethod.POST)
	@ResponseBody
	public HashMap<String, String> phoneToEmail(String phone) throws JsonProcessingException, InvalidKeyException, UnsupportedEncodingException, NoSuchAlgorithmException, ParseException, URISyntaxException {
		PhoneResSMSVO vo = smsSer.sendSms(phone); // 인증번호 담겨있음
		String rannum = vo.getContent();
		String email = memSer.findEmail(phone);
		System.out.println(email);
		HashMap<String, String> data = new HashMap<String, String>();
		data.put("email", email);
		data.put("rannum", rannum);
		return data;
	}
	
	@RequestMapping(value = "findPw.do", method = RequestMethod.GET)
	public String findPw() {
		return "/member/findPw";
	}
	
	@RequestMapping(value="mailtoPw.do", method=RequestMethod.POST)
	@ResponseBody
	public void mailtoPw(String email) {
		String pw = mailService.sendPw(email);
		memSer.updateMemPw(pw, email);
	}
	
	@RequestMapping(value = "login.do", method = RequestMethod.GET)
	public String login() {
		return "/member/login";
	}
	@RequestMapping(value = "session.do", method = RequestMethod.POST)
	public String makeSes(MemberVO mvo, HttpServletRequest request, HttpServletResponse response, Model model) {
		MemberVO logmem = memSer.login(mvo);
		if(logmem == null) {
			model.addAttribute("noses", "noses");
			return "/member/login";
		}
		else {
			HttpSession session = request.getSession();
			session.setAttribute("sesId", logmem.getMemId());
			session.setAttribute("sesEmail", logmem.getEmail());
			if(logmem.getAdmin() != null & logmem.getAdmin().equals("admin"))
				session.setAttribute("sesAd", logmem.getAdmin());
			 Cookie cookie =new Cookie("view",null);    //view라는 이름의 쿠키 생성
		      cookie.setComment("게시글 조회 확인");      //해당 쿠키가 어떤 용도인지 커멘트
		      cookie.setMaxAge(60*60*24*365);         //해당 쿠키의 유효시간을 설정 (초 기준)
		      response.addCookie(cookie);            //사용자에게 해당 쿠키를 추가
			return "redirect:main.do";
		}
	}
	
	@RequestMapping(value = "logout.do", method = RequestMethod.GET)
	public String loginout(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession(false);
		if(session != null)
			session.invalidate();
		return "redirect:main.do?alarm=logout";
	}
	
	@RequestMapping(value = "memCheck.do", method = RequestMethod.GET)
	public String memCheck(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession(false);
		if(session.getAttribute("sesId")==null) {
			return "redirect:main.do?alarm=badmem";
		}
		return "/member/memCheck";
	}
	
	@RequestMapping(value = "memUpdateForm.do", method = RequestMethod.POST)
	public String memUpdateForm(HttpServletRequest request, MemberVO mvo, Model model) {
		HttpSession session = request.getSession(false);
		if(session.getAttribute("sesId")==null) {
			return "redirect:main.do?alarm=badmem";
		}
		MemberVO logmem = memSer.login(mvo);
		if(logmem == null) {
			model.addAttribute("noses", "noses");
			return "/member/memCheck";
		}
		else {
			String[] tel = logmem.getTel().split("-");
			model.addAttribute("mvo", logmem);
			model.addAttribute("tel", tel);
			return "/member/update";
		}
	}
	
	@RequestMapping(value = "updateMem.do", method = RequestMethod.POST)
	public String updateMem(HttpServletRequest request, Model model, MemberVO mvo, String Ftel, String Mtel, String Ltel) {
		HttpSession session = request.getSession(false);
		if(session.getAttribute("sesId")==null) {
			return "redirect:main.do?alarm=badmem";
		}
		mvo.setTel(Ftel+"-"+Mtel+"-"+Ltel);
		System.out.println(mvo.getPw());
		memSer.update(mvo);
		return "/member/test";
	}
	
	@RequestMapping(value = "backUpdate.do", method = RequestMethod.GET)
	public String backUpdate(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession(false);
		if(session.getAttribute("sesId")==null) {
			return "redirect:main.do?alarm=badmem";
		}
		MemberVO mvo = memSer.findMem(memSer.getSession(request));
		String[] tel = mvo.getTel().split("-");
		model.addAttribute("mvo", mvo);
		model.addAttribute("tel", tel);
		return "/member/update";
	}
	
	@RequestMapping(value = "nickUpdateForm.do", method = RequestMethod.GET)
	public String nickUpdateForm(HttpServletRequest request, MemberVO mvo, Model model) {
		HttpSession session = request.getSession(false);
		if(session.getAttribute("sesId")==null) {
			return "redirect:main.do?alarm=badmem";
		}
		model.addAttribute("mvo", mvo);
		return "/member/updateNick";
	}
	
	@RequestMapping(value = "telUpdateForm.do", method = RequestMethod.GET)
	public String telUpdateForm(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession(false);
		if(session.getAttribute("sesId")==null) {
			return "redirect:main.do?alarm=badmem";
		}
		MemberVO mvo = memSer.findMem(memSer.getSession(request));
		String[] tel = mvo.getTel().split("-");
		model.addAttribute("tel", tel);
		return "/member/updateTel";
	}
	
	@RequestMapping(value = "telUpdate.do", method = RequestMethod.POST)
	public String telUpdate(HttpServletRequest request, String Ftel, String Mtel, String Ltel, Model model) {
		HttpSession session = request.getSession(false);
		if(session.getAttribute("sesId")==null) {
			return "redirect:main.do?alarm=badmem";
		}
		MemberVO mvo = new MemberVO();
		mvo.setTel(Ftel+"-"+Mtel+"-"+Ltel);
		int memId = memSer.getSession(request);
		mvo.setMemId(memId);
		boolean re = memSer.updateMemTel(mvo);
		System.out.println(re);
		MemberVO upmem = memSer.findMem(memId);
		String[] tel = mvo.getTel().split("-");
		model.addAttribute("mvo", upmem);
		model.addAttribute("tel", tel);
		return "/member/update";
	}
	
	@RequestMapping(value = "nickUpdate.do", method = RequestMethod.POST)
	public String nickUpdate(HttpServletRequest request, MemberVO mvo, Model model) {
		HttpSession session = request.getSession(false);
		if(session.getAttribute("sesId")==null) {
			return "redirect:main.do?alarm=badmem";
		}
		int memId = memSer.getSession(request);
		mvo.setMemId(memId);
		boolean re = memSer.updateMemNick(mvo);
		System.out.println(re);
		MemberVO upmem = memSer.findMem(memId);
		String[] tel = upmem.getTel().split("-");
		model.addAttribute("mvo", upmem);
		model.addAttribute("tel", tel);
		return "redirect:mypage.do";
	}
	
	@RequestMapping(value = "deleteMem.do", method = RequestMethod.GET)
	public String nickUpdate(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession(false);
		if(session.getAttribute("sesId")==null) {
			return "redirect:main.do?alarm=badmem";
		}
		boolean re = memSer.deleteMem(memSer.getSession(request));
		System.out.println(re);
		if(session != null)
			session.invalidate();
		return "redirect:main.do?alarm=logout";
	}
	
}
