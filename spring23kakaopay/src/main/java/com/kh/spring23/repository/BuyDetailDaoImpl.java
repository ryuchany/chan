package com.kh.spring23.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.spring23.dto.BuyDetailDto;

@Repository
public class BuyDetailDaoImpl implements BuyDetailDao{

	@Autowired
	private SqlSession sqlSession;

	@Override
	public void insert(BuyDetailDto buyDetailDto) {
		sqlSession.insert("buyDetail.insert", buyDetailDto);
	}

}