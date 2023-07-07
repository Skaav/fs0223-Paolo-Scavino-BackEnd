package s2g4;

public class ClassCustomer {
	private Long id;
	protected String name;
	protected int tier;
	
	public ClassCustomer(String name, int tier) {
		super();
		this.name = name;
		this.tier = tier;
	}

	public Long getId() {
		return id;
	}
	
}
