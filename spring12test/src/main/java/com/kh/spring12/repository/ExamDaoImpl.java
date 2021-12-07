package com.kh.spring12.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.spring12.entity.ExamDto;

@Repository
public class ExamDaoImpl implements ExamDao{

	@Autowired
	private SqlSession sqlSession;

	@Override
	public ExamDto get(int examId) {
		ExamDto examDto = sqlSession.selectOne("exam.get", examId);
		return examDto;
	}

	@Override
	public List<ExamDto> search(String column, String keyword) {
		Map<String, Object> param = new HashMap<>();
		param.put("column", column);
		param.put("keyword", keyword);

		List<ExamDto> list = sqlSession.selectList("exam.searchByColumnAndKeyword", param);
		return list;
	}
}
