package jdbc.test;

import jdbc.beans.ProductDao;
import jdbc.beans.ProductDto;

public class Test20 {
	public static void main(String[] args) throws Exception {

		int no = 150;

		ProductDao productDao = new ProductDao();
		ProductDto productDto = productDao.get(no);

		if(productDto == null) {
			System.out.println("없음");
		}
		else {
			System.out.println(productDto);
		}

	}
}
