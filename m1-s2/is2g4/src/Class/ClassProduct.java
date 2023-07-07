package Class;

public class ClassProduct {
	 
	private long id;
	public String name;
	public String category;
	public double price;
	
	public ClassProduct(String name, String category, double price) {
		super();
		this.name = name;
		this.category = category;
		this.price = price;
	}

	public long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "ClassProduct [name=" + name + ", category=" + category + ", price=" + price + "]";
	}
	
	
}
