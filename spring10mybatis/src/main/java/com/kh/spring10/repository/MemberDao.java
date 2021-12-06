package com.kh.spring10.repository;

import java.util.List;

import com.kh.spring10.entity.MemberDto;

public interface MemberDao {
	void join(MemberDto memberDto);
	List<MemberDto> list();
}
