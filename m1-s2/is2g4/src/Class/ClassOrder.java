package Class;

import java.time.LocalDate;
import java.util.List;

public class ClassOrder {

	public long id;
	public String status;
	public LocalDate orderDate;
	public LocalDate deliveryDate;
	public List<ClassProduct> products;
	public List<ClassCustomer> customer;
	
	public ClassOrder(long id, String status, LocalDate orderDate, LocalDate deliveryDate, List<ClassProduct> products) {
		super();
		this.id = id;
		this.status = status;
		this.orderDate = orderDate;
		this.deliveryDate = deliveryDate;
		this.products = products;
	}

	public long getId() {
		return id;
	}
}
