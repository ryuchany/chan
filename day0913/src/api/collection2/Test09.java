package api.collection2;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class Test09 {
	public static void main(String[] args) {
		Set<String> hani = new TreeSet<>(Arrays.asList("소울", "미나리", "자산어보", "서복", "비와 당신의 이야기"));
		Set<String> duli = new TreeSet<>(Arrays.asList("소울", "내일의 기억", "비와 당신의 이야기", "크루엘라", "발신제한"));

//		1. 교집합(하니 ∩ 둘리)
		Set<String> intersect = new TreeSet<>();
		intersect.addAll(hani);
		intersect.retainAll(duli);

//		System.out.println(union);
		System.out.println("1. 하니와 둘리 모두 본 영화");
		for (String movie : intersect) {
			System.out.println("--> " + movie);
		}

//		2. 차집합(하니 - 둘리)
		Set<String> haniOnly = new TreeSet<>();
		haniOnly.addAll(hani);
		haniOnly.removeAll(duli);

//		System.out.println(haniOnly);
		System.out.println("2. 하니만 본 영화");
		for (String movie : haniOnly) {
			System.out.println("--> " + movie);
		}

//		3. 차집합(둘리 - 하니)
		Set<String> duliOnly = new TreeSet<>(duli);
		duliOnly.removeAll(hani);
//		System.out.println(duliOnly);
		System.out.println("3. 둘리만 본 영화");
		for (String movie : duliOnly) {
			System.out.println("--> " + movie);
		}

//		4. 합집합(하니 ∪ 둘리)
		Set<String> union = new TreeSet<>();
		union.addAll(hani);
		union.addAll(duli);

//		System.out.println(union);
		System.out.println("4. 하니와 둘리 중 한명이라도 본 영화는 총 " + union.size() + "개 입니다");
		for (String movie : union) {
			System.out.println("--> " + movie);
		}

	}
}
