package api.collection;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test12_7 {
	public static void main(String[] args) {

		List<Product> list = new ArrayList<>();

		// 추가
		list.add(new Product("아카시아", "껌", 500, 40));
		list.add(new Product("전주비빔", "삼각김밥", 1200, 5));
		list.add(new Product("제육도시락", "도시락", 4000, 3));
		list.add(new Product("육개장큰사발", "라면", 1500, 25));
		list.add(new Product("판타롱스타킹", "양말", 1000, 20));

		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.print("상품명을 입력하세요 : ");
			String name = sc.nextLine();

//			if(name == "그만") {//안됨
			if (name.equals("종료")) {
				System.out.println("프로그램을 종료합니다.");
				break;
			} else {
				Product find = null;

				for (int i = 0; i < list.size(); i++) {
					Product pd = list.get(i);
					if (pd.getName().equals(name)) {
						find = pd;
						break;
					}
				}
				if (find != null) {
					find.minus();
					System.out.println("[" + find.getName() + "]" + " 판매 완료되었습니다");

				}
//				else if( find != null && getInventory()){
//					System.out.println("["+find.getName()+"]" + " 재고가 부족하여 판매할 수 없습니다");
//				}
				else {
					System.out.println("입력하신 상품명 : " + name);
					System.out.println("존재하지 않는 상품입니다.");
				}
			}

		}
		sc.close();

		// 출력
		System.out.println("일 매출액 : " + "" + "원");
		System.out.println("상품 리스트");
		for (Product pd : list) {
			System.out.println("상품명 : " + pd.getName() + " , 상품분류 : " + pd.getGoods() + " , 판매가격 : " + pd.getPrice()
					+ "원" + " , 재고 : " + pd.getInventory() + "개");
		}

	}
}
