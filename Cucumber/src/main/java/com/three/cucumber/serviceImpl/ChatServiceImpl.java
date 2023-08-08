package com.three.cucumber.serviceImpl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.three.cucumber.service.ChatService;
import com.three.cucumber.service.dao.ChatDAO;
import com.three.cucumber.vo.BuyVO;
import com.three.cucumber.vo.ChatLogVO;
import com.three.cucumber.vo.ChatVO;
import com.three.cucumber.vo.MemberVO;
import com.three.cucumber.vo.MsgVO;
import com.three.cucumber.vo.PostVO;

@Service("chatService")
public class ChatServiceImpl implements ChatService{

	@Autowired
	private ChatDAO chatDAO;
	
	@Override
	public ArrayList<ChatVO> getAllChat(int memId) {
		ArrayList<ChatVO> carray = chatDAO.getAllChat(memId);
		for(int i=0; i<carray.size(); i++) {
			String msg = chatDAO.findLastMsg(carray.get(i).getChatId());
			if(msg != null) {
				if(msg.length()>10)
					msg = msg.substring(0, 10) +"...";
				carray.get(i).setChatContent(msg);
			}
		}		
		return carray;
	}

	@Override
	public HashMap<Integer, Integer> getAllMsgCount(int memId) {
		ArrayList<Integer> chatId = chatDAO.getAllChatId(memId);
		HashMap<Integer, Integer> h = new HashMap<Integer, Integer>();
		for(int i=0; i<chatId.size(); i++) {
			if(chatId.get(i) != null)
				h.put(chatId.get(i), chatDAO.getMsgCount(chatId.get(i), memId));
		}
		return h;
	}
	
	@Override
	public HashMap<Integer, String> getAllPost(int memId) {
		ArrayList<PostVO> parray = chatDAO.getAllPost(memId);
		HashMap<Integer, String> pmap = new HashMap<Integer, String>();
		for(int i=0; i<parray.size(); i++) {
			pmap.put(parray.get(i).getPostId(), parray.get(i).getMainPipath());
		}
		return pmap;
	}
	
	@Override
	public HashMap<Integer, MemberVO> getAllNick(int memId) {
		ArrayList<Integer> chatId = chatDAO.getAllChatId(memId);
		HashMap<Integer, MemberVO> n = new HashMap<Integer, MemberVO>();
		for(int i=0; i<chatId.size(); i++) {
			if(chatId.get(i) != null)
				n.put(chatId.get(i), chatDAO.findNick(chatId.get(i), memId));
		}		
		return n;
	}

	@Override
	public ArrayList<MsgVO> getAllMsg(int chatId, int memId) {
		// TODO Auto-generated method stub
		return chatDAO.getAllMsg(chatId, memId);
	}

	@Override
	public PostVO findPost(int chatId) {
		// TODO Auto-generated method stub
		return chatDAO.findPost(chatId);
	}

	@Override
	public MemberVO findNick(int chatId, int memId) {
		// TODO Auto-generated method stub
		return chatDAO.findNick(chatId, memId);
	}

	@Override
	public boolean updateMsgRead(int chatId, int memId) {
		int re = chatDAO.updateMsgRead(chatId, memId);
		if(re==1) return true;
		else return false; 
	}

	@Override
	public int insertchatlog(ChatLogVO lvo) {
		int re = 1;
		if(chatDAO.findChatLogMe(lvo) == 0)
			re = chatDAO.insertchatlog(lvo);
		return re;
	}

	@Override
	public int deletechatlog(ChatLogVO lvo) {
		// TODO Auto-generated method stub
		return chatDAO.deletechatlog(lvo);
	}

	@Override
	public int findChatLog(ChatLogVO clvo) {
		// TODO Auto-generated method stub
		return chatDAO.findChatLogYou(clvo);
	}

	@Override
	public int insertMsg(MsgVO mvo) {
		int re = chatDAO.insertMsg(mvo);
		chatDAO.upChatStatusBy0(mvo.getChatId());
		return re;
	}

	@Override
	public void UpChatStatus(int chatId, int memId) {
		int sta = chatDAO.getChatStatus(chatId);
		if(sta != 0) {
			chatDAO.delChat(chatId);
		}else {
			chatDAO.upChatStauts(chatId, memId);
			chatDAO.upMsgStauts(chatId, memId);
		}
		
	}

	public void upPostStatus(int postId, String status) {
		chatDAO.upPostStatus(postId, status);
	}

	@Override
	public int insertchat(int postId, int memId) {
		int chatId = 0;
		int postUser = chatDAO.findPostUser(postId);
		ChatVO cvo = chatDAO.findChat(postId, postUser, memId);
		if(cvo != null) {
			if(cvo.getStatus() ==0 || cvo.getStatus() != memId) 
				chatId = cvo.getChatId();
			else {
				chatDAO.upChatStatusBy0(cvo.getChatId());
				chatId = cvo.getChatId();
			}
		}
		else {			
			ChatVO icvo = new ChatVO(0,postId, postUser,memId,null,0);
			chatDAO.insertchat(icvo);
			chatId = chatDAO.findChatId(icvo);
		}
		return chatId;
	}

	@Override
	public void backDelChat(int chatId) {
		chatDAO.delChat(chatId);
		
	}

	@Override
	public void inBuy(String postdir, String buydir, BuyVO bvo) {
		File in = new File(postdir+"/"+ bvo.getPipath());
		File out = new File(buydir +"/" + bvo.getPipath());

		try {
			Files.copy(in.toPath(), out.toPath(), StandardCopyOption.REPLACE_EXISTING);
		} catch (Exception e) {
			e.printStackTrace();
		}
		chatDAO.inBuy(bvo);
		
	}

	@Override
	public ChatVO findChat(int chatId) {
		// TODO Auto-generated method stub
		return chatDAO.findChatById(chatId);
	}

}
