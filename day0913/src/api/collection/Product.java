package api.collection;

import java.util.Objects;

public class Product {
	// 멤버 변수 : 상품이름, 상품분류, 판매가격, 상품재고
	private String name;
	private String type;
	private int price;
	private int stock;

	// 멤버 메소드 : setter , getter , 판매 , 판매가능여부 확인
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
		if (price < 0) {
			return;
		}
		this.price = price;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		if (stock < 0) {
			return;
		}
		this.stock = stock;
	}

	// 생성자 : 상품이름 + 상품분류 ( + 판매가격 ) ( + 상품재고 )
	public Product(String name, String type) {
		this(name, type, 0, 0);
	}

	public Product(String name, String type, int price) {
		this(name, type, price, 0);
	}

	public Product(String name, String type, int price, int stock) {
		this.setName(name);
		this.setType(type);
		this.setPrice(price);
		this.setStock(stock);
	}

	@Override
	public String toString() {
		return "Product [name=" + name + ", type=" + type + ", price=" + price + ", stock=" + stock + "]";
	}

	// 재고 감소(판매) 기능
	public boolean sell() {
		if (this.isSellable()) {
			this.stock--;
			return true;
		} else {
			return false;
		}
	}

	public boolean isSellable() {
//		if(this.stock > 0) {
//			return true;
//		}
//		else {
//			return false;
//		}
		return this.stock > 0;
	}

	public Product(String name) {
		super();
		this.name = name;
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
		Product other = (Product) obj;
		return Objects.equals(name, other.name);
	}

	// 매출액을 클래스레벨에서 관리(탈객체)
	private static long total = 0L;

	public static long getTotal() {
		return total;
	}

	public static void addTotal(int price) {
		total += price;
	}
}
