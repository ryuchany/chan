package jdbc.test;

import jdbc.beans.ProductDao;

public class Test10 {
	public static void main(String[] args) throws Exception {

		// 입력
		int no = 15;

		// 처리
		ProductDao productDao = new ProductDao();
		boolean success = productDao.delete(no);

		// 출력
		if (success) {
			System.out.println("상품 삭제 완료");
		} else {
			System.out.println("존재하지 않는 상품 입니다");
		}

	}
}
