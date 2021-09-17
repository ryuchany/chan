package api.net.tcp06;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client3 {
	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket socket = new Socket("localhost", 30000);

		// 키보드 입력도구
		Scanner sc = new Scanner(System.in);
		// 네트워크 출력스트림
		OutputStream out = socket.getOutputStream();
		OutputStreamWriter converter = new OutputStreamWriter(out);
		BufferedWriter buffer = new BufferedWriter(converter);
		PrintWriter printer = new PrintWriter(buffer);

		while (true) {
			System.out.print("입력 : ");
			String line = sc.nextLine();

			printer.println(line);
			printer.flush();

			if (line.equals("종료"))
				break;
		}

		sc.close();
		socket.close();
	}
}
