package api.collection;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test12_9 {
	public static void main(String[] args) {
		//재고 감소

		//저장소 생성
		List<Product> productList = new ArrayList<>();

		//데이터 추가
		productList.add(new Product("아카시아", "껌", 500, 40));
		productList.add(new Product("전주비빔", "삼각김밥", 1200, 5));
		productList.add(new Product("제육도시락", "도시락", 4000, 3));
		productList.add(new Product("육개장큰사발", "라면", 1500, 25));
		productList.add(new Product("판타롱스타킹", "양말", 1000, 20));

		Scanner sc = new Scanner(System.in);

		while(true) {
			System.out.print("상품 이름 : ");
			String name = sc.nextLine();

			if(name.equals("종료")) {
				break;
			}

			Product temp = new Product(name);
			int index = productList.indexOf(temp);

			if(index >= 0) {//상품이 존재하는 경우
				Product find = productList.get(index);
				if(find.sell()) {//상품이 판매되었다면
					System.out.println("["+find.getName()+"] 판매 완료");
				}
				else {//판매되지 않았다면
					System.out.println("재고 부족");
				}
			}
			else {//상품이 존재하지 않는 경우
				System.out.println("해당 상품은 존재하지 않습니다");
			}
		}

		sc.close();

		//데이터 출력
		System.out.println("<일일 정산>");
		System.out.println("일 매출액 : ?원");
		for(Product p : productList) {
			System.out.println(p);
		}
	}
}
