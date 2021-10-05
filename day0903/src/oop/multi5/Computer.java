package oop.multi5;

public class Computer extends Electronic implements Brokenable {

	public Computer(String name) {
		super(name);
	}

	@Override
	public void on() {
		System.out.println(this.name + " 전원이 켜집니다");
	}

	@Override
	public void off() {
		System.out.println(this.name + " 전원이 꺼집니다");
	}

}
