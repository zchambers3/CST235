package beans;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@SuppressWarnings("serial")
@XmlRootElement(name = "Order")
public class Order implements Serializable {
	/*
	 * Class to represent an Order object. Made Serializable to support sending via JMS ObjectMessage
	 */
	
	
	// A class that represents an order of something
	private int id = 0;
	private String orderNumber = "";
	private String productName = "";
	private float price = 0;
	private int quantity = 0;

	// Default constructor
	public Order() {
	}

	// A fully loaded constructor
	public Order(String orderNumber, String productName, float price, int quantity) {
		this.orderNumber = orderNumber;
		this.productName = productName;
		this.price = price;
		this.quantity = quantity;
	}

	// A fully loaded constructor
	public Order(int id, String orderNumber, String productName, float price, int quantity) {
		this.id = id;
		this.orderNumber = orderNumber;
		this.productName = productName;
		this.price = price;
		this.quantity = quantity;
	}

	// Getter/Setter methods

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
