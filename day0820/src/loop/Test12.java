package loop;

public class Test12 {
	public static void main(String[] args) {

		int day30 = 0;
		int pushUp = 10;
		for (int i = 1; i <= 30; i++) {
			System.out.println(i + "일 = " + pushUp + "개");
			day30 += pushUp;
			pushUp += 3;
		}
		System.out.println("총 푸시업 개수 = " + day30 + "개");
	}
}
