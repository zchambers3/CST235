package databases;

import java.util.List;

import beans.Order;


public interface DataAccessInterface {
	// Interface methods for accessing database
	
	// Return all orders from database
	public List<Order> getOrders();
	
	// Insert orders into database
	public void insertOrder(Order order);
}
