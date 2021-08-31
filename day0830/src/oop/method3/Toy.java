package oop.method3;

public class Toy {
	String name;
	int price;

	void init(String name, int price) {
		// setName 메소드 실행해!
		this.setName(name);
		this.setPrice(price);
	}

	void showInfo() {
		System.out.println("이름 : " + this.name);
		System.out.println("가격 : " + this.price + "원");
	}

//정보는 언제든지 바뀔 수 있다
//= 전체가 아닌 하나씩 변경할 수 있도록 메소드를 준비
//= 세터 메소드(setter method)
//= 설정 전용 메소드
//= 변수명을 이용해서 메소드 이름을 구성
//= set + 변수명 으로 메소드 이름을 작성
//= set + name 이면 setName 이라고 이름지어진다
//= 조건을 추가하여 "원하는 값"만 설정
	void setName(String name) {
		this.name = name;
	}

	void setPrice(int price) {
//	if(올바른 가격이라면) {
		if (price >= 0) {
			this.price = price;
		}
	}

}