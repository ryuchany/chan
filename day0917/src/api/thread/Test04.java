package api.thread;

import javax.swing.JOptionPane;

public class Test04 {
	public static void main(String[] args) throws InterruptedException {
		// 스레드의 문제점
		// = main이 끝났을 때 스레드를 종료할것인가 종료하지 않을 것인가 결정을 해야 한다.
		// = 스레드에게 작업을 지시하기 전에 미리 약속을 해놔야 한다.
		// = 한 번 일을 시작하면 강제로 중지시키기가 매우 어렵다.

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

		// 이 지점에서 스레드에 필요한 모든 설정을 완료해야 한다.
		// = 구동을 시작하면 통제할 수 없기 때문

		// 데몬 스레드 설정(main에 완전한 종속이 이루어진다)
		// = 모든 스레드가 데몬인 경우에만 종속이 이루어진다
		// = 단 한 개라도 데몬 스레드가 아닌 스레드가 생성되었다면 모든 데몬 스레드가 작동하지 않는다.
		// = 다 데몬하든가 아니면 다 하지말든가 중간은 없다.
		t.setDaemon(true);

		// 스레드(일꾼) 구동
		t.start();

		// 1
		String input = JOptionPane.showInputDialog("메세지 입력");
		System.out.println(input);
	}
}
