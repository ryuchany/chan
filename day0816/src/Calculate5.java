import java.lang.*;
public class Calculate5 {
	public static void main(String[] args) {
		//문제점
		//1. 무슨 값이 얼마 인지 알 수 없다.
		//2. 매번 식을 입력 해야한다.
		//3. 자장면, 짬뽕, 개수 등이 변하면 식을 일일이 고쳐야 한다.
		
		//입력
		int chinaNoodlePrice = 5000; // 자장면 가격
		int chinaNoodleCount = 3; // 자장면 수량
		int champonPrice = 6000; // 짬뽕 가격
		int champonCount = 2; // 짬뽕 수량
		
		//처리
		int chinaNoodleTotal = chinaNoodlePrice*chinaNoodleCount;
		int champonTotal = champonPrice*champonCount;
		int total = chinaNoodleTotal + champonTotal;
		
		//출력
		System.out.println(chinaNoodleTotal);
		System.out.println(champonTotal);
		System.out.println(total);
	}
}
