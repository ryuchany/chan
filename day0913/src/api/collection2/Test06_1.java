package api.collection2;

import java.util.HashSet;
import java.util.Set;

public class Test06_1 {
	public static void main(String[] args) {

//		Car를 저장할 수 있는 저장소 생성
//		Set<Car> items = new TreeSet<>();
		Set<Car> items = new HashSet<>();

		items.add(new Car("소나타", "중형", 15000000));
		items.add(new Car("아반떼", "중형", 12000000));
		items.add(new Car("레이", "소형", 9000000));

//		검색
		String name = "소나타";

		Car find = null;
		for(Car c : items) {
//			if(c의 이름이 name과 같다면) {
			if(c.getName().equals(name)) {
				find = c;
				break;
			}
		}

		if(find == null) {
			System.out.println("찾으시는 차종이 없습니다");
		}
		else {
			System.out.println("["+find.getName()+"] 에 대한 검색 결과입니다");
			System.out.println(find);
		}
	}
}
