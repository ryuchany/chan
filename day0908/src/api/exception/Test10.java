package api.exception;

public class Test10 {
	public static void main(String[] args) {
		System.out.println("안녕하세요");

		try {
			Thread.sleep(3000L);
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("안녕히계세요");

	}
}
