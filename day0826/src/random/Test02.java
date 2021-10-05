package random;

import java.util.Random;

public class Test02 {
	public static void main(String[] args) {
		// 다음 요구사항에 맞느 랜덤값을 추첨하여 화면에 출력
		// 1. 주사위 1개를 던진 예상 결과
		// 2. 로또번호 1개를 추첨한 결과
		// 3. 랜덤한 6자리 정수(OTP 번호)

		// 1. 주사위 1개를 던진 예상 결과
		Random d = new Random();
		int dice = d.nextInt(6) + 1;
		System.out.println("주사위 1개를 던진 결과 = " + dice);

		// 2. 주사위 1개를 던진 예상 결과
		int lotto = d.nextInt(45) + 1;
		System.out.println("로또번호 1개를 추첨한 결과 = " + lotto);

		// 3. 랜덤한 6자리 정수(OTP 번호)
		// 범위 100000부터 999999까지 -> 100000부터 900000까지
		int otp = d.nextInt(900000) + 100000;
		System.out.println("랜덤한 6자리 정수 = " + otp);
	}
}
