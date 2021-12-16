package com.kh.spring21.repository;

import java.util.List;

import com.kh.spring21.entity.ProductDto;

public interface ProductDao {
	void insert(ProductDto productDto);
	List<ProductDto> list();
	ProductDto get(int no);
}