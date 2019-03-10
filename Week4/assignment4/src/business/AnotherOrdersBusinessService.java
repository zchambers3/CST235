package business;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.enterprise.inject.Alternative;

import beans.Order;

@Stateless
@Local(OrdersBusinessInterface.class)
@Alternative
public class AnotherOrdersBusinessService implements OrdersBusinessInterface {

	List<Order> orders = new ArrayList<Order>();
	
	@Override
	public void test() {
		// TODO Auto-generated method stub
		System.out.println("Hello from the test method. Another Order Business Service Version");
	}

	public AnotherOrdersBusinessService() {
		orders.add(new Order("A", "Zeus", (float)1.00, 1));
		orders.add(new Order("B", "Hera", (float)1.10, 1));
		orders.add(new Order("C", "Poseidon", (float)0.90, 1));
		orders.add(new Order("D", "Demeter", (float)11.00, 1));
		orders.add(new Order("E", "Ares", (float)10.00, 1));
		orders.add(new Order("F", "Athena", (float)20.00, 1));
		
	}

	@Override
	public List<Order> getOrders() {
		// TODO Auto-generated method stub
		return orders;
	}

	@Override
	public void setOrders(List<Order> orders) {
		// TODO Auto-generated method stub
		this.orders = orders;
	}
}