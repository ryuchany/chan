package com.kh.spring21.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.spring21.entity.ProductDto;

@Repository
public class ProductDaoImpl implements ProductDao{

	@Autowired
	private SqlSession sqlSession;

	@Override
	public void insert(ProductDto productDto) {
		sqlSession.insert("product.insert", productDto);
	}

	@Override
	public List<ProductDto> list() {
		return sqlSession.selectList("product.list");
	}

	@Override
	public ProductDto get(int no) {
		return sqlSession.selectOne("product.get", no);
	}

}