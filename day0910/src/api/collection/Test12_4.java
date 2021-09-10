package api.collection;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test12_4 {
	public static void main(String[] args) {
	
		//5명의 아티스트들을 리스트에 등록한 뒤 출력하는 프로그램
		List<Product> list = new ArrayList<>();

		//추가
		list.add(new Product("아카시아", "껌",500,40));
		list.add(new Product("전주비빔", "삼각김밥",1200,5));
		list.add(new Product("제육도시락", "도시락",4000,3));
		list.add(new Product("육개장큰사발", "라면",1500,25));
		list.add(new Product("판타롱스타킹", "양말",1000,20));
		

		Scanner sc = new Scanner(System.in);

		while(true) {
			System.out.print("상품명을 입력하세요 : ");
			String name = sc.nextLine();
		}
		
	
	}
}
