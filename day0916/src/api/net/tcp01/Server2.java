package api.net.tcp01;

import java.io.IOException;
import java.net.ServerSocket;


public class Server2 {
	public static void main(String[] args) {

		//내 컴퓨터에서 사용하는 포트 확인하는 프로그램(포트스캐너)
		//= 0부터 65535까지 다 열어보면 된다.

		for(int i=0; i <= 65535; i++) {
			try {
				ServerSocket server = new ServerSocket(i);
				//System.out.println("사용 가능한 번호입니다");
			} catch (IOException e) {
				System.out.println("["+i+"] 이미 사용중인 번호입니다");
			}
		}

	}
}
