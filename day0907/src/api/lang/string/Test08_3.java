package api.lang.string;

public class Test08_3 {
	public static void main(String[] args) {
		SearchEngine engine = new SearchEngine();

		String keyword = "개발";
		String[] result = engine.search(keyword);

		// 출력
		System.out.println("검색 결과는 총 " + result.length + "개 입니다");
		for (int i = 0; i < result.length; i++) {
			System.out.println(result[i]);
		}

	}
}