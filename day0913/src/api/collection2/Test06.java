package api.collection2;

import java.util.HashSet;
import java.util.Set;

public class Test06 {
	public static void main(String[] args) {

//		Car를 저장할 수 있는 저장소 생성
//		Set<Car> items = new TreeSet<>();
		Set<Car> items = new HashSet<>();

		items.add(new Car("소나타", "중형", 15000000));
		items.add(new Car("아반떼", "중형", 12000000));
		items.add(new Car("레이", "소형", 9000000));

		for (Car c : items) {
			System.out.println(c);
		}
	}
}
