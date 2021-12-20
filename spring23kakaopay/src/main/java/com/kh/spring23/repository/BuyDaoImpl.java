package com.kh.spring23.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.spring23.dto.BuyDto;

@Repository
public class BuyDaoImpl implements BuyDao {

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public int sequence() {
		return sqlSession.selectOne("buy.sequence");
	}

	@Override
	public void insert(BuyDto buyDto) {
		sqlSession.insert("buy,insert", buyDto);
	}

}
