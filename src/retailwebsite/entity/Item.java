package retailwebsite.entity;

public class Item {

	private final int id;
	private String name;
	private float price;
	private boolean groceries;
	
	private Item(int id, String name, float price, boolean groceries) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.groceries = groceries;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getId() {
		return id;
	}
	
	public boolean isGroceries() {
		return groceries;
	}

	public void setGroceries(boolean groceries) {
		this.groceries = groceries;
	}

	@Override
	public String toString() {
		return "Goods [id=" + id + ", name=" + name + ", price=" + price + ", groceries=" + groceries + "]";
	}

	public static class Builder {
		
		private int id;
		private String name;
		private float price;
		private boolean groceries;

		public Builder id(int id) {
			this.id = id;
			return this;
		}
		
		public Builder name(String name) {
			this.name = name;
			return this;
		}
		
		public Builder price(float price) {
			this.price = price;
			return this;
		}
		
		public Builder groceries(boolean groceries) {
			this.groceries = groceries;
			return this;
		}
		
		public Item build() {
			return new Item(id, name, price, groceries);
		}
	}
}
