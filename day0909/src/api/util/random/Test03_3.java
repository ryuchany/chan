package api.util.random;

import java.util.Random;

public class Test03_3 {
	public static void main(String[] args) throws InterruptedException {
//		앞에서 계산한 시간을 SEED로 사용하여 랜덤값을 추출
		Random r = new Random();
		while(true) {
			long time = System.currentTimeMillis() / 1000;//1초마다 바뀜
//			long time = System.currentTimeMillis() / 1000 / 10;//10초마다 바뀜
//			long time = System.currentTimeMillis() / 1000 / 60;//60초마다 바뀜
//			long time = System.currentTimeMillis() / 1000 / 72;//72초마다 바뀜

			r.setSeed(time);
			int otp = r.nextInt(1000000);
			System.out.println("OTP : "+otp);
		}
	}
}
