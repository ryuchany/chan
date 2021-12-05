package com.kh.spring09.repository;

import java.util.List;

import com.kh.spring09.entity.MemberDto;

public interface MemberDao {
	void join(MemberDto memberDto);
	List<MemberDto> list();
}
