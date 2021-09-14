package api.collection2;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class Test06_4 {
	public static void main(String[] args) {

//		Comparator를 이용하여 생성하면 TreeSet에 객체를 저장할 수 있다.
		Comparator<Car> c = new Comparator<Car>() {
			@Override
			public int compare(Car o1, Car o2) {
				return o1.getName().compareTo(o2.getName());//이름 오름차순
			}
		};

		Set<Car> items = new TreeSet<>(c);

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
