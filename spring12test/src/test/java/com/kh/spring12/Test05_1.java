package com.kh.spring12;

import static org.junit.Assert.assertNotEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.kh.spring12.entity.ExamDto;
import com.kh.spring12.repository.ExamDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"file:src/main/webapp/WEB-INF/spring/root-context.xml", 
		"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"
})
@WebAppConfiguration
public class Test05_1 {

	@Autowired
	private ExamDao examDao;

	@Test
	public void examDaoSearchTest() {
		String column = "type", keyword = "서술형";

		List<ExamDto> list = examDao.search(column, keyword);
		System.out.println(list.size());

		assertNotEquals(0, list.size());
	}

}
