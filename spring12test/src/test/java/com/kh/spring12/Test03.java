package com.kh.spring12;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.kh.spring12.entity.ExamDto;

//테스트 목표 : exam-mapper.xml를 이용한 마이바티스 작업이 정상적으로 이루어지는지 확인
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"file:src/main/webapp/WEB-INF/spring/root-context.xml", 
		"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"
})
@WebAppConfiguration
public class Test03 {

	@Autowired
	private SqlSession sqlSession;

	@Test
	public void examListTest() {
		List<ExamDto> list = sqlSession.selectList("exam.list");
		//System.out.println(list.size());

		//단순하게 실행이 되는 것만 확인하는 것이 아니라 특정 "상태"를 원한다면...?
		//(ex) mybatis를 이용하여 exam-mapper의 list 구문을 조회하면 리스트가 반환된다
		// --> 단정문(단정 구문)을 이용하여 성공에 관련된 상태를 명시
		assertNotNull(list);
	}

}