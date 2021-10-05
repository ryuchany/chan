package api.lang.string;

public class Test08_9 {
	public static void main(String[] args) {
		String example = "간장공장 공장장은 강공장장이고 된장공장 공장장은 공공장장이다";
		String word = "공장";

		SearchEngine engine = new SearchEngine();
		int count = engine.frequency(example, word);
		System.out.println("출현 빈도 : "+count);
	}
}
