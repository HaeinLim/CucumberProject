package com.three.cucumber.controller;

import java.util.ArrayList;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.three.cucumber.service.MemberService;
import com.three.cucumber.service.PostService;
import com.three.cucumber.service.ProfileService;
import com.three.cucumber.vo.BuyVO;
import com.three.cucumber.vo.MemberVO;
import com.three.cucumber.vo.PostVO;
import com.three.cucumber.vo.RevVO;

@Controller
public class ProfileController {
	
	@Resource(name="memberService")
	private MemberService memSer;
	
	@Resource(name="profileService")
	private ProfileService proSer;
	
	@Resource(name="PostService")
	private PostService postSer;
	
	@RequestMapping(value = "rev.do", method = RequestMethod.GET)
	public String rev(HttpServletRequest request, Model model, Integer receiver, Integer buyId) {
		HttpSession session = request.getSession(false);
		if(session.getAttribute("sesId")==null) {
			return "redirect:main.do?alarm=badmem";
		}
		String nick = memSer.findNick(receiver);
		model.addAttribute("buyId", buyId);
		 model.addAttribute("receiver", receiver);
		 model.addAttribute("nick", nick);
		return "/profile/rev";
	}
	
	@RequestMapping(value = "inRev.do", method = RequestMethod.POST)
	public String inRev(HttpServletRequest request, Model model, RevVO rvo) {
		HttpSession session = request.getSession(false);
		if(session.getAttribute("sesId")==null) {
			return "redirect:main.do?alarm=badmem";
		}
		rvo.setRevWriter(memSer.getSession(request));
		proSer.inRev(rvo);
		return "redirect:allRev.do";
	}
	
	@RequestMapping(value = "mypage.do", method = RequestMethod.GET)
	public String mypage(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession(false);
		if(session.getAttribute("sesId")==null) {
			return "redirect:main.do?alarm=badmem";
		}
		MemberVO mvo = memSer.findMem(memSer.getSession(request));
		model.addAttribute("mvo", mvo);
		return "/profile/mypage";
	}
	
	
	@RequestMapping(value = "youpage.do", method = RequestMethod.GET)
	public String youpage(HttpServletRequest request, Integer memId, Model model) {
		HttpSession session = request.getSession(false);
		if(session.getAttribute("sesId")==null) {
			return "redirect:main.do?alarm=badmem";
		}
		MemberVO mvo = memSer.findMem(memId);
		model.addAttribute("mvo", mvo);
		return "/profile/youpage";
	}
	
	@RequestMapping(value="likeyPost.do", method = RequestMethod.GET)
	public String likeyPost(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession(false);
		if(session.getAttribute("sesId")==null) {
			return "redirect:main.do?alarm=badmem";
		}
		ArrayList<PostVO> parray = proSer.getAllPostByLikey(memSer.getSession(request));
		
		model.addAttribute("parray", parray);
		return "/my/likeyPost";
	}
	
	@RequestMapping(value="buyPost.do", method = RequestMethod.GET)
	public String buyPost(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession(false);
		if(session.getAttribute("sesId")==null) {
			return "redirect:main.do?alarm=badmem";
		}
		ArrayList<BuyVO> parray = proSer.getAllPostByBuy(memSer.getSession(request));
		
		model.addAttribute("parray", parray);
		return "/my/buyPost";
	}
	
	@RequestMapping(value="delBuyPost.do", method = RequestMethod.GET)
	public String delBuyPost(HttpServletRequest request, Model model, Integer buyId) {
		HttpSession session = request.getSession(false);
		if(session.getAttribute("sesId")==null) {
			return "redirect:main.do?alarm=badmem";
		}
		proSer.delBuyPost(buyId);
		return "/my/buyPost";
	}

	@RequestMapping(value="allRev.do", method = RequestMethod.GET)
	public String allRev(HttpServletRequest request, String revRad, Integer memId, Model model) {
		HttpSession session = request.getSession(false);
		if(session.getAttribute("sesId")==null) {
			return "redirect:main.do?alarm=badmem";
		}
		// 내가 쓰거나 받은 후기(다른 회원도 마찬가지)
		// 멤아이디 값이 널이면 내꺼
		// 값이 있고 sesId 와 같지 않으면 다른 사람까
		// 내가쓴건지 다른사람이 쓴건지에 대한 선택값을 가져온다
		if(memId == null) memId = memSer.getSession(request);
		if(revRad == null) revRad = "receive"; // 기본은 받은 후기
		ArrayList<RevVO> rarray = proSer.getAllRev(memId,revRad);
		model.addAttribute("memId", memId);
		model.addAttribute("revRad", revRad);
		model.addAttribute("rarray", rarray);
		// revArray를 넘긴다
		return "/my/myRev";
	}
	
	@RequestMapping(value="delRev.do", method = RequestMethod.GET)
	public String delRev(HttpServletRequest request, Model model, Integer revId) {
		HttpSession session = request.getSession(false);
		if(session.getAttribute("sesId")==null) {
			return "redirect:main.do?alarm=badmem";
		}
		proSer.delRev(revId);
		return "redirect:allRev.do";
	}
	
	@RequestMapping(value="repRev.do", method = RequestMethod.POST)
	@ResponseBody
	public String repRev(HttpServletRequest request, Model model, Integer revId) {
		HttpSession session = request.getSession(false);
		if(session.getAttribute("sesId")==null) {
			return "redirect:main.do?alarm=badmem";
		}
		proSer.repRev(revId);
		return "redirect:allRev.do";
	}
	
	@RequestMapping(value="myPost.do", method = RequestMethod.GET)
	public String myPost(HttpServletRequest request, String postRad, Model model) {
		HttpSession session = request.getSession(false);
		if(session.getAttribute("sesId")==null) {
			return "redirect:main.do?alarm=badmem";
		}
		// 게시물
		// 판매중(+거래중), 숨김, 거래완료 게시물을  표시
		if(postRad == null) postRad = "판매중";
		int memId = memSer.getSession(request);
		ArrayList<PostVO> parray = proSer.getAllMyPost(postRad, memId);
		// postArray를 넘긴다
		model.addAttribute("parray", parray);
		model.addAttribute("postRad", postRad);
		return "/my/myPost";
	}
	
	@RequestMapping(value="otherPost.do", method = RequestMethod.GET)
	public String otherPost(HttpServletRequest request, Integer memId, Model model) {
		HttpSession session = request.getSession(false);
		if(session.getAttribute("sesId")==null) {
			return "redirect:main.do?alarm=badmem";
		}
		// 다른 사람의 판매중, 거래중 게시물
		ArrayList<PostVO> parray = proSer.getAllOtherPost(memId);
		model.addAttribute("parray", parray);
		return "/my/otherPost";
	} 
}
