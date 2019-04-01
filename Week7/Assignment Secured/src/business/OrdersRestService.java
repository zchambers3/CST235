package business;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import beans.Order;

@RequestScoped
@Path("/orders")
@Produces({ "application/xml", "application/json" })
@Consumes({ "application/xml", "application/json" })
public class OrdersRestService {
	
	// Provide access to OrdersBusinessInterface methods
	@Inject
	OrdersBusinessInterface service;
	
	// Method to provide all orders in JSON format
	@GET
	@Path("/getjson")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Order> getOrdersAsJson(){
		return service.getOrders();
	}
	
	// Method to provide all orders in XML format
	@GET
	@Path("/getxml")
	@Produces(MediaType.APPLICATION_XML)
	public Order[] getOrdersAsXML(){
		// Return Orders List and Cast it as Array
		return service.getOrders().toArray(new Order[service.getOrders().size()]);
	}
}
