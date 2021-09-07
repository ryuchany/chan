package api.lang.string;

public class Test07_1 {
	public static void main(String[] args) {
		//욕설 필터링 프로그램

		//입력 : 필터링 단어 저장
		String[] filter = new String[] {
			"주옥", "신발끈", "개나리", "십장생", "수박씨",
			"시베리아", "쌍화차", "가습기", "개불", "게새우"
		};

		String input = "이런 신발끈을 묶으면서 쌍화차를 마시는데 가습기가 고장나고 난리야";

		//처리 : 필터링 처리
		input = input.replace(filter[0], "***");
		input = input.replace(filter[1], "***");
		input = input.replace(filter[2], "***");
		input = input.replace(filter[3], "***");
		input = input.replace(filter[4], "***");
		input = input.replace(filter[5], "***");
		input = input.replace(filter[6], "***");
		input = input.replace(filter[7], "***");
		input = input.replace(filter[8], "***");
		input = input.replace(filter[9], "***");

		//출력 : 필터링 결과
		System.out.println(input);
	}
}
