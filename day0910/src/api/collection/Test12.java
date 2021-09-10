package api.collection;

import java.util.ArrayList;
import java.util.List;

public class Test12 {
	public static void main(String[] args) {
	
		
		List<Product> list = new ArrayList<>();

		//추가
		list.add(new Product("아카시아", "껌",500,40));
		list.add(new Product("전주비빔", "삼각김밥",1200,5));
		list.add(new Product("제육도시락", "도시락",4000,3));
		list.add(new Product("육개장큰사발", "라면",1500,25));
		list.add(new Product("판타롱스타킹", "양말",1000,20));
		
//		//출력
//		for(int i=0; i < list.size(); i++) {
//			Product pd = list.get(i);
//			System.out.println(pd);
//		}
		
		//검색
		String name = "아카시아";

		//1. 비어있는 리모컨을 준비
		Product find = null;
		
		
		//2. 반복문을 통해 리스트의 데이터를 직접 탐색하여 있으면 리모컨에 정보 설정
		for(int i=0; i < list.size(); i++) {
			Product pd = list.get(i);
			if(pd.getName().equals(name)) {//i번 위치의 Artist 이름이 name과 같다면
				find = pd;//find에 찾은 객체 정보를 전달하라
				break;//찾으면 그만(성능 향상)
			}
		}

		
		
	
		//결과
		if(find == null) {
			System.out.println("찾으시는 이름은 존재하지 않습니다");
		}
		else {
			System.out.println(name+" 에 대한 검색 결과");
			System.out.println(find);
			
		}
	}
}
