package Main;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import Class.*;

public class MainProg  {
	
	public static Logger log = LoggerFactory.getLogger(MainProg.class);
	
	public static List<ClassProduct> productList = new ArrayList<ClassProduct>();
	public static List<ClassOrder> orderList = new ArrayList<ClassOrder>();
	public static List<ClassCustomer> customerList = new ArrayList<ClassCustomer>();

	public static void main(String[] args) {
	
		productList.add(new ClassProduct("Il cognome delle donne", "Books", 20.00));
		productList.add(new ClassProduct("Ugly Love. Ediz.italiana", "Books", 200.00));
		productList.add(new ClassProduct("La Famiglia!", "Books", 40.00));
		productList.add(new ClassProduct("Tanto si muore soli...", "Books", 110.50));
		productList.add(new ClassProduct("Il brutto anatroccolo", "Baby", 10.00));
		productList.add(new ClassProduct("I musicanti", "Baby", 8.70));
		productList.add(new ClassProduct("Bicicletta", "Boys", 310.00));
		productList.add(new ClassProduct("Divisa da calcio", "Boys", 15.99));
		
		orderList.add(new ClassOrder(0, "Ready", orderDate, deliveryDate, productList));
		orderList.add(new ClassOrder(1, "Not Ready", orderDate, deliveryDate, productList));
		orderList.add(new ClassOrder(2, "Not Ready", orderDate, deliveryDate, productList));
		
		List <ClassProduct> bookFilter = productList.stream()
								.filter(ele -> ele.price>100)
								.filter(ele -> ele.category == "Books")
								.collect(Collectors.toList());
		bookFilter.forEach(e -> System.out.println(e.toString()));
		
	}
}
