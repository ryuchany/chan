package jdbc.test;

import jdbc.beans.ProductDao;
import jdbc.beans.ProductDto;

public class Test06 {
	public static void main(String[] args) throws Exception {

		// 입력 : ProductDto
		ProductDto productDto = new ProductDto();
		productDto.setNo(10);
		productDto.setPrice(2000);

		// 처리
		ProductDao productDao = new ProductDao();
		boolean isSuccess = productDao.updatePrice(productDto);

		// 출력
		if (isSuccess) {
			System.out.println("변경이 완료되었습니다");
		} else {
			System.out.println("해당 번호의 정보가 없습니다");
		}
	}
}