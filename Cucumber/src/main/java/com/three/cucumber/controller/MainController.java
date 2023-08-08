package com.three.cucumber.controller;

import java.util.ArrayList;
import java.util.HashMap;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.three.cucumber.service.HomeService;
import com.three.cucumber.service.LikeyService;
import com.three.cucumber.service.MemberService;
import com.three.cucumber.service.QnaService;
import com.three.cucumber.service.ReportPostService;
import com.three.cucumber.service.ReportQnaService;
import com.three.cucumber.vo.CateVO;
import com.three.cucumber.vo.Criteria;
import com.three.cucumber.vo.LikeyVO;
import com.three.cucumber.vo.MemberVO;
import com.three.cucumber.vo.PostVO;
import com.three.cucumber.vo.QnaVO;
import com.three.cucumber.vo.ReportPostVO;
import com.three.cucumber.vo.ReportQnaVO;

@Controller
public class MainController {

	@Resource(name = "homeService")
	private HomeService hSer;

	@Resource(name = "memberService")
	private MemberService mSer;

	@Resource(name = "qnaService")
	private QnaService qSer;
	
	@Resource(name = "likeyService")
	private LikeyService lSer;
	
	@Resource(name = "reportPostService")
	private ReportPostService rpSer;
	
	@Resource(name = "reportQnaService")
	private ReportQnaService rqSer;

	// 메인화면 띄움
	@RequestMapping(value = "main.do", method = RequestMethod.GET)
	public String homeMain(Model model, Criteria cri, String alarm) throws Exception {

		Criteria allparray = hSer.allSearch(cri);
		ArrayList<CateVO> carray = hSer.getAllCate();
		if(alarm == null) alarm = "no";

		model.addAttribute("alarm", alarm);
		model.addAttribute("carray", carray);
		model.addAttribute("cri", allparray);
		return "home/main";
	}

	// 쿠키 세팅하고 거래글 상세내용으로 들어가면 쿠키 없음 조회수 +1 증가
	@RequestMapping("detail.do")
	public String detail(@CookieValue(value = "view") String cookie, ReportQnaVO rqvo,HttpServletRequest request, HttpServletResponse response,
			 Integer postId, Model model ) throws Exception {  
		HttpSession session = request.getSession(false);
		if(session == null) {
			return "redirect:main.do?alarm=badmem";
		}

		System.out.println(postId);
		if (!(cookie.contains(String.valueOf(postId)))) {
			cookie += postId + "/";
			hSer.viewCount(postId);
		}
		response.addCookie(new Cookie("view", cookie));

		PostVO detail = hSer.detail(postId);
		MemberVO findMem = mSer.findMem(detail.getMemId());
		ArrayList<QnaVO> qarray = qSer.findMainQna(postId);
		HashMap<Integer, ArrayList<QnaVO>> qrmap = new HashMap<Integer, ArrayList<QnaVO>>();
		for (int i = 0; i < qarray.size(); i++) {
			int qnaId = qarray.get(i).getQnaId();
			ArrayList<QnaVO> qrarray = qSer.findReply(qnaId);
			qrmap.put(qnaId, qrarray);
		}
		
		ArrayList<ReportPostVO> rpvo = rpSer.allReportPost(postId);
		ArrayList<ReportQnaVO> rqarray = rqSer.allReportQna(rqvo);
		
		
		LikeyVO lvo = new LikeyVO(postId, mSer.getSession(request));
		
		int likey = lSer.checkLike(lvo);

		model.addAttribute("pdetail", detail);
		model.addAttribute("findMem", findMem);
		model.addAttribute("qarray", qarray);
		model.addAttribute("qrmap", qrmap);
		model.addAttribute("rpvo", rpvo);
		model.addAttribute("rqvo", rqarray);
		model.addAttribute("likey", likey);
		

		return "home/detail";
	}

	@RequestMapping(value = "insertQna.do", method = RequestMethod.POST)
	public String insertQna(QnaVO qvo, Model model) {
		/*
		 * 데이터 전달 확인용 if(qvo.getMemId() != 0)
		 * System.out.println("아이디는 "+qvo.getMemId()); if(qvo.getPostId() != 0)
		 * System.out.println("포스트 번호 "+qvo.getPostId()); if(qvo.getDepth() == 0)
		 * System.out.println("모댓글" + qvo.getDepth()); if(qvo.getQnaContent() != null)
		 * System.out.println("문의는 " +qvo.getQnaContent());
		 */

		qSer.insertQna(qvo);

		return "redirect:detail.do?postId=" + qvo.getPostId(); // detail.do를 불러올 땐 postId가 필요
	}

	@RequestMapping(value = "insertQnaReply.do", method = RequestMethod.POST)
	public String insertReply(QnaVO qvo, Model model) {
		/*
		 * 데이터 전달 확인용 if(qvo.getMemId() != 0)
		 * System.out.println("아이디는 "+qvo.getMemId()); if(qvo.getPostId() != 0)
		 * System.out.println("포스트 번호 "+qvo.getPostId()); if(qvo.getDepth() == 0)
		 * System.out.println("모댓글" + qvo.getDepth()); if(qvo.getBundleId() != 0)
		 * System.out.println("번들아이디 "+qvo.getBundleId()); if(qvo.getQnaContent() !=
		 * null) System.out.println("문의는 " +qvo.getQnaContent());
		 */

		qSer.insertReply(qvo);

		return "redirect:detail.do?postId=" + qvo.getPostId();
	}
	
	// likey in del ajax
	@RequestMapping(value="likey.do")
	@ResponseBody
	public int likePost(HttpServletRequest request, Integer postId, Model model) {
		LikeyVO vo = new LikeyVO(postId, mSer.getSession(request));
		
		int result = lSer.doLike(vo);
		
		return result;
	} 
	
	@RequestMapping(value="reportPost.do", method = RequestMethod.POST)
	public String reportPost(HttpServletRequest request, Model model, Integer postId,ReportPostVO rpvo) {
		
		rpvo.setPostReportMem(mSer.getSession(request));
		
		rpSer.reportInsertatPost(rpvo);
		
		return "redirect:detail.do?postId=" + rpvo.getPostId();
	}
	
	@RequestMapping(value="reportQna.do")
	public String reportQna(HttpServletRequest request, Model model, Integer postId, Integer qnaId) {
		ReportQnaVO rqvo = new ReportQnaVO();
		rqvo.setQnaReportMem(mSer.getSession(request));
		rqvo.setPostId(postId);
		rqvo.setQnaId(qnaId);
		rqSer.reportInsertofQna(rqvo);
		
		return "redirect:detail.do?postId=" + postId;
	}
	
	@RequestMapping(value="delQna.do")
	public String delQna(HttpServletRequest request, Model model, Integer qnaId, Integer postId, Integer depth) {
		
		qSer.delQna(qnaId, depth);
		
		return "redirect:detail.do?postId=" + postId;
	}
}