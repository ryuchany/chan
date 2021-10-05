package api.lang.string;

public class Test08_10 {
	public static void main(String[] args) {
		// 필터링과 빈도측정을 결합
		SearchEngine engine = new SearchEngine();

		String keyword = "개발";

		String[] result = engine.search(keyword);

		for (int i = 0; i < result.length; i++) {
			System.out.print("[빈도 : " + engine.frequency(result[i], keyword) + "] ");
			System.out.print("[시작 : " + result[i].indexOf(keyword) + "]");
			System.out.println(result[i]);
		}
	}
}
