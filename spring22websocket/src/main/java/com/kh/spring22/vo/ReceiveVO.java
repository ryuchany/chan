package com.kh.spring22.vo;

import lombok.Data;

//MultiChannelWebsocketServer에서 메세지를 수신하기 위한 객체
@Data
public class ReceiveVO {
	public static final int JOIN = 1;
	public static final int MESSAGE = 2;
	private int type;
	private String channel;
	private String content;
}