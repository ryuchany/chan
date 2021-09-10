package api.util.random;

import java.text.DecimalFormat;
import java.text.Format;
import java.util.Random;

public class Test03_6 {
	public static void main(String[] args) throws InterruptedException {
//		서로 다른 사용자가 다른 값이 나오게 하려면 "시간" 외에 "사용자별 고유정보"를 추가하여 시드를 생성

		String a = "khstudent";
		String b = "khteacher";

		Random r = new Random();
		Format f = new DecimalFormat("000000");

		while(true) {
			long time = System.currentTimeMillis() / 1000;//1초마다 바뀜
//			long time = System.currentTimeMillis() / 1000 / 10;//10초마다 바뀜
//			long time = System.currentTimeMillis() / 1000 / 60;//60초마다 바뀜
//			long time = System.currentTimeMillis() / 1000 / 72;//72초마다 바뀜

			r.setSeed(time + a.hashCode());
			int otpA = r.nextInt(1000000);
			System.out.print("[A사용자] OTP : "+f.format(otpA));

			r.setSeed(time + b.hashCode());
			int otpB = r.nextInt(1000000);
			System.out.print(", [B사용자] OTP : "+f.format(otpB));
			System.out.println();

			Thread.sleep(100L);
		}
	}
}
