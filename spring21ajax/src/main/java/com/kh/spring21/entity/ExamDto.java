package com.kh.spring21.entity;

import lombok.Data;

@Data
public class ExamDto {
	private int examId;
	private String student;
	private String subject;
	private String type;
	private int score;
}