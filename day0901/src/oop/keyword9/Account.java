package oop.keyword9;

public class Account {
	// 정적데이터 - static 변수
	private static float basicRate = 1.2f;

	public static void setBasicRate(float basicRate) {
		Account.basicRate = basicRate;
	}

	public static float getBasicRate() {
		return Account.basicRate;
	}

	// 동적데이터 - 멤버 변수
	private String name;
	private float advancedRate;
	private long balance;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getAdvancedRate() {
		return advancedRate;
	}

	public void setAdvancedRate(float advancedRate) {
		this.advancedRate = advancedRate;
	}

	public long getBalance() {
		return balance;
	}

	public void setBalance(long balance) {
		this.balance = balance;
	}

	// 생성자 : static을 고려할 필요가 없다.
	public Account(String name) {
		this(name, 0f, 0L);
	}

	public Account(String name, float advancedRate) {
		this(name, advancedRate, 0L);
	}

	public Account(String name, float advancedRate, long balance) {
		this.setName(name);
		this.setAdvancedRate(advancedRate);
		this.setBalance(balance);
	}

	public void showInfo() {
		System.out.println("<계좌 정보>");
		System.out.println("소유자 : " + name); // this.name
		System.out.println("기본이율 : " + basicRate + "%"); // this.basicRate
		System.out.println("우대이율이율 : " + advancedRate + "%"); // this.advancedRate
		System.out.println("예금잔액 : " + balance); // this.balance

	}

	// 원한다면 부가적인 기능들을 얼마든지 추가할 수 있다.
	public void deposit(long money) { // 입금
		if (money <= 0) {
			return;
		}
		this.balance += money;
	}

	public void withdraw(long money) { // 출금
		if (this.balance < money) {
			return;
		}
		this.balance -= money;
	}
}
