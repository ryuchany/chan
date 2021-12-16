package com.kh.spring21.repository;

import com.kh.spring21.entity.TempDto;

public interface TempDao {
	int save(TempDto tempDto);
	TempDto get(int no);
}