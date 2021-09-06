package oop.multi5;

public abstract class Grocery extends Product {
	protected String expire;

	public void setExpire(String expire) {
		this.expire = expire;
	}

	public String getExpire() {
		return expire;
	}

	public Grocery(String name, String expire) {
		super(name);
		this.setExpire(expire);
	}
}