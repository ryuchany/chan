package api.collection3;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Test06_1 {
	public static void main(String[] args) {
		// Map에서 Key 만 뽑아서 생각해보면 Set 형태를 띈다고 볼 수 있다.
		// = keySet() 명령을 사용하면 반환형이 Set이다.
		// = key를 모두 열거한 다음 연결된 value를 불러오면 모든 데이터를 조회할 수 있다.

		// Map<String, Integer> map = new HashMap<>();
		Map<String, Integer> map = new TreeMap<>();

		map.put("피카츄", 75);
		map.put("라이츄", 65);
		map.put("파이리", 90);

		Set<String> set = map.keySet();
		for (String name : set) {
			System.out.println("name = " + name);
			System.out.println("score = " + map.get(name));
		}
	}
}
