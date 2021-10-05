package api.net.tcp04;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class Server5 {
	public static void main(String[] args) throws IOException {
		// Client 접속 시 "로또 번호 6개"를 Client에게 전송하는 서버
		// = 로또 번호 6개의 자료형은 다음과 같이 분석해볼 수 있다.
		// -> int 6개 : 멀티바이트 출력
		// -> int[] 1개 : 객체 출력
		// -> List<Integer> 1개 : 객체 출력
		// -> Set<Integer> 1개 : 객체 출력
		// -> 내가 만든 클래스 : 객체 출력

		ServerSocket server = new ServerSocket(30000);// 서버 30000포트 개방

		Socket socket = server.accept();// 사용자 접속 수락

		// 로또 번호 6개 추첨
		Random r = new Random();
		Set<Integer> lotto = new TreeSet<>();
		while (lotto.size() < 6) {
			lotto.add(r.nextInt(45) + 1);
		}

		// 사용자에게 로또번호 6개를 보내는 코드
		// --> Set<Integer> 1개를 전송하도록 객체스트림을 구성
		OutputStream out = socket.getOutputStream();
		BufferedOutputStream buffer = new BufferedOutputStream(out);
		ObjectOutputStream oData = new ObjectOutputStream(buffer);

		oData.writeObject(lotto);

		socket.close();

		server.close();

	}
}
