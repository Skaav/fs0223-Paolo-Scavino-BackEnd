package s2g4;

public class ClassProduct {
	 
	private Long id;
	protected String name;
	protected String category;
	protected double price;
	
	public ClassProduct(String name, String category, double price) {
		super();
		this.name = name;
		this.category = category;
		this.price = price;
	}

	public Long getId() {
		return id;
	}
	
	
	
}
