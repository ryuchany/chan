package oop.keyword6;


//자동차 클래스
public class Sonata {
	private String company;//제조사
	private String color;//색상
	private int price;//가격

	public Sonata(String company, String color, int price) {
		this.company = company;
		this.color = color;
		this.price = price;
	}

	@Override
	public String toString() {
		return "Sonata [company=" + company + ", color=" + color + ", price=" + price + "]";
	}

	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}

}
