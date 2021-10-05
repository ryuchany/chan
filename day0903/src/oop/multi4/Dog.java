package oop.multi4;

//강아지의 특성(행동)
//- 동물						<---> 식물 , 무생물
//- 육지						<---> 비행, 수중
//- 짖을 수 있는 동물
public class Dog extends Animal implements Walkable, Barkable{

	public Dog(String name, int age) {
		super(name, age);
	}

	@Override
	public void bark() {
		System.out.println("멍멍!");
	}

	@Override
	public void walk() {
		System.out.println("강아지가 걸어갑니다!");
	}

	@Override
	public void lookAt() {
		System.out.println("강아지가 당신을 쳐다봅니다");
	}

}
