package com.kh.spring12;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.kh.spring12.entity.MemberDto;
import com.kh.spring12.repository.MemberDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"file:src/main/webapp/WEB-INF/spring/root-context.xml", 
		"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"
})
@WebAppConfiguration
public class Test06_1 {

	@Autowired
	private MemberDao memberDao;

	@Test
	public void loginTest() {
		MemberDto memberDto = new MemberDto();
		memberDto.setMemberId("khmaster");
		memberDto.setMemberPw("khmaster");

		boolean isLogin = memberDao.login(memberDto);
		//assertEquals(true, isLogin);
		assertTrue(isLogin);
	}

}
