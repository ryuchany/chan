package oop.basic1;

public class Test01 {
	public static void main(String[] args) {
		//메세지 객체 생성
		Message first = new Message();
		
		//first = "초롱초롱 라이언"; //리모컨에 데이터 대입은 불가
		first.nickname = "초롱초롱 라이언";
		first.content = "응 먹고 들어가는중";
		first.sendTime = "오후 12:29";
		
		System.out.println(first);
		System.out.println(first.nickname);
		System.out.println(first.content);
		System.out.println(first.sendTime);
		
		Message second = new Message();
		second.nickname = "초롱초롱 라이언";
		second.content = "오늘은 일찍와?";
		second.sendTime = "오후 12:29";
		
		System.out.println(second);
		System.out.println(second.nickname);
		System.out.println(second.content);
		System.out.println(second.sendTime);
	}
}
