package com.kh.spring09.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.kh.spring09.entity.MemberDto;

@Repository
public class MemberDaoImpl implements MemberDao{


	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public void join(MemberDto memberDto) {
		String sql = "insert into member "
				+ "values(?, ?, ?, to_date(?, 'YYYY-MM-DD'), ?, ?, sysdate, 0, '준회원')";
		Object[] param = {
			memberDto.getMemberId(),//1
			memberDto.getMemberPw(),//2
			memberDto.getMemberNick(),//3
			memberDto.getMemberBirth(),//4
			memberDto.getMemberEmail(),//5
			memberDto.getMemberPhone()//6
		};
		jdbcTemplate.update(sql, param);
	}

}
