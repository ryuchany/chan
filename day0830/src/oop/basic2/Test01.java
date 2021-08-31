package oop.basic2;

import oop.basic2.Country;

public class Test01 {
	public static void main(String[] args) {
		//올림픽 4개국 메달 정보를 구현
		//= Country 객체 4개 생성 후 초기화 및 출력

		Country a = new Country();

		a.name = "미국";
		a.gold = 39;
		a.silver = 41;
		a.bronze = 33;
		a.rank = 1;

		System.out.println("이름 : "+a.name);
		System.out.println("금메달 : "+a.gold);
		System.out.println("은메달 : "+a.silver);
		System.out.println("동메달 : "+a.bronze);
		System.out.println("순위 : "+a.rank);

		Country b = new Country();

		b.name = "중국";
		b.gold = 38;
		b.silver = 32;
		b.bronze = 18;
		b.rank = 2;

		System.out.println("이름 : "+b.name);
		System.out.println("금메달 : "+b.gold);
		System.out.println("은메달 : "+b.silver);
		System.out.println("동메달 : "+b.bronze);
		System.out.println("순위 : "+b.rank);

		Country c = new Country();

		c.name = "일본";
		c.gold = 27;
		c.silver = 14;
		c.bronze = 17;
		c.rank = 3;

		System.out.println("이름 : "+c.name);
		System.out.println("금메달 : "+c.gold);
		System.out.println("은메달 : "+c.silver);
		System.out.println("동메달 : "+c.bronze);
		System.out.println("순위 : "+c.rank);

		Country d = new Country();

		d.name = "영국";
		d.gold = 22;
		d.silver = 21;
		d.bronze = 22;
		d.rank = 4;

		System.out.println("이름 : "+d.name);
		System.out.println("금메달 : "+d.gold);
		System.out.println("은메달 : "+d.silver);
		System.out.println("동메달 : "+d.bronze);
		System.out.println("순위 : "+d.rank);
	}
}
