package com.kh.spring23.repository;

import java.util.List;

import com.kh.spring23.dto.BuyDto;

public interface BuyDao {
	int sequence();
	void insert(BuyDto buyDto);
	
	List<BuyDto> list();
	BuyDto get(int no);
	
	void refresh(int buyNo);
}