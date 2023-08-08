package com.three.cucumber.controller;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.three.cucumber.service.ChatService;
import com.three.cucumber.service.MemberService;
import com.three.cucumber.service.ReportService;
import com.three.cucumber.vo.ChatLogVO;
import com.three.cucumber.vo.ChatReportVO;
import com.three.cucumber.vo.MemberVO;

@Controller
public class ReportController {

	@Resource(name="chatService")
	private ChatService chatSer;
	
	@Resource(name="reportService")
	private ReportService repSer;
	
	@Resource(name="memberService")
	private MemberService memSer;
	
	 @RequestMapping(value="chatReport.do", method=RequestMethod.POST)
	 public String revReport(HttpServletRequest request, Integer memId, Integer chatId, Model model) {
			HttpSession session = request.getSession(false);
			if(session.getAttribute("sesId")==null) {
				return "redirect:main.do?alarm=badmem";
			}
		 MemberVO mvo = chatSer.findNick(chatId, memId);
		 model.addAttribute("chatId", chatId);
		 model.addAttribute("mvo", mvo);
		 return "/report/chatReport";
	 }
	 
	@RequestMapping(value="insertChatRep.do", method= RequestMethod.POST)
	public String insertChatRep(ChatReportVO crvo,Model model, Integer chatId,
				@RequestParam("upload")MultipartFile[] upload, HttpServletRequest request) throws SQLException, IllegalStateException, IOException {
		HttpSession session = request.getSession(false);
		if(session.getAttribute("sesId")==null) {
			return "redirect:main.do?alarm=badmem";
		}
		crvo.setChatReporter(memSer.getSession(request));
		
		String saveDir = request.getSession().getServletContext().getRealPath("/resources/chat_report");
	    File dir = new File(saveDir);
	    if(!dir.exists()) {
	    	dir.mkdirs();
	    }
	    for(MultipartFile f : upload) {
	    	if(!f.isEmpty()) {
	    		String orifileName = f.getOriginalFilename();
	    		String ext = orifileName.substring(orifileName.lastIndexOf("."));
	    		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd-HHmmssSSS");
	    		int rand = (int)(Math.random()*1000);
	    		String reName = sdf.format(System.currentTimeMillis()) + "_" + rand + ext;
	    		crvo.setChatReportPipath(reName);
	    		try { f.transferTo(new File(saveDir + "/" + reName));
	            }catch (IOException e) { e.printStackTrace(); }
	    	}            
	    }
	    
	    repSer.insertChatRep(crvo);
	    return "redirect:findChat.do?chatId="+chatId;			
	}
	
	@RequestMapping(value = "repMem.do")
	public String repMem(Integer memId) {
		repSer.updateMemRep(memId);
		return "redirect:youpage.do?memId="+memId;
	}

}
