package com.three.cucumber.controller;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.MultipartRequest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.three.cucumber.service.MemberService;
import com.three.cucumber.service.PostService;
import com.three.cucumber.serviceImpl.MailSendService;
import com.three.cucumber.serviceImpl.SmsService;
import com.three.cucumber.vo.CateVO;
import com.three.cucumber.vo.MemberVO;
import com.three.cucumber.vo.PhoneResSMSVO;
import com.three.cucumber.vo.PostVO;

@Controller
public class PostController {

	@Resource(name = "memberService")
	private MemberService memSer;
	
	@Resource(name="smsService")
	private SmsService smsSer;

	@Resource(name = "PostService")
	private PostService postSer;

	
	
	
	
	
	
	@RequestMapping(value = "goNewPost.do")
	public String goNewPost(Model model,HttpServletRequest request) throws Exception {
		ArrayList<CateVO> carray = postSer.getAllCate();
		model.addAttribute("carrary", carray);
		
	    // �궗�슜�옄 �땳�꽕�엫 蹂대궡湲�
		HttpSession session = request.getSession();
	    int sesId = memSer.getSession(request);
	    String nick = postSer.getMemNickPost(sesId);
		model.addAttribute("nick",nick); 
	    
		return "/post/newPost";
	}

	
	  @RequestMapping(value="insertPost.do") 
	  public String insertPost(@ModelAttribute("PostVO") PostVO postvo,Model model,
	  MultipartHttpServletRequest upload ) throws SQLException, IllegalStateException, IOException {
	  
	  
	  List<MultipartFile> fileList = upload.getFiles("upload"); 
	  
	  //�뙆�씪�씠 �뾽濡쒕뱶 �맆 寃쎈줈 �꽕�젙
      String saveDir = upload.getSession().getServletContext().getRealPath("/resources/sang_img");
      System.out.println(saveDir);
     //C:\spring\workspace\.metadata\.plugins\org.eclipse.wst.server.core\tmp1\wtpwebapps\Cucumber\resources\sang_img
      	// �떎�젣 �뱾�뼱媛��엳�뒗 �뙆�씪寃쎈줈
      
      //�쐞�뿉�꽌 �꽕�젙�븳 寃쎈줈�쓽 �뤃�뜑媛� �뾾�쓣 寃쎌슦 �깮�꽦
      File dir = new File(saveDir);
      if(!dir.exists()) {
          dir.mkdirs();
      }
      
      String pipathAll = "";
      String mainPipath = "";
      String pipath2 = "";
      String pipath3 = "";
      
      // �뙆�씪 �뾽濡쒕뱶
      for(MultipartFile f : fileList) {
          if(!f.isEmpty()) {
              // 湲곗〈 �뙆�씪 �씠由꾩쓣 諛쏄퀬 �솗�옣�옄 ���옣
              String orifileName = f.getOriginalFilename();
              String ext = orifileName.substring(orifileName.lastIndexOf("."));
              
              // �씠由� 媛� 蹂�寃쎌쓣 �쐞�븳 �꽕�젙
              SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd-HHmmssSSS");
              int rand = (int)(Math.random()*1000);

              // �뙆�씪 �씠由� 蹂�寃�
              String reName = sdf.format(System.currentTimeMillis()) + "_" + rand + ext;
              pipathAll += reName+"/";
              // �뙆�씪 ���옣
              try {
                  f.transferTo(new File(saveDir + "/" + reName));
              }catch (IOException e) {
                  e.printStackTrace();
              }
          }
          
      }	
      
      
      	// pipath �굹�늻湲�
      
		System.out.println(pipathAll);
		String pipathSplit[] = pipathAll.split("/");

		mainPipath = pipathSplit[0];
		pipath2 = pipathSplit[1];
		pipath3 = pipathSplit[2];
		
		postvo.setMainPipath(mainPipath);
		postvo.setPipath2(pipath2);
		postvo.setPipath3(pipath3);
		
		
		// �꽭�뀡�뿉�꽌 memid 媛��졇�삤湲�
		//HttpSession session = upload.getSession();
		int memId = memSer.getSession(upload);
		postvo.setMemId(memId);
		

		postSer.insertPost(postvo);
		return "redirect:myPost.do";
	  
	  }
	  
	  
	  @RequestMapping(value = "goUpdatePost.do")
		public String goUpdatePost(Model model,HttpServletRequest request,String postId) throws Exception {
			
		    PostVO postvo = postSer.getPostVO(Integer.parseInt(postId));
		    model.addAttribute("postvo",postvo);
		    System.out.println(postvo.getPostTitle());
		    System.out.println(postvo.getPostId());
		    
		    ArrayList<CateVO> carray = postSer.getAllCate();
			model.addAttribute("carrary", carray);
			
			

			HttpSession session = request.getSession();
		    int sesId = memSer.getSession(request);
		    String nick = postSer.getMemNickPost(sesId);
			model.addAttribute("nick",nick);
		    
			return "/post/updatePost";
		}
	 
	
	  @RequestMapping(value="updatePost.do", method=RequestMethod.POST) 
	  public String updatePost(@ModelAttribute("PostVO") PostVO postvo, Model model,
			  MultipartHttpServletRequest upload) throws SQLException, IllegalStateException, IOException {
	  System.out.println("up");
	  
	  
	  String mainPipath = upload.getParameter("img1");
	  String pipath2 = upload.getParameter("img2");
	  String pipath3 = upload.getParameter("img3");
	  String pipathAll = "";
	  

	  List<MultipartFile> fileList = upload.getFiles("upload"); 
	
      String saveDir = upload.getSession().getServletContext().getRealPath("/resources/sang_img");
      System.out.println(saveDir);
      
      
      for(MultipartFile f : fileList) {
    	  if(!f.isEmpty()) {
	    	  System.out.println("있어");
	    	  System.out.println(f);
	          String orifileName = f.getOriginalFilename();
	          String ext = orifileName.substring(orifileName.lastIndexOf("."));
	          System.out.println(ext);
	          
	          SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd-HHmmssSSS");
	          int rand = (int)(Math.random()*1000);
	          
	          
	          String reName = sdf.format(System.currentTimeMillis()) + "_" + rand + ext;
	          pipathAll += reName+"/";
	          
	          try {
	              f.transferTo(new File(saveDir + "/" + reName));
	          }catch (IOException e) {
	              e.printStackTrace();
	          }
    	  }
      }
      
		if(pipathAll != "") {
			System.out.println(pipathAll);
			String pipathSplit[] = pipathAll.split("/");
				mainPipath = pipathSplit[0];
				pipath2 = pipathSplit[1];
				pipath3 = pipathSplit[2];

				

	
	
		postvo.setMainPipath(mainPipath);
		postvo.setPipath2(pipath2);
		postvo.setPipath3(pipath3);
		}
		int memId = memSer.getSession(upload);
		
		
		postSer.updatePost(postvo);
	
		return "redirect:myPost.do";
	  
	}
	
	  
	  @RequestMapping(value = "deletePost.do", method = RequestMethod.POST)
	  @ResponseBody
		public int deletePost(Model model, int postId) throws Exception {
			int result = postSer.deletePost(postId);
			return result;
		}
	  
	
	
	
}

// https://memory-develo.tistory.com/148
// https://sinna94.tistory.com/entry/Spring-%ED%8C%8C%EC%9D%BC-%EC%97%85%EB%A1%9C%EB%93%9C-%ED%95%98%EA%B8%B0
