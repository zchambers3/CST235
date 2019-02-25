package beans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class Orders {
	List <Order> orders = new ArrayList<Order>();
	
	public Orders(){
		orders.add(new Order("000", "Gorg", (float)1.00, 1));
		orders.add(new Order("001", "Shadow", (float)1.10, 1));
		orders.add(new Order("002", "Zeus", (float)0.90, 1));
		orders.add(new Order("003", "Prometheus", (float)11.00, 1));
		orders.add(new Order("004", "Alchemist", (float)10.00, 1));
		orders.add(new Order("005", "Mako", (float)20.00, 1));
		
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
	
}