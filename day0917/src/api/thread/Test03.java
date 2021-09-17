package api.thread;

import javax.swing.JOptionPane;

public class Test03 {
	public static void main(String[] args) throws InterruptedException {
		// 스레드를 하나 생성해서 main 과 병렬로 실행(멀티스레드)
		// = main에서 1부터 100까지 출력하는 코드를 실행
		// = 생성한 스레드에서 입력 코드를 실행

		// 스레드(일꾼) 생성
		// Thread t = new Thread();//이렇게 생성하면 뭘 해야하는지 알 수 없다.
		Thread t = new Thread() {// 익명클래스를 만들어서 작업을 run메소드에 재정의한다.
			@Override
			public void run() {
				// 2
				for (int i = 1; i <= 100; i++) {
					System.out.println(i);
					try {
						Thread.sleep(1000L);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};

		// 스레드(일꾼) 구동
		t.start();

		// 1
		String input = JOptionPane.showInputDialog("메세지 입력");
		System.out.println(input);
	}
}
