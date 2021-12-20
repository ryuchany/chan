package com.kh.spring23.vo;

import lombok.Data;

@Data
public class KakaoPayReadyResponseVO {
	private String tid;
	private String next_redirect_pc_url;
	private String created_at;
}