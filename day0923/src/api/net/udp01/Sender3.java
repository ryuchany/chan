package api.net.udp01;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class Sender3 {
	public static void main(String[] args) throws IOException {
		// UDP 통신에서 대용량 데이터를 보낼 경우 처리방법
		// = 수신측에 설정된 크기만큼 잘라서 보낸다
		// = 수신측에서 설정된 크기보다 큰 데이터가 전송되면 버려진다

		// 사용되는 클래스 : DatagramSocket, DatagramPacket

		// 보내는 쪽에서는 전송을 위한 도구와 데이터를 준비
		DatagramSocket ds = new DatagramSocket();

		// 데이터를 준비해서 ds를 이용하여 전송
		String text = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";// 124byte

		// 준비한 데이터를 byte로 변환
		byte[] data = text.getBytes();

		// DatagramPacket dp = new DatagramPacket(보내는데이터, 보내는크기, 주소객체, 포트번호);
		// DatagramPacket dp = new DatagramPacket(data, data.length, "localhost",
		// 30000);//error

		InetAddress address = InetAddress.getByName("localhost");// 127.0.0.1
		System.out.println(address);

		// 전송할 데이터의 시작위치와 전송개수를 관리하기 위한 변수
		int start = 0;
		int block = 80;

		while (start < data.length) {// 시작지점이 배열크기보다 작으면
			// 남은개수 = 전체크기 - 시작지점 = data.length - start
			int remain = data.length - start;
			System.out.println("남은 데이터 : " + remain + "개");
			// 전송개수 = 남은개수와 블록크기(80) 중에서 작은것
			int size = Math.min(block, remain);
			System.out.println("전송개수 : " + size + "개");

			// 전송할 만큼의 공간을 생성한 뒤 data에서 해당 부분만큼 copy를 수행
			byte[] buffer = new byte[size];
			// System.arraycopy(어느배열에서, 어느지점부터, 어느배열로, 어느지점부터, 몇개);
			System.arraycopy(data, start, buffer, 0, size);

			DatagramPacket dp = new DatagramPacket(buffer, size, address, 30000);

			// 전송 코드
			ds.send(dp);
			System.out.println("전송 완료");

			// 시작지점을 block에 설정된 크기만큼 증가 처리
			start += block;
		}

		// 정리 코드
		ds.close();
		System.out.println("사용 종료");
	}
}
