package api.collection;

public class Product {

	private String name;
	private String goods;
	private int price;
	private int inventory;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGoods() {
		return goods;
	}

	public void setGoods(String goods) {
		this.goods = goods;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getInventory() {
		return inventory;
	}

	public void setInventory(int inventory) {
		if (inventory >= 0) {
			this.inventory = inventory;
		}
	}

	public Product(String name, String goods, int price, int inventory) {
		super();
		this.name = name;
		this.goods = goods;
		this.price = price;
		this.inventory = inventory;
	}

	@Override
	public String toString() {
		return "Product [name=" + name + ", goods=" + goods + ", price=" + price + ", inventory=" + inventory + "]";
	}

	public void minus() {
		this.inventory--;
	}

}
