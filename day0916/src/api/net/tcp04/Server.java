package api.net.tcp04;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class Server {
	public static void main(String[] args) throws IOException {

		ServerSocket server = new ServerSocket(30000);
		System.out.println("로또 프로그램 시작");

		while (true) {
			Socket socket = server.accept();
			System.out.println("로또 번호 전송 완료");
			OutputStream out = socket.getOutputStream();

			Random r = new Random();
			Set<Integer> lotto = new TreeSet<>();
			
			while (lotto.size() < 6) {
				int number = r.nextInt(45) + 1;
				lotto.add(number);
			}
			for (int number : lotto) {
				out.write(number);
			}
			socket.close();
		}

	}
}
