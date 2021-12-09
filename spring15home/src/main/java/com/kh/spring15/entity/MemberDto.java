package com.kh.spring15.entity;

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
	private Date memberJoin;
	private int memberPoint;
	private String memberGrade;
	
	public String getMemberBirthDay() {
		return this.memberBirth.substring(0, 10);
	}
}
