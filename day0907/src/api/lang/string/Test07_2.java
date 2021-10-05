package api.lang.string;

public class Test07_2 {
	public static void main(String[] args) {
		//욕설 필터링 프로그램

		//입력 : 필터링 단어 저장
		String[] filter = new String[] {
			"주옥", "신발끈", "개나리", "십장생", "수박씨",
			"시베리아", "쌍화차", "가습기", "개불", "게새우"
		};

		String input = "이런 신발끈을 묶으면서 쌍화차를 마시는데 가습기가 고장나고 난리야";

		//처리 : 필터링 처리
		for(int i=0; i < filter.length; i++) {
			input = input.replace(filter[i], "***");
		}

		//출력 : 필터링 결과
		System.out.println(input);
	}
}
