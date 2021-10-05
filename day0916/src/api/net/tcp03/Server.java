package api.net.tcp03;

import java.io.File;
import java.io.FileInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static void main(String[] args) {

		// 파일을 먼저 다 불러와놓고 사용자 접속 시 전송하도록 구현
		// = 접속할 때마다 불러오는것보다 성능이 탁월하게 좋음

		File target = new File("image", "lion.gif");
		byte[] buffer = new byte[(int) target.length()];
		try (FileInputStream in = new FileInputStream(target);) {
			in.read(buffer);
		} catch (Exception e) {
			System.err.println("이미지 로딩 실패");
			System.exit(-1);
		}

		while (true) {
			try (ServerSocket server = new ServerSocket(30000);) {
				System.out.println("서버 구동 시작");
				while (true) {
					try (Socket socket = server.accept();) {
						System.out.println("사용자 접속 : " + socket.getInetAddress().getHostAddress());
						socket.getOutputStream().write(buffer);
						System.out.println("--> 이미지 전송 완료");
					}
				}
			} catch (Exception e) {
//				e.printStackTrace();
				System.err.println("--> 에러 발생");
			}
		}

	}
}
