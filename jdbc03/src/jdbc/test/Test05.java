package jdbc.test;

import jdbc.beans.ProductDao;
import jdbc.beans.ProductDto;

public class Test05 {
	public static void main(String[] args) throws Exception {

		// ProductDto

		// 입력
		ProductDto productDto = new ProductDto();
		productDto.setNo(10);
		productDto.setName("초코송이");
		productDto.setType("과자");
		productDto.setPrice(1500);
		productDto.setMade("2010-10-10");
		productDto.setExpire("2011-10-10");

		// 처리
		ProductDao productDao = new ProductDao();
		boolean isSuccess = productDao.update(productDto);

		// 출력
		if (isSuccess) {
			System.out.println("변경이 완료되었습니다");
		} else {
			System.out.println("해당 번호의 정보가 없습니다");
		}

	}
}
