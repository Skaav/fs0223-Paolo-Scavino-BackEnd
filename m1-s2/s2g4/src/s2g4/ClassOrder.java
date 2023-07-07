package s2g4;

import java.time.LocalDate;
import java.util.List;

public class ClassOrder {

	private Long id;
	protected String status;
	protected LocalDate orderDate;
	protected LocalDate deliveryDate;
	protected List<ClassProduct> products;
	protected ClassCustomer customer;
	
	public ClassOrder(String status, LocalDate orderDate, LocalDate deliveryDate, List<ClassProduct> products,
			ClassCustomer customer) {
		super();
		this.status = status;
		this.orderDate = orderDate;
		this.deliveryDate = deliveryDate;
		this.products = products;
		this.customer = customer;
	}

	public Long getId() {
		return id;
	}

}
