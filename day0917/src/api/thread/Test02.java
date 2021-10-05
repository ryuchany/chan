package api.thread;

import javax.swing.JOptionPane;

public class Test02 {
	public static void main(String[] args) throws InterruptedException {
		// 싱글 스레드에서 여러 개의 작업을 처리하는 방법
		// 1. 사용자에게 입력창을 보여주고 입력을 받는 작업
		// 2. 1초 간격으로 1부터 100까지 출력하는 작업

		// 1
		String input = JOptionPane.showInputDialog("메세지 입력");
		System.out.println(input);

		// 2
		for (int i = 1; i <= 100; i++) {
			System.out.println(i);
			Thread.sleep(1000L);
		}
	}
}
