package com.kh.spring22.websocket;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kh.spring22.vo.MessageVO;
import lombok.extern.slf4j.Slf4j;
@Slf4j
public class JsonWebsocketServer extends TextWebSocketHandler{
	
	private Set<WebSocketSession> users = new CopyOnWriteArraySet<>();
	
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		users.add(session);
		log.debug("접속 = {}명", users.size());
	}
	
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		users.remove(session);
		log.debug("종료 = {}명", users.size());
	}
	
	@Autowired
	private ObjectMapper mapper;
	
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		log.debug("수신 = {}", message.getPayload());
		
		//메세지를 분석하여 내용을 읽고 JSON 형태를 객체로 파싱(parsing)하는 작업이 필요하다
		//= Jackson 라이브러리에 있는 ObjectMapper 클래스를 사용하여 파싱

		//Map map = mapper.readValue(message.getPayload(), Map.class);
		MessageVO vo = mapper.readValue(message.getPayload(), MessageVO.class);//JSON String to 객체
		log.debug("vo = {}", vo);

		//서버에서 시간 정보를 계산하여 vo에 추가한 뒤 모두에게 전송(broadcast)
		Date d = new Date();
		Format f = new SimpleDateFormat("a h:mm");
		vo.setTime(f.format(d));

		String text = mapper.writeValueAsString(vo);//객체 to JSON String
		TextMessage newMessage = new TextMessage(text);

		for(WebSocketSession user : users) {
			user.sendMessage(newMessage);
		}
	}

}