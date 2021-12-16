package com.kh.spring21.repository;

import java.util.List;

import com.kh.spring21.entity.ExamDto;
import com.kh.spring21.vo.ChartVO;

public interface ExamDao {
	void insert(ExamDto examDto);

	List<ExamDto> list();
	List<ExamDto> search(String student);
	List<ExamDto> search(String column, String keyword);
	List<ExamDto> listByPage(int startRow, int endRow);
	
	ExamDto get(int examId);

	List<ChartVO> countBySubject();
	List<ChartVO> countByType();	
	
	boolean delete(int examId);
}