package api.util.random;

import java.text.DecimalFormat;
import java.text.Format;

public class Test03_4 {
	public static void main(String[] args) throws InterruptedException {
//		Format 클래스 중에 DecimalFormat 클래스를 이용하여 숫자 형식을 재설정
//		# 은 숫자가 있는 경우만 출력(자리수 보전 불가)
//		0 은 숫자가 없으면 0으로 출력(자리수 보전 가능)

		int a = 1234567890;
		System.out.println("a = " + a);

		Format f1 = new DecimalFormat("#,###");
		System.out.println("a = " + f1.format(a));

		int b = 10;
		System.out.println("b = " + b);
		System.out.println("b = " + f1.format(b));

		Format f2 = new DecimalFormat("0,000");
		System.out.println("a = " + f2.format(a));
		System.out.println("b = " + f2.format(b));

		Format f3 = new DecimalFormat("#,##0.00");
		System.out.println("b = " + f3.format(b));

		double c = 0.567;
		System.out.println("c = " + c);
		System.out.println("c = " + f3.format(c));

	}
}
