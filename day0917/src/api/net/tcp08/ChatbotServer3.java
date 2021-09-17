package api.net.tcp08;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class ChatbotServer3 {
	public static void main(String[] args) throws IOException {
//		메세지별 응답을 Collection으로 정의한다.
		Map<String, String> messages = new HashMap<>();
		messages.put("$화이팅", "우리모두 화이팅!");
		messages.put("$동기부여", "넌 언젠가 지구최강의 개발자가 될거야!");
		messages.put("$링크", "문서 사이트는 https://hiphop5782.github.io 입니다");

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

			//명령에 대한 응답을 messages에서 찾는다(없으면 null이 나온다)
			String text = messages.get(line);
			if(text == null) {
				printer.println("지원하지 않는 명령입니다");
			}
			else {
				printer.println(text);
			}
			printer.flush();
		}

//		사용자 접속 종료
		socket.close();

//		서버 종료
		server.close();
	}
}
