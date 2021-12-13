package com.kh.spring17.vo;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

//회원 등록 정보를 수신하기 위한 VO
@Data
public class MemberUploadVO {
	private String memberId;
	private String memberPw;
	private List<MultipartFile> attach;
}