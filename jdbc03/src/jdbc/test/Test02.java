package jdbc.test;

import jdbc.beans.ProductDao;

public class Test02 {
	public static void main(String[] args) throws Exception {

		int no = 21;
		String name = "꽈배기";
		String type = "과자";
		int price = 500;
		String made = "2021-10-06";
		String expire = "2022-10-06";

		// 1. 모듈 객체 생성
		ProductDao productDao = new ProductDao();

		// 2. 등록 메소드 호출
		productDao.insert(no, name, type, price, made, expire);
		System.out.println("끝!");
	}
}
