package api.thread;

public class Test07_1 {
	public static void main(String[] args) {

//		작업1 : 5초에 한번씩 콘솔에 `------------------------------` 출력(5번)
//		작업2 : 3초에 한번씩 콘솔에 `Hello Java!` 출력(10번)
//		작업3 : 2초에 한번씩 콘솔에 `KH 정보교육원` 출력(15번)

//		작업1 - thread(t1)
		Runnable r1 = () -> {
			for (int i = 0; i < 5; i++) {
				try {
					Thread.sleep(5000L);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("-----------------");
			}
		};
		Thread t1 = new Thread(r1);
		t1.setDaemon(true);
		t1.start();

//		작업2 - thread(t2)
		Runnable r2 = () -> {
			for (int i = 0; i < 10; i++) {
				try {
					Thread.sleep(3000L);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("Hello Java!");
			}
		};
		Thread t2 = new Thread(r2);
		t2.setDaemon(true);
		t2.start();

//		작업3 - main thread
		for (int i = 0; i < 15; i++) {
			try {
				Thread.sleep(2000L);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("KH 정보교육원");
		}

	}
}
