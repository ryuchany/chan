package oop.keyword9;

public class Test01 {
	public static void main(String[] args) {
		Account a = new Account("유재석", 0.3f, 5000000L);
		Account b = new Account("강호동", 0.5f, 3500000L);
		Account c = new Account("유재석", 0.2f, 8000000L);

		// Account.setBasicRate(1.3f); //static-way
		// a.setBasicRate(1.3f); //non static-way

		a.deposit(1000000L);// 100만원 입금(승인)
		b.withdraw(5000000L);// 500만원 출금(거절)
		c.withdraw(5000000L);// 500만원 출금(승인)

		a.showInfo();
		b.showInfo();
		c.showInfo();

	}
}
