package api.net.tcp10;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.HashSet;
import java.util.Set;

//서버에서 사용자 연결(Socket)을 처리하기 위한 보조 장치들까지 포함된 클래스
public class TcpUser {

	// 전체에게 메세지를 보내려면 전체 사용자 정보를 알아야 한다.
	// = 전체 사용자 정보는 Set<TcpUser> 형태로 main에 있다.
	// = main에 있는 저장소를 이곳에서 사용할 수 없다.
	// = 저장소를 이곳으로 옮겨야 한다.
	// = 하지만 객체에 저장하면 안되므로 탈객체(static) 처리를 한다.
	// = 이 저장소와 연관된 기능은 모두다 static으로 만들어야 한다.
	// = 입장(enter), 퇴장(leave), 전체전송(broadcast)와 같은 기능을 만든다.
	private static Set<TcpUser> user = new HashSet<>();

	public static void enter(TcpUser u) {
		user.add(u);
		System.out.println("[사용자 접속] 현재 사용자 " + user.size() + "명 " + u.socket);
	}

	public static void leave(TcpUser u) {
		user.remove(u);
		System.out.println("[사용자 종료] 현재 사용자 " + user.size() + "명 " + u.socket);
	}

	public static void broadcast(String message) {
		for (TcpUser u : user) {
			u.send(message);
		}
	}

	private Socket socket;// 연결 정보
	private PrintWriter writer;// 출력 도구
	private BufferedReader reader;// 입력 도구

	public TcpUser(Socket socket) {
		try {
			this.socket = socket;

			// 이 사용자가 이용할 스트림들을 생성(발생하는 예외는 main이 알 수 있도록 전가 -> 연결 제거)
			this.writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())));
			this.reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

			// 스레드 생성 및 작업지시(수신 작업)
			Runnable r2 = () -> {
				try {
					receive();
				} catch (IOException e) {
					// 수신 오류가 발생했다는 것은 연결에 문제가 생겼다는 의미
					// = 저장소에서 등록된 연결정보를 제거
					TcpUser.leave(this);
				}
			};
			Thread t2 = new Thread(r2);
			t2.setDaemon(true);
			t2.start();
		} catch (Exception e) {
			// 예외가 발생했다는 것은 연결에 문제가 생겼다는 의미
			// = 저장소에서 등록된 연결정보를 제거
			TcpUser.leave(this);
		}
	}

	// 보내는 메소드 - 메세지를 수신하면 1회 실행되도록 개조
	public void send(String line) {
		writer.println(line);
		writer.flush();
	}

	// 받는 메소드
	public void receive() throws IOException {
		while (true) {
			String line = reader.readLine();
			if (line == null)
				break;
			// send(line);//보낸 사람에게 회신(Echo)
			TcpUser.broadcast(line);// 전체에게 전송(broadcast)
			System.out.println("수신 : " + line + "(" + socket + ")");
		}
	}

}
