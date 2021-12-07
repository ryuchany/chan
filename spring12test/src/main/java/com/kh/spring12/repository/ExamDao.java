package com.kh.spring12.repository;

import java.util.List;

import com.kh.spring12.entity.ExamDto;

public interface ExamDao {
	ExamDto get(int examId);
	List<ExamDto> search(String column, String keyword);
}
