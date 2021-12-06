package com.kh.spring10.repository;


import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.spring10.entity.MemberDto;

//mybatis를 이용한 회원DB 처리
@Repository
public class MemberDaoMyBatis implements MemberDao{
	
	@Autowired 
	private SqlSession sqlSession;
	
	@Override
	public void join(MemberDto memberDto) {
		//mapper 중에서 member라는 namespace의 join이라는 구문을 찾고
		//memberDto를 전달시켜서 실행하라!
		sqlSession.insert("member.join", memberDto);
	}

	@Override
	public List<MemberDto> list() {
		//mapper 중에서 member라는 namespace의 list라는 구문을 찾고 실행해서 목록을 가져와라!
		return sqlSession.selectList("member.list");
//		return sqlSession.selectOne("member.list");
	}




	

}
