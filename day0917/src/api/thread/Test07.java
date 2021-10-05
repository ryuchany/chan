package api.thread;

public class Test07 {
	public static void main(String[] args) throws InterruptedException {

//		작업1 : 5초에 한번씩 콘솔에 `------------------------------` 출력(5번)
//		작업2 : 3초에 한번씩 콘솔에 `Hello Java!` 출력(10번)
//		작업3 : 2초에 한번씩 콘솔에 `KH 정보교육원` 출력(15번)

//		싱글 스레드로 구현하는 예제(이게 좋나요?)
		for (int i = 1; i <= 30; i++) {
			if (i % 2 == 0) {
				System.out.println("KH 정보교육원");
			}

			if (i % 3 == 0) {
				System.out.println("Hello Java!");
			}

			if (i % 5 == 0) {
				System.out.println("---------------------");
			}

			Thread.sleep(1000L);
		}

	}
}
