package api.collection2;

import java.util.Objects;

public class Car implements Comparable<Car> {
	private String name;
	private String type;
	private int price;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Car(String name, String type, int price) {
		super();
		this.name = name;
		this.type = type;
		this.price = price;
	}

	@Override
	public String toString() {
		return "Car [name=" + name + ", type=" + type + ", price=" + price + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Car other = (Car) obj;
		return Objects.equals(name, other.name);
	}

	public Car(String name) {
		this(name, null, 0);
	}

	@Override
	public int compareTo(Car o) {
		return this.getName().compareTo(o.getName());
	}

}
