package api.net.tcp10;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashSet;
import java.util.Set;

public class MultiSocketServer2 {


	public static void main(String[] args) throws IOException {
		//접속만 저장해서는 서버의 기능을 제대로 수행할 수 없다.
		//= 우리가 만드는 서버는 사용자가 메세지를 보내면 그 메세지를 전체 사용자에게 전송해야 하는 서버
		//= 모든 사용자로부터 메세지를 받을 수 있어야 하고
		//= 모든 사용자에게로 메세지를 보낼 수 있어야 한다
		//= 모든 Socket마다 입출력 스트림이 존재해야 한다.
		//= Socket + PrintWriter + BufferedReader가 세트로 관리되어야 한다.
		//= 스레드는 연결 하나당 두 개가 필요하다.
		//= main에 다 구현할 수 없으므로 Socket, PrintWriter, BufferedReader, Thread를 묶어서 클래스로 구현
		//= TcpUser 클래스에 구현
		//= TcpUser 클래스는 반드시 Socket 정보가 있어야 한다(생성자)

		Set<TcpUser> user = new HashSet<>();

		try(ServerSocket server = new ServerSocket(30000);){
			while(true) {
				Socket socket = server.accept();

				TcpUser u = new TcpUser(socket);
				user.add(u);
				System.out.println("[사용자 접속] 현재 사용자 "+user.size()+"명");
			}
		}
		catch(Exception e) {
			//e.printStackTrace();
			//연결 제거
		}
	}

}
