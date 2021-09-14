package api.collection3;

public class Test04 {
	public static void main(String[] args) {
		// 비트 연산자 : & , | , ^
		// = 비트 단위로 숫자를 계산하는 연산
		// = &를 AND 연산
		// = | 를 OR 연산
		// = ^ 를 XOR 연산

		int flag = 0;
		System.out.println(Integer.toBinaryString(flag));
		// 어떤 이유에서 특정 비트만 1로 설정해야 하는 경우가 발생
		// = 오른쪽에서 4번째 비트만 ON(1) 으로 설정하고 싶은 경우
		flag |= 0b00001000;
		flag |= 0b00010000;
		flag |= 0b01000000;
		System.out.println(Integer.toBinaryString(flag));

		// 어떤 이유에서 특정 비트만 0으로 초기화해야 하는 경우가 발생
		flag &= 0b01000000;
		System.out.println(Integer.toBinaryString(flag));

		// 어떤 이유에서 전체를 초기화해야 하는 경우가 발생
		flag ^= flag;
		System.out.println(Integer.toBinaryString(flag));

		// ex : 비밀번호 암호화(XOR 암호화)
		String password = "khacademy";
		System.out.println(password);

		StringBuffer buffer = new StringBuffer();
		for (int i = 0; i < password.length(); i++) {
			buffer.append((char) (password.charAt(i) ^ 8));
		}

		System.out.println(buffer);// 암호화된 결과

		StringBuffer buffer2 = new StringBuffer();
		for (int i = 0; i < buffer.length(); i++) {
			buffer2.append((char) (buffer.charAt(i) ^ 8));
		}
		System.out.println(buffer2);// 복호화된 결과

	}
}
