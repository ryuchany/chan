package api.net.tcp09;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JOptionPane;

public class ChatServer3 {
	public static void main(String[] args) throws IOException {
		ServerSocket server = new ServerSocket(30000);

		try (Socket socket = server.accept();) {

			// (수신) 클라이언트에서 보내는 메세지를 수신 - main
			// (발신) 클라이언트로 메세지를 전송 - thread
			// = 상대방의 접속이 종료된 경우 발신하려고 하면 SocketException이 발생한다.

			// 스레드 생성 및 구동 코드
			Runnable r = () -> {
				// 발신 작업(무한반복) - /exit라고 입력하면 중지
				// 1. 스트림 생성
				// 2. 사용자 입력 및 네트워크 전송(출력) - 반복

				try {
					OutputStream out = socket.getOutputStream();
					OutputStreamWriter converter = new OutputStreamWriter(out);
					BufferedWriter buffer = new BufferedWriter(converter);
					PrintWriter printer = new PrintWriter(buffer);

					while (true) {
						String input = JOptionPane.showInputDialog("서버 메세지 입력");
						if (input != null) {// 입력값이 있다면 전송하도록 조건을 설정
							printer.println(input);
							printer.flush();
						}
					}
				} catch (Exception e) {
					// e.printStackTrace();
				}
			};
			Thread t = new Thread(r);
			t.setDaemon(true);
			t.start();

			// 수신 작업(무한반복) - /exit라는 메세지가 수신되면 중지
			// 1. 스트림 생성
			// 2. 메세지 수신 후 출력 - 반복
			InputStream in = socket.getInputStream();
			InputStreamReader converter = new InputStreamReader(in);
			BufferedReader buffer = new BufferedReader(converter);

			while (true) {
				String line = buffer.readLine();
				if (line == null || line.trim().equals("/exit")) {// 종료명령이 전송되었다면 수신 중지
					System.out.println("수신 중지");
					System.exit(0);
				}
				System.out.println("수신 : " + line);
			}
		} catch (Exception e) {
			// e.printStackTrace();
			// 접속이 끊어지면 SocketException 발생
			System.exit(0);
		}

		server.close();
		System.out.println("서버 종료");
	}
}
