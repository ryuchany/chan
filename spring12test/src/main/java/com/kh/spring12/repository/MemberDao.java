package com.kh.spring12.repository;

import com.kh.spring12.entity.MemberDto;

public interface MemberDao {
	boolean login(MemberDto memberDto);
	MemberDto get(String memberId);
}
