package com.kh.spring22.websocket;

import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import lombok.extern.slf4j.Slf4j;

//메세지를 중계하는 서버
//접속주소 - ws://host:port/context/messageServer
//사용자를 users라는 이름의 저장소로 관리하도록 구현

@Slf4j
public class MessageWebsocketServer extends TextWebSocketHandler{

	private Set<WebSocketSession> users = new CopyOnWriteArraySet<>();

	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		users.add(session);
		log.debug("접속 = {}명", users.size());
	}

	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		log.debug("메세지 수신");
		log.debug("session = {}", session);
		log.debug("message = {}", message);

		//해야할 일? 누군가에게 전달해야함
		//= 지금은 정보가 없이 글자만 오므로 모두에게 전송(broadcast)
		//= 전송 명령 : session.sendMessage(메세지 객체);
		for(WebSocketSession ws : users) {
			ws.sendMessage(message);//왔던 메세지를 그대로 전달
		}
	}

	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		users.remove(session);
		log.debug("종료 = {}명", users.size());
	}

}