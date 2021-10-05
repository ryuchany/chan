package oop.inherit8;

//추상(abstract) 클래스 : 
//상속관계에서 추상적인 상위클래스를 효율적으로 표현하도록 만들어진 클래스
//= 추상(abstract) 메소드를 가질 수 있다.
//= 객체 생성이 불가능
public abstract class Phone {
	protected String number;
	protected String color;

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Phone (String color) {
		this(null, color);
	}
	
	public Phone (String number, String color ) {
		this.setNumber(number);
		this.setColor(color);
	}
	
	//추상 메소드 :
	//= 형태만 있고 코드가 없는 메소드
	//= 추상클래에서만 생성 가능
	public abstract void call();
	public abstract void sms();
}








