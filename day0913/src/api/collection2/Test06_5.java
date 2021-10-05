package api.collection2;

import java.util.Set;
import java.util.TreeSet;

public class Test06_5 {
	public static void main(String[] args) {

//		Comparable을 상속한 클래스는 TreeSet을 그냥 이용할 수 있다.
		Set<Car> items = new TreeSet<>();

		items.add(new Car("소나타", "중형", 15000000));
		items.add(new Car("소나타", "중형", 15000000));
		items.add(new Car("소나타", "중형", 15000000));
		items.add(new Car("아반떼", "중형", 12000000));
		items.add(new Car("레이", "소형", 9000000));

//		출력
		for(Car car : items) {
			System.out.println(car);
		}
	}
}
