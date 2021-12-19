package com.kh.spring22.websocket;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SockjsWebsocketServer extends TextWebSocketHandler{
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		log.debug("접속");
	}

	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		log.debug("종료");
	}
}