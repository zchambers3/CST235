package business;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import javax.jms.TextMessage;

import beans.Order;
import databases.DataAccessInterface;

/**
 * Message-Driven Bean implementation class for: OrderMessageService
 */
@MessageDriven(activationConfig = {
		@ActivationConfigProperty(propertyName = "destination", propertyValue = "java:/jms/queue/Order"),
		@ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue") }, mappedName = "java:/jms/queue/Order")
public class OrderMessageService implements MessageListener {
	/*
	 * Class to handle sending Orders via JMS message
	 */

	// EJB annotation to access DataAccessInterface methods
	@EJB
	DataAccessInterface service;

	/**
	 * Default constructor.
	 */
	public OrderMessageService() {
		// TODO Auto-generated constructor stub
	}

	/*
	 * Method to handle JMS messages.
	 */
	public void onMessage(Message message) {
		/*
		 * If statement to check if message is an ObjectMessage.
		 */
		if (message instanceof ObjectMessage) {
			try {
				// Set ObjectMessage object to order
				Order order = (Order) ((ObjectMessage) message).getObject();
				// Send order to be inserted into database
				service.insertOrder(order);
			} catch (JMSException e) {
				// Print to console if not a ObjectMessage
				System.out.println("Not a ObjectMessage");
				e.printStackTrace();
			}
		}
		/*
		 * If statement to check if message is a TextMessage
		 */
		if (message instanceof TextMessage) {
			try {
				// Send message to console
				System.out.println(((TextMessage) message).getText());
			} catch (JMSException e) {
				// Print to console if not a text message
				System.out.println("Not a text message");
				e.printStackTrace();
			}
		}

	}

}
