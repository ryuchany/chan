package api.net.tcp04;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.Set;
import java.util.TreeSet;

public class Client {
	public static void main(String[] args) throws IOException {

		Socket socket = new Socket("localhost", 30000);
		InputStream in = socket.getInputStream();

		Set<Integer> lotto = new TreeSet<>();
		while (true) {
			int number = in.read();
			if (number == -1)
				break;
			lotto.add(number);
		}
		System.out.println("이번주 로또번호는?-->" + lotto);

		socket.close();
		in.close();
	}
}
