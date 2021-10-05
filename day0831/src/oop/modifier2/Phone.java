package oop.modifier2;

public class Phone {

	private String name;
	private String service;
	private int period;
	private int money;

	// 세터 메소드

	void setName(String name) {
		this.name = name;
	}

	void setService(String service) {
		switch (service) {
		case "SKT":
		case "KT":
		case "LGuplus":
		case "알뜰폰":
			this.service = service;
		}
	}

	void setPeriod(int period) {
		if (!(period == 24 || period == 30 || period == 36)) {
			return;
		}
		this.period = period;
	}

	void setMoney(int money) {
		if (money < 0) {
			return;
		}
		this.money = money;
	}

	// 게터 메소드
	String getName() {
		return this.name;
	}

	String getService() {
		return this.service;
	}

	int getPeriod() {
		return this.period;
	}

	int getMoney() {
		return this.money;
	}

	public void init(String name, String service, int period, int money) {
		this.setName(name);
		this.setService(service);
		this.setPeriod(period);
		this.setMoney(money);
	}

	// 출력
	public void showInfo() {
		System.out.println("<휴대폰 정보>");
		System.out.println("기종 : " + this.name);
		System.out.println("통신사 : " + this.service);
		System.out.println("약정기간 : " + this.getPeriod() + "개월");
		System.out.println("할부원금 : " + this.getMoney() + "원");
	}

}
