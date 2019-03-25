package beans;

import java.util.ArrayList;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List; 

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@SessionScoped 
@ManagedBean(name="Order", eager = true) 
public class OrderBean {
	
	private List<Order> orders;  
	
	@PostConstruct
	public void postConstruct() {
		orders = new ArrayList();		
		orders.add(new Order(1, "Widget", (float) 12.50, 10));
		orders.add(new Order(2, "Widget Pro", (float) 15.00, 5));
		orders.add(new Order(3, "Widget Lite", (float) 10.00, 15));
	}
	
	public ArrayList<Order> getOrders() {
		return (ArrayList<Order>) orders;
	}
}
