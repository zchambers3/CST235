package business;

import java.util.List;

import javax.ejb.Local;

import beans.Order;

@Local
public interface OrdersBusinessInterface {
	// This interface is designed to be implemented by classes that will be working with the Orders objects.
	
	// A method that will be used to test the Interface implementation
	public void test();
	
	// A method to retrieve a List of Order objects
	public List<Order> getOrders();
	
	// Method to send an Order via JMS message
	public void sendOrder(Order order);
}
