package com.kh.spring08.repository;

import org.springframework.stereotype.Repository;

import com.kh.spring08.entity.StudentDto;

@Repository
public class StudentDaoImpl2 implements StudentDao{

	@Override
	public void insert(StudentDto studentDto) throws Exception {
		System.out.println("StudentDaoImpl2");
	}

}
