package com.kh.spring12.entity;

import lombok.Data;

@Data
public class ExamDto {
	private int examId;
	private String student;
	private String subject;
	private String type;
	private int score;
}
