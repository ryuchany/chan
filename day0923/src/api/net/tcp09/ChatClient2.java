package api.net.tcp09;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JOptionPane;

public class ChatClient2 {
	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket socket = new Socket("1.220.236.75", 30000);

		//(수신) 서버에서 보내는 메세지를 수신 후 출력 - thread
		//(발신) 사용자가 입력한 메세지를 서버로 전송 - main

		//스레드 생성 및 구동 코드
		Runnable r = ()->{
			//수신 작업(무한반복) - /exit라는 메세지가 수신되면 중지
			//1. 스트림 생성
			//2. 메세지 수신 후 출력 - 반복
			try {
				InputStream in = socket.getInputStream();
				InputStreamReader converter = new InputStreamReader(in);
				BufferedReader buffer = new BufferedReader(converter);

				while(true) {
					String line = buffer.readLine();
					if(line == null || line.equals("/exit")) {//종료명령이 전송되었다면 수신 중지
						break;
					}
					System.out.println("수신 : "+line);
				}
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		};
		Thread t = new Thread(r);
		t.setDaemon(true);
		t.start();

		//발신 작업(무한반복) - /exit라고 입력하면 중지
		//1. 스트림 생성
		//2. 사용자 입력 및 네트워크 전송(출력) - 반복

		OutputStream out = socket.getOutputStream();
		OutputStreamWriter converter = new OutputStreamWriter(out);
		BufferedWriter buffer = new BufferedWriter(converter);
		PrintWriter printer = new PrintWriter(buffer);

		while(true) {
			String input = JOptionPane.showInputDialog("메세지 입력");
			if(input != null) {//입력값이 있다면 전송하도록 조건을 설정
				printer.println(input);
				printer.flush();

				if(input.equals("/exit")) {//종료 명령이 입력되었다면
					break;
				}
			}
		}

		socket.close();
	}
}