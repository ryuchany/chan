package api.lang.string;

public class Test08_5 {
	public static void main(String[] args) {
		// 문자열에 포함된 특정 단어의 출현 빈도를 측정
		// Q : example에 "공장"이 몇 번 나왔는지 세어보세요
		String example = "간장공장 공장장은 강공장장이고 된장공장 공장장은 공공장장이다";

		String word = "공장";

		int index = example.indexOf(word, 0);
		System.out.println("index = " + index);

		index = example.indexOf(word, index + 1);
		System.out.println("index = " + index);

		index = example.indexOf(word, index + 1);
		System.out.println("index = " + index);

		index = example.indexOf(word, index + 1);
		System.out.println("index = " + index);

		index = example.indexOf(word, index + 1);
		System.out.println("index = " + index);

		index = example.indexOf(word, index + 1);
		System.out.println("index = " + index);

		index = example.indexOf(word, index + 1);
		System.out.println("index = " + index);

	}
}
