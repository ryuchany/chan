package com.kh.spring23.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.spring23.dto.BuyDto;

@Repository
public class BuyDaoImpl implements BuyDao{

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public int sequence() {
		return sqlSession.selectOne("buy.sequence");
	}
	
	@Override
	public void insert(BuyDto buyDto) {
		sqlSession.insert("buy.insert", buyDto);
	}

	@Override
	public List<BuyDto> list() {
		return sqlSession.selectList("buy.list");
	}
	
	@Override
	public BuyDto get(int no) {
		return sqlSession.selectOne("buy.get", no);
	}
	
	@Override
	public void refresh(int buyNo) {
		sqlSession.update("buy.refresh", buyNo);
	}
	
}