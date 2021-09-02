package oop.inherit2;

public class Test01 {
	public static void main(String[] args) {
		//Galaxy 객체를 생성해서 기능 실행
		Galaxy p1 = new Galaxy();
		p1.setNumber("010-1212-3434");
		System.out.println(p1.getNumber());
		p1.call();
		p1.sms();
		p1.gallery();
		p1.samsungPay();
		p1.voiceRecord();

		
		//IPhone 객체를 생성해서 기능 실행
		IPhone p2 = new IPhone();
		p2.setNumber("010-1212-3434");
		System.out.println(p2.getNumber());
		p2.call();
		p2.sms();
		p2.gallery();
		p2.itunes();
		p2.siri();
	}
}
