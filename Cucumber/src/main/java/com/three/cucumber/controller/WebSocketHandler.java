package com.three.cucumber.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@Controller
public class WebSocketHandler extends TextWebSocketHandler{
 
	List<WebSocketSession> seslist;
	Map<Integer, Object> usermap;
	ArrayList<Integer> userlist;
	Map<Integer, ArrayList<Integer>> roommap;
	
	public WebSocketHandler() {
		seslist = new ArrayList<WebSocketSession>();
		usermap = new HashMap<Integer, Object>();
		userlist = new ArrayList<Integer>();
		roommap = new HashMap<Integer, ArrayList<Integer>>();
	}

    /**
     * websocket 연결 성공 시
     */
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
    	seslist.add(session);
    }
    
    /**
     * websocket 메세지 수신 및 송신
     */
    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
    	JSONObject ob = new JSONObject(message.getPayload());
    	String type = ob.getString("type");
    	if(type !=null && type.equals("register")) {
    		System.out.println("register");
    		int chatId = ob.getInt("chatId");
    		int memId = ob.getInt("memId");
    		usermap.put(memId, session);
    		userlist.add(memId);
    		if(roommap.get(chatId) == null)
    			roommap.put(chatId, userlist);
    		else roommap.get(chatId).add(memId);
    	}
    	else {
    		System.out.println("msg");
    		int chatId = ob.getInt("chatId");
    		int memId = ob.getInt("memId");
    		int toId = 0;
    		System.out.println(roommap.get(chatId).get(0));
    		if(roommap.get(chatId).get(0) != memId) {
    			toId = roommap.get(chatId).get(0);
    		}
    		else toId = roommap.get(chatId).get(1);
    		System.out.println("toId" + toId);
    		WebSocketSession ws = (WebSocketSession) usermap.get(toId);
    		String msg = ob.getString("content");
    		if(ws != null) {
    			System.out.println("전달");
    			ws.sendMessage(new TextMessage(msg)); 
    		}
    	}
    }
 
    /**
     * websocket 연결 종료 시
     */
    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
    	seslist.remove(session);
    }
    
}

