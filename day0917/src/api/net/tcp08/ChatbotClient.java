package api.net.tcp08;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ChatbotClient {
	public static void main(String[] args) throws IOException{
//		연결 생성
		Socket socket = new Socket("localhost", 30000);

//		입력 및 출력 스트림 생성
		BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		PrintWriter printer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())));
		Scanner sc = new Scanner(System.in);

		while(true) {
			System.out.print("명령 : ");
			String input = sc.nextLine();//키보드 입력
			printer.println(input);//메세지 출력
			printer.flush();

			if(input.equals("exit")) break;//exit 입력 시 서버에게 알린 후 응답 수신하지 말고 종료

			String response = reader.readLine();//응답 수신
			System.out.println("<서버응답>");
			System.out.println(response);
		}
		sc.close();
//		연결 종료
		socket.close();
	}
}
