package com.three.cucumber.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.three.cucumber.service.MemberService;
import com.three.cucumber.service.ProfileService;
import com.three.cucumber.service.ReportPostService;
import com.three.cucumber.service.ReportQnaService;
import com.three.cucumber.service.ReportService;
import com.three.cucumber.vo.ChatReportVO;
import com.three.cucumber.vo.ChatVO;
import com.three.cucumber.vo.MemberVO;
import com.three.cucumber.vo.ReportPostVO;
import com.three.cucumber.vo.ReportQnaVO;
import com.three.cucumber.vo.RevReportVO;

@Controller
public class AdminController {

	@Resource(name="reportPostService")
	private ReportPostService rpSer;
	
	@Resource(name="reportQnaService")
	private ReportQnaService rqSer;
	
	@Resource(name="memberService")
	private MemberService memSer;
	
	@Resource(name="reportService")
	private ReportService repSer;
	
	@Resource(name="profileService")
	private ProfileService proSer;
	
	@RequestMapping(value="adminPage.do")
	public String adminPage(HttpServletRequest request, Model model) {
		MemberVO mvo = memSer.findMem( memSer.getSession(request));
		model.addAttribute("mvo", mvo);
		return "admin/adminPage";
	}
	// 게시물 신고 조회 페이지로
	@RequestMapping(value="getEveryReportPost.do")
	public String getEveryReportPost(Model model) {
		
		ArrayList<ReportPostVO> getEveryReportPost = rpSer.getEveryReportPost();
		
		model.addAttribute("getEveryReportPost", getEveryReportPost);
		
		return "admin/adReportPost";
	}
	@RequestMapping(value = "AdDelPost.do")
	public String AdDelPost(Integer postId) throws SQLException {
		rpSer.AdDelPost(postId);
		return "redirect:getEveryReportPost.do";
	}
	
	@RequestMapping(value = "delrepPost.do")
	public String delrepPost(Integer postReportId) {
		rpSer.delRepPost(postReportId);
		return "redirect:getEveryReportPost.do";
	}
	
// 문의 신고 조회 페이지로
	@RequestMapping(value="getEveryReportQna.do")
	public String getEveryReportQna(Model model) {
		
		ArrayList<ReportQnaVO> getEveryReportQna = rqSer.getEveryReportQna();
		
		model.addAttribute("getEveryReportQna", getEveryReportQna);
		
		return "admin/adReportQna";
	}

	@RequestMapping(value = "member.do")
	public String member(Model model) {
		ArrayList<MemberVO> marray = repSer.getAllMem();
		model.addAttribute("marray", marray);
		return "admin/member";
	}
	
	@RequestMapping(value = "adDelMem.do")
	public String adDelMem(Model model, Integer memId) {
		repSer.adDelMem(memId);
		return "redirect:member.do";
	}
	@RequestMapping(value="chatRep.do")
	public String adChatRep(Model model) {
		ArrayList<ChatReportVO> carray =  repSer.getAllChatRep();
		model.addAttribute("carray", carray);
		return "admin/chatRep";
	}
	@RequestMapping(value="memAl.do")
	public String memAl(Model model, Integer memId) {
		repSer.updateMemRep(memId);
		return "redirect:chatRep.do";
	}
	@RequestMapping(value="delrepChat.do")
	public String delrepChat(Model model, Integer chatReportId) {
		repSer.delRepChat(chatReportId);
		return "redirect:chatRep.do";
	}
	@RequestMapping(value="getAllRevRep.do")
	public String getAllRevRep(Model model) {
		ArrayList<RevReportVO> rarray = repSer.getAllRevRep();
		model.addAttribute("rarray", rarray);
		return "admin/revRep";
	}
	@RequestMapping(value="addelRev.do")
	public String delRev(Model model, Integer revId) {
		proSer.delRev(revId);
		return "redirect:getAllRevRep.do";
	}
	@RequestMapping(value="delrevRep.do")
	public String delrevRep(Model model, Integer revRepId) {
		repSer.delrevRep(revRepId);
		return "redirect:getAllRevRep.do";
	}
	@RequestMapping(value="adDelQna.do")
	public String adDelQna(Model model, Integer qnaId) {
		repSer.adDelQna(qnaId);
		return "redirect:getEveryReportQna.do";
	}
	@RequestMapping(value="adDelRepQna.do")
	public String adDelRepQna(Model model, Integer qnaReportId) {
		repSer.delQnaRep(qnaReportId);
		return "redirect:getEveryReportQna.do";
	}
}
