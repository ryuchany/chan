package com.kh.spring23.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	
	@Override
	public List<BuyDetailDto> list(int buyNo) {
		return sqlSession.selectList("buyDetail.list", buyNo);
	}

	@Override
	public BuyDetailDto get(int buyNo, int productNo) {
		Map<String, Object> param = new HashMap<>();
		param.put("buyNo", buyNo);
		param.put("productNo", productNo);
		return sqlSession.selectOne("buyDetail.get", param);
	}

	@Override
	public void cancel(int buyNo, int productNo) {
		Map<String, Object> param = new HashMap<>();
		param.put("buyNo", buyNo);
		param.put("productNo", productNo);
		sqlSession.update("buyDetail.cancel", param);
	}

	@Override
	public long getCancelAvailableAmount(int buyNo) {
		return sqlSession.selectOne("buyDetail.cancelAvailableAmount", buyNo);
	}

	@Override
	public void cancelAll(int buyNo) {
		sqlSession.update("buyDetail.cancelAll", buyNo);
	}
	
}