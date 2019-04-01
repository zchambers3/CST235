package business;

import java.util.List;

import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebService;

import beans.Order;

@WebService()
public class OrdersSoapService {
	
	// Provide access to OrdersBusinessInterface methods
	@Inject
	OrdersBusinessInterface service;
	
	// Web Method to return all orders for SOAP web service
	@WebMethod
	public List<Order> getOrders(){
		return service.getOrders();
	}
	
	// Test web method for SOAP web service. Returns hello and name
	@WebMethod()
	public String sayHello(String name) {
	    System.out.println("Hello: " + name);
	    return "Hello " + name + "!";
	}
}
