package oop.multi4;

public class Test01 {
	public static void main(String[] args) {
		//강아지 한 마리 생성
		Dog dog = new Dog("말티즈", 7);
		//Animal dog = new Dog("말티즈", 7);
		dog.walk();
		dog.bark();

		//Q : dog는 날아다닐 수 있습니까?
		//= Dog 클래스가 Flyable 클래스의 자식 클래스입니까?
		//= instanceof 연산자를 이용하면 상속관계인지 검사를 할 수 있다
		System.out.println(dog instanceof Dog);//dog는 Dog 클래스의 구현체입니까?
		System.out.println(dog instanceof Flyable);//dog는 Flyable 클래스의 구현체입니까?
		System.out.println(dog instanceof Walkable);//dog는 Walkable 클래스의 구현체입니까?

//		if(날아다닐 수 있다면) {
		if(dog instanceof Flyable) {
			System.out.println("날아다닐 수 있습니다");
		}
		else {
			System.out.println("날아다닐 수 없습니다");
		}

//		Q : 비둘기 객체를 만들고 비둘기가 짖을 수 있는지 판정하여 출력
		Pigeon p = new Pigeon("비둘기", 2);
		if(p instanceof Animal) {
			System.out.println(p.name + " : 동물입니다");
		}
		else {
			System.out.println(p.name + " : 동물이 아닙니다");
		}

		if(p instanceof Barkable) {
			System.out.println(p.name + " : 짖을 수 있습니다");
			p.bark();
		}
		else {
			System.out.println(p.name + " : 짖을 수 없습니다");
		}
	}
}
