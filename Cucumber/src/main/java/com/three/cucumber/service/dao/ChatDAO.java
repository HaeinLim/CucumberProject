package com.three.cucumber.service.dao;

import java.util.ArrayList;
import java.util.HashMap;

import com.three.cucumber.vo.BuyVO;
import com.three.cucumber.vo.ChatLogVO;
import com.three.cucumber.vo.ChatVO;
import com.three.cucumber.vo.MemberVO;
import com.three.cucumber.vo.MsgVO;
import com.three.cucumber.vo.PostVO;

public interface ChatDAO {

	ArrayList<ChatVO> getAllChat(int memId);

	ArrayList<Integer> getAllChatId(int memId);

	Integer getMsgCount(int chatId, int memId);

	ArrayList<PostVO> getAllPost(int memId);

	ArrayList<MsgVO> getAllMsg(int chatId, int memId);

	PostVO findPost(int chatId);

	MemberVO findNick(int chatId, int memId);

	int updateMsgRead(int chatId, int memId);

	String findLastMsg(Integer integer);

	int insertchatlog(ChatLogVO lvo);

	int deletechatlog(ChatLogVO lvo);

	int findChatLogMe(ChatLogVO clvo);
	
	int findChatLogYou(ChatLogVO clvo);

	int insertMsg(MsgVO mvo);

	void upChatStauts(int chatId, int memId);

	int getChatStatus(int chatId);

	void delChat(int chatId);

	void upMsgStauts(int chatId, int memId);

	void upPostStatus(int postId, String status);

	int findChatId(ChatVO cvo);

	void insertchat(ChatVO cvo);

	ChatVO findChat(int postId, int postUSer, int memId);

	int findPostUser(int postId);

	void upChatStatusBy0(int chatId);

	void inBuy(BuyVO bvo);

	ChatVO findChatById(int chatId);

}
