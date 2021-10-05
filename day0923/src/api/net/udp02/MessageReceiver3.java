package api.net.udp02;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class MessageReceiver3 {
	public static void main(String[] args) throws IOException {

		//수신 도구 생성
		DatagramSocket ds = new DatagramSocket(23456);

		//수신 공간 준비
		byte[] data = new byte[100];//100byte

		while(true) {
			DatagramPacket dp = new DatagramPacket(data, data.length);

			//수신
			ds.receive(dp);

			//복원
			String text = new String(dp.getData(), 0, dp.getLength());
			System.out.println("text = " +text);
		}

		//정리
		//ds.close();

	}
}
