package jdbc.test;

import jdbc.beans.ExamDto;
import jdbc.beans.ProductDao;
import jdbc.beans.ProductDto;

public class Test02_1 {
	public static void main(String[] args) throws Exception {

		ProductDto productDto = new ProductDto();
		productDto.setNo(25);
		productDto.setName("메로나이슬");
		productDto.setType("주류");
		productDto.setPrice(2500);
		productDto.setMade("2020-10-06");
		productDto.setExpire("2022-10-06");

		ProductDao productDao = new ProductDao();
		productDao.insert(productDto);

		System.out.println("끝!");

	}
}
