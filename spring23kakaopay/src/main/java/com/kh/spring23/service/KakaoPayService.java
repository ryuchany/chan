package com.kh.spring23.service;

import java.net.URISyntaxException;

import com.kh.spring23.vo.KakaoPayApproveRequestVO;
import com.kh.spring23.vo.KakaoPayApproveResponseVO;
import com.kh.spring23.vo.KakaoPayCancelResponseVO;
import com.kh.spring23.vo.KakaoPayReadyRequestVO;
import com.kh.spring23.vo.KakaoPayReadyResponseVO;
import com.kh.spring23.vo.KakaoPaySearchResponseVO;

public interface KakaoPayService {
	//결제 준비
	KakaoPayReadyResponseVO ready(KakaoPayReadyRequestVO requestVO) throws URISyntaxException;
	
	//결제 승인
	KakaoPayApproveResponseVO approve(KakaoPayApproveRequestVO requestVO) throws URISyntaxException;
	
	//결제 조회
	KakaoPaySearchResponseVO search(String tid) throws URISyntaxException;
	
	//결제 취소
	KakaoPayCancelResponseVO cancel(String tid, long amount) throws URISyntaxException;
}