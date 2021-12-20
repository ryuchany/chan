package com.kh.spring23.repository;

import java.util.List;

import com.kh.spring23.dto.ProductDto;

public interface ProductDao {
	List<ProductDto> list();
	List<ProductDto> search(List<Integer> no);
}