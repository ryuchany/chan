package com.kh.spring22.websocket;

import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ManageWebsocketServer extends TextWebSocketHandler{

	//Q : 사용자의 정보를 관리하기 위해서 필요한 데이터의 형태는?
	//Set<WebSocketSession> users = new HashSet<>();//동기화가 지원되지 않는 형태
	Set<WebSocketSession> users = new CopyOnWriteArraySet<>();//동기화가 지원되는 형태

	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		users.add(session);
		log.debug("접속! 현재 사용자 {}명", users.size());
	}

	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		users.remove(session);
		log.debug("종료! 현재 사용자 {}명", users.size());
	}

}