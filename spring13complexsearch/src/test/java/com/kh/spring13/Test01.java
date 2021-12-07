package com.kh.spring13;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.kh.spring13.entity.ProductDto;
import com.kh.spring13.vo.SortVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"file:src/main/webapp/WEB-INF/spring/root-context.xml", 
		"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"
})
@WebAppConfiguration
public class Test01 {
	
	@Autowired
	private SqlSession sqlSession;
	
//	@Test
	public void listTest() {
//		List<ProductDto> list = sqlSession.selectList("product.list");
//		List<ProductDto> list = sqlSession.selectList("product.complexSearch1");
		List<ProductDto> list = sqlSession.selectList("product.complexSearch4");
		System.out.println(list.size());
		for(ProductDto productDto : list) {
			System.out.println(productDto);
		}
	}
	
//	@Test
	public void findByNameTest() {
		String name = "메로나";
//		List<ProductDto> list = sqlSession.selectList("product.findByName", name);
		List<ProductDto> list = sqlSession.selectList("product.complexSearch1", name);
		System.out.println(list.size());
		for(ProductDto productDto : list) {
			System.out.println(productDto);
		}
	}

//	@Test
	public void findByNameAndTypeTest() {
		Map<String, Object> param = new HashMap<>();
		param.put("name", "메로나");
		param.put("type", "아이스크림");

//		List<ProductDto> list = sqlSession.selectList("product.complexSearch2", param);
//		List<ProductDto> list = sqlSession.selectList("product.complexSearch3", param);
		List<ProductDto> list = sqlSession.selectList("product.complexSearch4", param);
		System.out.println(list.size());
		for(ProductDto productDto : list) {
			System.out.println(productDto);
		}
	}

//	@Test
	public void perfectSearch() {
		Map<String, Object> param = new HashMap<>();
//		param.put("no", 1);
//		param.put("name", "메로나");
//		param.put("type", "아이스크림");
//		param.put("minPrice", 1000);
//		param.put("maxPrice", 5000);
//		param.put("madeStart", "2021-01-01");
//		param.put("madeFinish", "2021-12-31");
//		param.put("expireStart", "2021-01-01");
//		param.put("expireFinish", "2021-12-31");

		List<ProductDto> list = sqlSession.selectList("product.complexSearch4", param);
		System.out.println(list.size());
		for(ProductDto productDto : list) {
			System.out.println(productDto);
		}
	}

//	@Test
	public void orderTest() {
		Map<String, Object> param = new HashMap<>();
//		param.put("order", "no");
//		param.put("sort", "desc");

		List<ProductDto> list = sqlSession.selectList("product.complexSearch5", param);
		System.out.println(list.size());
		for(ProductDto productDto : list) {
			System.out.println(productDto);
		}
	}

	//@Test
	public void multipleOrderTest() {
		List<SortVO> orders = new ArrayList<>();
		orders.add(new SortVO("price", "desc"));
		orders.add(new SortVO("made", "asc"));
		orders.add(new SortVO("no", "asc"));

		Map<String, Object> param = new HashMap<>();
		param.put("orders", orders);

		List<ProductDto> list = sqlSession.selectList("product.complexSearch6", param);
		System.out.println(list.size());
		for(ProductDto productDto : list) {
			System.out.println(productDto);
		}
	}

	//@Test
	public void legacySearch() {
		String column = "name";
		String keyword = "메로나";

		Map<String, Object> param = new HashMap<>();
		param.put(column, keyword);
		List<ProductDto> list = sqlSession.selectList("product.perfectSearch", param);
		System.out.println(list.size());
		for(ProductDto productDto : list) {
			System.out.println(productDto);
		}
	}	
	
	@Test
	public void allInOne() {
		Map<String, Object> param = new HashMap<>();
//		param.put("no", 1);
//		param.put("name", "메로나");
//		param.put("type", "아이스크림");
//		param.put("minPrice", 2500);
//		param.put("maxPrice", 10000);
//		param.put("madeStart", "2021-01-01");
//		param.put("madeFinish", "2021-12-31");
//		param.put("expireStart", "2021-01-01");
//		param.put("expireFinish", "2021-12-31");

		List<SortVO> orders = new ArrayList<>();
//		orders.add(new SortVO("price", "desc"));
//		orders.add(new SortVO("made", "asc"));
//		orders.add(new SortVO("no", "asc"));
		param.put("orders", orders);

		List<ProductDto> list = sqlSession.selectList("product.perfectSearch", param);
		System.out.println(list.size());
		for(ProductDto productDto : list) {
			System.out.println(productDto);
		}
	}	
	
}