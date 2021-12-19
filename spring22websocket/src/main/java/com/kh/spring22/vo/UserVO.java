package com.kh.spring22.vo;
import org.springframework.web.socket.WebSocketSession;
import lombok.Data;
import lombok.EqualsAndHashCode;
@Data
//@EqualsAndHashCode(of = {"userId", "session"})
public class UserVO {
	private String userId;
	private WebSocketSession session;

	public boolean isMember() {
		return userId != null;
	}
	public boolean isGuest() {
		return userId == null;
	}
}