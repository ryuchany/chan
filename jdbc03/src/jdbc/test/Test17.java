package jdbc.test;

import java.util.List;

import jdbc.beans.ProductDao;
import jdbc.beans.ProductDto;

public class Test17 {
	public static void main(String[] args) throws Exception {

		String column = "price";
		String keyword = "1500";

		ProductDao productDao = new ProductDao();
		List<ProductDto> list = productDao.select(column, keyword);

		System.out.println("개수 : " + list.size());
		for (ProductDto productDto : list) {
			System.out.print(productDto.getNo());
			System.out.print(" / ");
			System.out.print(productDto.getName());
			System.out.print(" / ");
			System.out.print(productDto.getType());
			System.out.print(" / ");
			System.out.print(productDto.getPrice());
			System.out.print(" / ");
			System.out.print(productDto.getMadeDate());
			System.out.print(" / ");
			System.out.print(productDto.getExpireDate());
			System.out.println();
		}
	}
}
