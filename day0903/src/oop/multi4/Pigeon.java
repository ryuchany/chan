package oop.multi4;

public class Pigeon extends Animal implements Walkable, Flyable, Barkable{

	public Pigeon(String name, int age) {
		super(name, age);
	}

	@Override
	public void bark() {
		System.out.println("구구..구구...구구...81");
	}

	@Override
	public void fly() {
		System.out.println("비둘기가 날라갑니다");
	}

	@Override
	public void walk() {
		System.out.println("비둘기가 걸어갑니다");
	}

	@Override
	public void lookAt() {
		System.out.println("비둘기가 당신을 쳐다봅니다");
	}

}
