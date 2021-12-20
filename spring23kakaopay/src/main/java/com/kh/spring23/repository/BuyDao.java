package com.kh.spring23.repository;

import com.kh.spring23.dto.BuyDto;

public interface BuyDao {
	int sequence();
	void insert(BuyDto buyDto);
}
