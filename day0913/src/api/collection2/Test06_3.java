package api.collection2;

import java.util.HashSet;
import java.util.Set;

public class Test06_3 {
	public static void main(String[] args) {

//		제공되는 라이브러리 기능을 이용하려면 "비교기준"에 대한 정의가 필요하다
//		= equals , hashCode

//		Set<Car> items = new TreeSet<>();
		Set<Car> items = new HashSet<>();

		items.add(new Car("소나타", "중형", 15000000));
		items.add(new Car("소나타", "중형", 15000000));//?
		items.add(new Car("소나타", "중형", 15000000));//?
		items.add(new Car("아반떼", "중형", 12000000));
		items.add(new Car("레이", "소형", 9000000));

//		출력
		String name = "소나타";
		Car temp = new Car(name);

		if(items.contains(temp)) {
			System.out.println("있습니다");
		}
		else {
			System.out.println("없습니다");
		}
	}
}
