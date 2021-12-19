package com.kh.spring22.vo;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import org.springframework.web.socket.TextMessage;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.extern.slf4j.Slf4j;
//1개의 채널 클래스
@Data
@EqualsAndHashCode(of="name")//이름이 같으면 같은(equals) 채널로 판정
@Slf4j
public class ChannelVO {
	private String name;
	private Set<UserVO> users = new CopyOnWriteArraySet<>();
	
	public ChannelVO(String name) {
		this.setName(name);
	}
	
	//입장
	public void enter(UserVO user) {
		users.add(user);
		log.debug("[{}채널] {} 입장", this.name, user.getUserId());
	}
	
	//퇴장
	public void leave(UserVO user) {
		users.remove(user);
		log.debug("[{}채널] {} 퇴장", this.name, user.getUserId());
	}
	
	//전체 메세지발송
	public void broadcast(TextMessage message) throws IOException {
		for(UserVO user : users) {
			user.getSession().sendMessage(message);
		}
		log.debug("[{}채널] 메세지 발송 완료!", this.name);
	}
	
	//회원만 메세지발송
	public void broadcastMember(TextMessage message) throws IOException {
		for(UserVO user : users) {
			if(user.isMember()) {
				user.getSession().sendMessage(message);
			}
		}
		log.debug("[{}채널] 회원에게 메세지 발송 완료!", this.name);
	}
	
	//비회원만 메세지발송
	public void broadcastGuest(TextMessage message) throws IOException {
		for(UserVO user : users) {
			if(user.isGuest()) {
				user.getSession().sendMessage(message);
			}
		}
		log.debug("[{}채널] 비회원에게 메세지 발송 완료!", this.name);
	}
	
	//특정 사용자에게만 메세지발송
	public void broadcastTarget(UserVO target, TextMessage message) throws IOException {
		for(UserVO user : users) {
			if(user.equals(target)) {
				user.getSession().sendMessage(message);
				break;
			}
		}
		log.debug("[{}채널] {} 회원에게 개인 메세지 발송 완료!", this.name, target.getUserId());
	}
	
	//사용자 숫자 반환
	public int count() {
		return this.users.size();
	}

	//사용자 탐색기능
	public boolean contains(UserVO user) {
		return this.users.contains(user);
	}

}