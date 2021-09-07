package api.lang.string;

public class Test07_5 {
	public static void main(String[] args) {
//		문자열 덧셈 (원하는 개수만큼 별 문자열 만들기)

		int size = 3;

//		String star = null;//초기값으로 사용할 수 없음
		String star = "";//empty string, 빈 문자열

		for(int i=0; i < size; i++) {
			star += "*";
		}

		System.out.println(star);
	}
}
