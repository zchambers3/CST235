package beans;
import java.io.Serializable;
import java.util.*;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.validation.*;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;



@SessionScoped 
@ManagedBean
public class Order implements Serializable {
	
	
	/**
	 * 
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	private int orderNumber;
	private String productName;
	private float price;
	private int quantity;
	
	public Order(int thisOrderNumber, String thisProductName, float thisPrice, int thisQuantity) {
		setOrderNumber(thisOrderNumber);
		setProductName(thisProductName);
		setPrice(thisPrice);
		setQuantity(thisQuantity);				
	}
				
	public Order() {
		setOrderNumber(0);
		setProductName("default");
		setPrice((float) 1.00);
		setQuantity(1);				
	}
	
	
	public int getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(int orderNumber) {
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
	
}
