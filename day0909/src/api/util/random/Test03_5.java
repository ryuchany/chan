package api.util.random;

import java.text.DecimalFormat;
import java.text.Format;
import java.util.Random;

public class Test03_5 {
	public static void main(String[] args) throws InterruptedException {
//		DecimalFormat을 적용시켜 무조건 6자리로 표현되도록 구현
//		= 식 : 000000

		Random r = new Random();
		Format f = new DecimalFormat("000000");

		while(true) {
			long time = System.currentTimeMillis() / 1000;//1초마다 바뀜
//			long time = System.currentTimeMillis() / 1000 / 10;//10초마다 바뀜
//			long time = System.currentTimeMillis() / 1000 / 60;//60초마다 바뀜
//			long time = System.currentTimeMillis() / 1000 / 72;//72초마다 바뀜

			r.setSeed(time);
			int otp = r.nextInt(1000000);
			System.out.println("OTP : "+f.format(otp));
		}
	}
}