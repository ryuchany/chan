package api.net.tcp10;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashSet;
import java.util.Set;

public class MultiSocketServer {

	public static void main(String[] args) throws IOException {
		// 연결을 여러 개 관리할 수 있는 TCP 서버를 구현
		// = 연결을 여러 개 관리한다는 말은 모든 연결(Socket) 정보를 기억하고 있다는 의미
		// = 모든 연결 정보를 기억하려면 저장소가 필요하다
		// = 저장소 선택 시 중요한 것은 데이터 개수, 전체/개별/하이브리드, 중복
		// = Set<Socket> 과 같은 형태로 연결 정보를 저장해볼 수 있다.

		Set<Socket> user = new HashSet<>();

		try (ServerSocket server = new ServerSocket(30000);) {
			while (true) {
				Socket socket = server.accept();
				user.add(socket);
				System.out.println("[사용자 접속] 현재 사용자 " + user.size() + "명");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
