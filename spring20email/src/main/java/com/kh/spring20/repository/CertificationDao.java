package com.kh.spring20.repository;

import com.kh.spring20.entity.CertificationDto;

public interface CertificationDao {
	void insert(CertificationDto certificationDto);
	boolean check(CertificationDto certificationDto);
	void clean();
}
