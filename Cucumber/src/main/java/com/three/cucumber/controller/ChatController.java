package com.three.cucumber.controller;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.three.cucumber.service.ChatService;
import com.three.cucumber.service.MemberService;
import com.three.cucumber.service.PostService;
import com.three.cucumber.vo.BuyVO;
import com.three.cucumber.vo.ChatLogVO;
import com.three.cucumber.vo.ChatVO;
import com.three.cucumber.vo.MemberVO;
import com.three.cucumber.vo.MsgVO;
import com.three.cucumber.vo.PostVO;

@Controller
public class ChatController {
	
	@Resource(name="chatService")
	private ChatService chatSer;
	
	@Resource(name="memberService")
	private MemberService memSer;
	
	@Resource(name="PostService")
	private PostService postSer;
	
	@RequestMapping(value="insertChat.do") 
	public String insertChat(HttpServletRequest request, Integer postId) {
		int chatId = chatSer.insertchat(postId, memSer.getSession(request));
		return "redirect:findChat.do?chatId="+chatId;
	}
	
	 @RequestMapping(value="chatlist.do") 
	 private String getAllChat(HttpServletRequest request, Model model) {
			HttpSession session = request.getSession(false);
			if(session.getAttribute("sesId")==null) {
				return "redirect:main.do?alarm=badmem";
			}
		 int memId = memSer.getSession(request);
		 ArrayList<ChatVO> carray = chatSer.getAllChat(memId);
		 HashMap<Integer, Integer> cntmap = chatSer.getAllMsgCount(memId);
		 HashMap<Integer, String> pmap = chatSer.getAllPost(memId);
		 HashMap<Integer, MemberVO> nickmap = chatSer.getAllNick(memId);
		 model.addAttribute("nickmap", nickmap);
		 model.addAttribute("pmap", pmap);
		 model.addAttribute("carray", carray);
		 model.addAttribute("cntmap", cntmap);
		 return "/chat/chat"; 
	 }
	 @RequestMapping(value="findChat.do") 
	 private String findChat(HttpServletRequest request, Integer chatId, Model model) {
			HttpSession session = request.getSession(false);
			if(session.getAttribute("sesId")==null) {
				return "redirect:main.do?alarm=badmem";
			}
		 int memId = memSer.getSession(request);
		 chatSer.updateMsgRead(chatId,memId);
		 ArrayList<MsgVO> marray = chatSer.getAllMsg(chatId, memId); 
		 PostVO pvo = chatSer.findPost(chatId);
		 MemberVO nick = chatSer.findNick(chatId, memId);
		 model.addAttribute("chatId", chatId);
		 model.addAttribute("nick", nick);
		 model.addAttribute("marray", marray);
		 model.addAttribute("pvo", pvo);
		 return "/chat/oneChat";
	 }
	 
	@RequestMapping(value="chatlog.do", method=RequestMethod.POST)
	@ResponseBody
	public int chatin(HttpServletRequest request, ChatLogVO lvo) {
		lvo.setMemId(memSer.getSession(request));
		int re = chatSer.insertchatlog(lvo);
		return re;
	}
	
	@RequestMapping(value="chatlogout.do", method=RequestMethod.POST)
	@ResponseBody
	public int chatout(HttpServletRequest request, ChatLogVO lvo) {
		lvo.setMemId(memSer.getSession(request));
		int re = chatSer.deletechatlog(lvo);
		return re;
	}
	
	 @RequestMapping(value="chatloguser.do", method=RequestMethod.POST)
	 @ResponseBody
	 public int chatloguser(HttpServletRequest request, ChatLogVO lvo) {
		lvo.setMemId(memSer.getSession(request));
		 int cnt = chatSer.findChatLog(lvo);
		 int read = 0;
		 if(cnt == 0) read = 1;
		 return read;
	 }
	 
	 
	 @RequestMapping(value="insertMsg.do", method=RequestMethod.POST)
	 @ResponseBody
	 public int insertMsg(HttpServletRequest request, MsgVO mvo) {
		 mvo.setMsgWriter(memSer.getSession(request));
		 int re = chatSer.insertMsg(mvo);
		 return re;
	 }
	 
	 @RequestMapping(value="deleteChat.do")
	 public String deleteChat(HttpServletRequest request, Integer chatId,Model model) {
			HttpSession session = request.getSession(false);
			if(session.getAttribute("sesId")==null) {
				return "redirect:main.do?alarm=badmem";
			}
		 chatSer.UpChatStatus(chatId, memSer.getSession(request));
		 return "redirect:chatlist.do";
	 }
	 
	 @RequestMapping(value="upPostStatus.do", method=RequestMethod.POST)
	 @ResponseBody
	 public void upPostStatus(HttpServletRequest request, Integer postId, String status, Integer chatId) throws SQLException {
		 
		 
		 chatSer.upPostStatus(postId, status);
		 
		 if(status.equals("거래완료")) {
			 PostVO pvo = postSer.getPostVO(postId);
			 int memId = memSer.getSession(request);
			 ChatVO cvo = chatSer.findChat(chatId);
			 int youId = cvo.getChatFrom();
			 BuyVO bvo = new BuyVO(0,youId,memId,pvo.getPostTitle(),pvo.getPostPrice(),pvo.getMainPipath(), 0);
			 String postdir = request.getSession().getServletContext().getRealPath("/resources/sang_img");
			 String buydir= request.getSession().getServletContext().getRealPath("/resources/buy_img");
			 chatSer.inBuy(postdir, buydir, bvo);
		 }
		 
		 
	 }
	 
	 @RequestMapping(value="backDelChat.do", method=RequestMethod.POST)
	 @ResponseBody
	 public void backDelChat(Integer chatId) {
		 chatSer.backDelChat(chatId);
	 }

}
