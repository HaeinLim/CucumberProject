package com.three.cucumber.service;

import java.util.ArrayList;
import java.util.HashMap;

import com.three.cucumber.vo.BuyVO;
import com.three.cucumber.vo.ChatLogVO;
import com.three.cucumber.vo.ChatReportVO;
import com.three.cucumber.vo.ChatVO;
import com.three.cucumber.vo.MemberVO;
import com.three.cucumber.vo.MsgVO;
import com.three.cucumber.vo.PostVO;

public interface ChatService {

	ArrayList<ChatVO> getAllChat(int memId);

	HashMap<Integer, Integer> getAllMsgCount(int memId);
	
	HashMap<Integer, String> getAllPost(int memId);

	ArrayList<MsgVO> getAllMsg(int chatId, int memId);

	PostVO findPost(int chatId);

	HashMap<Integer, MemberVO> getAllNick(int memId);

	MemberVO findNick(int chatId, int session);

	boolean updateMsgRead(int chatId, int memId);

	int insertchatlog(ChatLogVO lvo);

	int deletechatlog(ChatLogVO lvo);

	int findChatLog(ChatLogVO clvo);
	

	int insertMsg(MsgVO mvo);

	void UpChatStatus(int chatId, int session);

	void upPostStatus(int postId, String status);

	int insertchat(int postId, int session);

	void backDelChat(int chatId);

	void inBuy(String postdir, String buydir, BuyVO bvo);

	ChatVO findChat(int chatId);





}
