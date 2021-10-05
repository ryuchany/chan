package api.net.tcp08;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatbotServer2 {
	public static void main(String[] args) throws IOException {
//		서버 준비
		ServerSocket server = new ServerSocket(30000);

//		사용자 접속
		Socket socket = server.accept();

//		입력 및 출력 스트림 생성
		BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		PrintWriter printer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())));

		while(true) {
			//사용자 메세지 수신
			String line = reader.readLine();

			//사용자가 강제로 종료하면 line == null 수신
			if(line == null || line.equals("exit")) {
				break;
			}

			String text;
			switch(line) {
			case "$동기부여":	text = "넌 언젠가 지구최강의 개발자가 될거야!"; break;
			case "$화이팅":		text = "우리모두 화이팅!"; break;
			case "$링크":			text = "문서 사이트는 https://hiphop5782.github.io 입니다"; break;
			default: 				text = "지원하지 않는 명령입니다"; break;
			}

			printer.println(text);
			printer.flush();
		}

//		사용자 접속 종료
		socket.close();

//		서버 종료
		server.close();
	}
}
