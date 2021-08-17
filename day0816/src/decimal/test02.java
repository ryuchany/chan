package decimal;

import java.lang.*;

public class test02 {
	public static void main(String[] args) {

		int triangleKimbapPrice = 1000;
		int triangleKimbapCount = 5;
		
		int freeCount = triangleKimbapCount / 2;
		int payCount = triangleKimbapCount - freeCount;
		int totalPrice = payCount * triangleKimbapPrice;
		System.out.println(totalPrice);
		System.out.println(payCount);
		System.out.println(freeCount);
		
	}
}
