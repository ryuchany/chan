package com.kh.spring09.entity;

import java.sql.Date;

import lombok.Data;

@Data
public class MemberDto {
	private String memberId;
	private String memberPw;
	private String memberNick;
	private String memberBirth;
	private String memberEmail;
	private String memberPhone;
	private String memberGrade;
	private Date memberJoin;
	private int memberPoint;
}
