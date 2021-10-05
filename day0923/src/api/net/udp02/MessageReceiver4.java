package api.net.udp02;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class MessageReceiver4 {
	public static void main(String[] args) {

		// 수신 도구 생성
		try (DatagramSocket ds = new DatagramSocket(23456);) {

			// 수신 공간 준비
			byte[] data = new byte[100];// 100byte

			while (true) {
				DatagramPacket dp = new DatagramPacket(data, data.length);

				// 수신
				ds.receive(dp);

				// 복원
				String text = new String(dp.getData(), 0, dp.getLength());
				System.out.println("text = " + text);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
