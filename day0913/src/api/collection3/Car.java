package api.collection3;

public class Car {
	private String name;
	private int people;
	private int price;
	private boolean rental; // 대여 가능한 상태면 true , 대여중이면 false

	public boolean isRental() {
		return rental;
	}

	public void setRental(boolean rental) {
		this.rental = rental;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPeople() {
		return people;
	}

	public void setPeople(int people) {
		this.people = people;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		if (price < 0) {
			return;
		}
		this.price = price;
	}

	@Override
	public String toString() {
		return "Car [name=" + name + ", people=" + people + ", price=" + price + ", rental=" + rental + "]";
	}

	public Car(String name, int people, int price) {
		this.setName(name);
		this.setPeople(people);
		this.setPrice(price);
		this.rental = true;
	}

	public Car(String name, int people) {
		this(name, people, 0);
	}

	public void rentEnd() {
		rental = true;
	}

	public void rentStart() {
		rental = false;
	}
}
