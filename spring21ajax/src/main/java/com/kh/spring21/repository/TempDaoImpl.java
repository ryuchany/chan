package com.kh.spring21.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.spring21.entity.TempDto;

@Repository
public class TempDaoImpl implements TempDao{

	@Autowired
	private SqlSession sqlSession;

	@Override
	public int save(TempDto tempDto) {
		int no = sqlSession.selectOne("temp.sequence");
		tempDto.setNo(no);
		sqlSession.insert("temp.insert", tempDto);
		return no;
	}

	@Override
	public TempDto get(int no) {
		return sqlSession.selectOne("temp.get", no);
	}

}