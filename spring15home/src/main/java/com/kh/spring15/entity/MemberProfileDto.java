package com.kh.spring15.entity;

import lombok.Data;

@Data
public class MemberProfileDto {
	private int memberProfileNo;
	private String memberId;
	private String memberProfileUploadname;
	private String memberProfileSavename;
	private long memberProfileSize;
	private String memberProfileType;
}
