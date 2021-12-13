package com.kh.spring15.service;

import java.io.IOException;

import com.kh.spring15.vo.MemberJoinVO;

public interface MemberService {
	void join(MemberJoinVO memberJoinVO) throws IllegalStateException, IOException;
}