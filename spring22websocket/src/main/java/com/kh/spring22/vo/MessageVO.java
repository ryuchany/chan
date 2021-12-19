package com.kh.spring22.vo;

import lombok.Data;

//클라이언트에서 넘어오는 메세지 형식
@Data
public class MessageVO {
	//사용자가 보내는 정보
	private String content;
	
	//서버가 추가하는 정보
	private String nickname;
	private String time;
}