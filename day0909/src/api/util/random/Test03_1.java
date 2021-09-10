package api.util.random;

import java.util.Random;

public class Test03_1 {
	public static void main(String[] args) throws InterruptedException {
		//OTP(One Time Password, 일회용 비밀번호)
		//= 비밀번호는 이를 이용하는 고객과 이를 확인하는 프로그램이 존재해야 한다.
		//= 즉 2명 이상이 일정 시간동안 "동일한 랜덤번호"를 알고 있어야 성립될 수 있다.

		//시드를 동일하게 설정하여 계속 같은 번호가 나오도록 구현
		Random r = new Random();

		while(true) {
			r.setSeed(1L);

			int otp = r.nextInt(1000000);
			System.out.println("otp = " + otp);

			Thread.sleep(100L);
		}
	}
}
