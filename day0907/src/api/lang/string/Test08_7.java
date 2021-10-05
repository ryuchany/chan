package api.lang.string;

public class Test08_7 {
	public static void main(String[] args) {
		// 문자열에 포함된 특정 단어의 출현 빈도를 측정
		// Q : example에 "공장"이 몇 번 나왔는지 세어보세요
		String example = "간장공장 공장장은 강공장장이고 된장공장 공장장은 공공장장이다";

		String word = "공장";

		int index = 0;

		while (true) {
			index = example.indexOf(word, index);
			System.out.println("index = " + index);

			if (index == -1) {// -1이면 없다는 소리
				break;
			}

			index++;
		}

	}
}
