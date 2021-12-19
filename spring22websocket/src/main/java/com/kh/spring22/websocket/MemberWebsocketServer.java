package com.kh.spring22.websocket;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kh.spring22.vo.ChannelVO;
import com.kh.spring22.vo.MessageVO;
import com.kh.spring22.vo.UserVO;

import lombok.extern.slf4j.Slf4j;
@Slf4j
public class MemberWebsocketServer extends TextWebSocketHandler{

	private ChannelVO channel = new ChannelVO("과정평가형");

	@Autowired
	private ObjectMapper mapper;

	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		String userId = (String) session.getAttributes().get("userId");

		UserVO user = new UserVO();
		user.setUserId(userId);
		user.setSession(session);

		channel.enter(user);
	}

	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		String userId = (String) session.getAttributes().get("userId");

		UserVO user = new UserVO();
		user.setUserId(userId);
		user.setSession(session);

		channel.leave(user);
	}

	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		String userId = (String) session.getAttributes().get("userId");
		if(userId == null) return;		

		//메세지 수신
		MessageVO vo = mapper.readValue(message.getPayload(), MessageVO.class);
		vo.setNickname(userId);
		
		//java 1.8부터 등장한 java.time 패키지의 코드를 이용하여 시간 정보 생성
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("a h:mm");
		vo.setTime(formatter.format(now));
		
		//메세지 생성
		TextMessage newMessage = new TextMessage(mapper.writeValueAsString(vo));

		//전체 발송(broadcast)
		channel.broadcast(newMessage);
	}

}