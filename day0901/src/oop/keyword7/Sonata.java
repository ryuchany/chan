package oop.keyword7;
//자동차 클래스
public class Sonata {
	private static String company;// 제조사(일괄 처리 데이터)

	public static String getCompany() {
		return company;
	}
	public static void setCompany(String company) {
		Sonata.company = company;
	}

	private String color;//색상
	private int price;//가격

	public Sonata(String company, String color, int price) {
		//this.company = company;//경고(주인공 것이 아님)
		Sonata.company = company;
		this.color = color;
		this.price = price;
	}

	@Override
	public String toString() {
		return "Sonata [company=" + company + ", color=" + color + ", price=" + price + "]";
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
