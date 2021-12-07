package com.kh.spring12;

import static org.junit.Assert.assertNotNull;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.kh.spring12.entity.ExamDto;

//테스트 목표 : examId가 10인 항목의 조회 결과가 있을 것이라 가정하고 테스트 수행
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"file:src/main/webapp/WEB-INF/spring/root-context.xml", 
		"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"
})
@WebAppConfiguration
public class Test04 {

	@Autowired
	private SqlSession sqlSession;

	@Test
	public void examGetTest() {
		int examId = 10;
		ExamDto examDto = sqlSession.selectOne("exam.get", examId);
		System.out.println(examDto);
		assertNotNull(examDto);
	}

}
