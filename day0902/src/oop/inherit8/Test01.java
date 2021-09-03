package oop.inherit8;

public class Test01 {
	public static void main(String[] args) {
		Galaxy21s p1 = new Galaxy21s("010-1010-2020", "골드");
		p1.call();
		p1.sms();
		p1.samsungPay();
		p1.bixby();

		GalaxyFold3 p2 = new GalaxyFold3("010-1111-2222", "블랙");
		p2.call();
		p2.sms();
		p2.samsungPay();
		p2.iris();

		IPhone11 p3 = new IPhone11("010-3456-7890", "핑크");
		p3.call();
		p3.sms();
		p3.siri();
		p3.itunes();

		IPhone12 p4 = new IPhone12("010-1122-3344", "화이트");
		p4.call();
		p4.sms();
		p4.siri();
		p4.faceTime();
	}
}