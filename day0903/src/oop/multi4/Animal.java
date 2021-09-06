package oop.multi4;

public abstract class Animal {
	protected String name;
	protected int age;

	public Animal(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public abstract void lookAt();

	public void showInfo() {
		System.out.println("<동물 정보>");
		System.out.println("품종 : "+name);
		System.out.println("나이 : "+age);
	}
}
