package loop;

//import java.lang.*;

public class Test07 {
	public static void main(String[] args) {
//1부터 100사이에 있는 "7의 배수"를 출력
		for (int i = 1; i <= 100; i++)
			
			if (i % 7 == 0) {
				System.out.println("7의 배수 = " + i);
			}
		
	}
}