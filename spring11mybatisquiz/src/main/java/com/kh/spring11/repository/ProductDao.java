package com.kh.spring11.repository;

import java.util.List;

import com.kh.spring11.entity.ProductDto;

public interface ProductDao {
	/*public*/void insert(ProductDto productDto);
	List<ProductDto> list();
	ProductDto get(int no);
}