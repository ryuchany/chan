package api.thread;

import javax.swing.JOptionPane;

public class Test05 {
	public static void main(String[] args) throws InterruptedException {
		// 스레드를 생성하는 다른 방법
		// = Runnable 인터페이스의 객체를 만들어서 작업 내용을 보관
		// = Ruunable 인터페이스를 이용하여 Thread를 생성

		Runnable r = new Runnable() {
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

		Thread t = new Thread(r);

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
