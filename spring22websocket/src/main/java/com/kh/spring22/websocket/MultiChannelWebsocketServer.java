package com.kh.spring22.websocket;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kh.spring22.vo.ChannelVO;
import com.kh.spring22.vo.MessageVO;
import com.kh.spring22.vo.ReceiveVO;
import com.kh.spring22.vo.ServerVO;
import com.kh.spring22.vo.UserVO;

public class MultiChannelWebsocketServer extends TextWebSocketHandler{

	private ServerVO server = new ServerVO();

	@Autowired
	private ObjectMapper mapper;

	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		String userId = (String) session.getAttributes().get("userId");
		
		UserVO user = new UserVO();
		user.setUserId(userId);
		user.setSession(session);

		//server.enter(user, ?);//사용자는 입장 시 메세지를 보낼 수 없으므로 어느 채널에 들어갈지 알 수 없다.
		server.enterWaitingRoom(user);//대기실로 입장시키는 코드
	}

	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		String userId = (String) session.getAttributes().get("userId");
		
		UserVO user = new UserVO();
		user.setUserId(userId);
		user.setSession(session);
		
		//어느 채널에 있든 전체 채널에게 명령을 내리므로 퇴장 조치가 가능
		server.leave(user);
	}
	
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		//사용자가 어느 채널로 입장할 것인지를 메세지로 알려줘야 한다
		//= 사용자가 보내는 메세지가 2종류로 나눠진다
		//		1. 채널이 몇번인지 알려주는 입장용 메세지
		//		2. 일반 채팅 메세지
		//= 모두 처리할 수 있는 ReceiveVO 형태로 수신하여 처리
		String userId = (String)session.getAttributes().get("userId");
		UserVO user = new UserVO();
		user.setUserId(userId);
		user.setSession(session);

		ReceiveVO receive = mapper.readValue(message.getPayload(), ReceiveVO.class);

		if(receive.getType() == ReceiveVO.JOIN) {//[1] 입장 메세지
			//대기실에 있는 사용자가 채널로 들어갈 수 있도록 조치
			server.enter(user, receive.getChannel());
		}
		else if(receive.getType() == ReceiveVO.MESSAGE) {//[2] 채팅 메세지
			if(user.isGuest()) return;

			MessageVO vo = new MessageVO();
			vo.setNickname(userId);
			vo.setContent(receive.getContent());
			LocalDateTime now = LocalDateTime.now();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("a h:mm");
			vo.setTime(formatter.format(now));

			TextMessage newMessage = new TextMessage(mapper.writeValueAsString(vo));

			//서버에서 사용자가 존재하는 채널을 찾아서 해당 채널에 broadcast
			ChannelVO channel = server.find(user);
			if(channel != null) {
				channel.broadcast(newMessage);
			}
		}
	}

}