package api.collection2;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class Test08 {
	public static void main(String[] args) {
		Set<Integer> a = new TreeSet<>(Arrays.asList(10, 20, 30));
		Set<Integer> b = new TreeSet<>(Arrays.asList(20, 30, 40, 50));

		System.out.println(a);
		System.out.println(b);

		Set<Integer> c = new TreeSet<>();
		c.addAll(a);
		c.addAll(b);
		System.out.println(c);
	}
}
