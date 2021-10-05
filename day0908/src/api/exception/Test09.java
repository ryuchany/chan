package api.exception;

public class Test09 {
	public static void main(String[] args) {

		Calculator c = new Calculator();

		try {
			int result = c.div(0, 10); // 정상적인 경우
//			int result = c.div(10, 0);// 비정상적인 경우
			System.out.println("result = " + result);
		} catch (Exception e) {
			e.printStackTrace();
//			System.out.println("사고침.");
		}
	}
}