package api.collection;

import java.util.ArrayList;
import java.util.List;

public class Test12_1 {
	public static void main(String[] args) {
		//기본 클래스의 기능만으로 프로그램 구현

		//저장소 생성
		List<Product> productList = new ArrayList<>();

		//데이터 추가
		productList.add(new Product("아카시아", "껌", 500, 40));
		productList.add(new Product("전주비빔", "삼각김밥", 1200, 5));
		productList.add(new Product("제육도시락", "도시락", 4000, 3));
		productList.add(new Product("육개장큰사발", "라면", 1500, 25));
		productList.add(new Product("판타롱스타킹", "양말", 1000, 20));

		//데이터 출력
		System.out.println("<일일 정산>");
		System.out.println("일 매출액 : ?원");
		for(Product p : productList) {
			System.out.println(p);
		}

	}
}