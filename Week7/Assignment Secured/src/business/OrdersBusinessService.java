package business;

import java.util.List;

import javax.annotation.Resource;
import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.enterprise.inject.Alternative;
import javax.inject.Inject;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

import beans.Order;
import databases.DataAccessInterface;

//These annotations set this up as a EJB
@Stateless
@Local(OrdersBusinessInterface.class)
@LocalBean
//This allows for multiple version of the OrdersBusiness class
@Alternative
public class OrdersBusinessService implements OrdersBusinessInterface {
	// This class is designed to provide access to an ArrayList of Orders
	
	// Annotations to handle messages
	@Resource(mappedName="java:/ConnectionFactory")
	private ConnectionFactory connectionFactory;
	
	@Resource(mappedName="java:/jms/queue/Order")
	private Queue queue;	
	
	// Inject access to DataAccessInterface methods
	@Inject
	DataAccessInterface service;

	// This is an overridden test method from the interface that prints a
	// identification line to the console.
	@Override
	public void test() {
		System.out.println("Hello from the OrdersBusinessService");
	}

	// Method to provide access to database of orders
	@Override
	public List<Order> getOrders() {
		return service.getOrders();
	}
	
	// Method to send an Order and a Text message via JMS
	@Override
	public void sendOrder(Order order) {
		try 
		{	
			// Create connection to message queue
			Connection connection = connectionFactory.createConnection();
			Session  session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			MessageProducer messageProducer = session.createProducer(queue);
			// Create new text message
			TextMessage message1 = session.createTextMessage();
			// Create new ObjectMessage
			ObjectMessage message2 = session.createObjectMessage();
			// Set ObjectMessage to hold Order
			message2.setObject(order);
			// Set TextMessage to String
			message1.setText("This is test message");
			// Send the messages
			messageProducer.send(message2);
			messageProducer.send(message1);
			// Close Connection
			connection.close();
		} 
		catch (JMSException e) 
		{
			e.printStackTrace();
		}		

	}
}
