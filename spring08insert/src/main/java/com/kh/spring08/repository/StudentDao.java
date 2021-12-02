package com.kh.spring08.repository;

import org.springframework.stereotype.Repository;

import com.kh.spring08.entity.StudentDto;

/**
 *	스프링의 세 번째 특징 : 추상화 구조
 *	= 교체가 쉽고 유지보수가 용이하도록 추상화 구조로 생성하는 것을 권장
 *	= 안하면 스프링에서 제공하는 기능들을 일부만 사용할 수 있음(ex : 프록시 기능 등 사용 불가)
 *	= 상위 클래스는 인터페이스로 구현하며, 기능의 형태만 구현(책으로 치면 목차)
 *	= 하위 클래스는 클래스로 구현하며, 실제 실행될 코드를 재정의하여 구현 (책으로 치면 본문)
 */
public interface StudentDao {
	/*public*/ void insert(StudentDto studentDto) throws Exception ;

}