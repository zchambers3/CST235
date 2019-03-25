package beans;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.validation.*;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;


@SessionScoped 
@ManagedBean(name="User", eager = true) 


public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// strings per request
	@NotNull(message = "First name cannot be null")
	@Size(min=3, max=15, message = "First name must be between 3 and 15 characters long.") 
	public String firstName;
	
	@NotNull(message = "Last name cannot be null")
	@Size(min=3, max=15, message = "Last name must be between 3 and 15 characters long.") 
	public String lastName;
	
	public String password;
	@NotNull(message = "Password cannot be null")
	@Size(min=10, max=15, message = "Last name must be between 10 and 15 characters long.")
	
	@Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="{invalid.phonenumber}")
	public String phoneNumber;
	
	@NotNull(message = "Email address cannot be null")
	@Email
	
	public String email;
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getFirstName() {
		return firstName;
		//return "first";
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
		// return "last";
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public void User() {
		this.firstName = "Test";
		this.lastName = "Default";
		this.email = "Default@test.org";
		this.phoneNumber = "555-555-5555";
		this.password = "password";
	}
	
	public void user() {
		this.firstName = "Test";
		this.lastName = "Default";
		this.email = "Default@test.org";
		this.phoneNumber = "555-555-5555";
		this.password = "password";
	}
	
	public void User(String thisFirstName, String thisLastName, String thisEmail, String thisPhoneNumber, String thisPassword) {
		setFirstName(thisFirstName);
		setLastName(thisLastName);
		setEmail(thisEmail);
		setPhoneNumber(thisPhoneNumber);
		setPassword(thisPassword);
	}
	
	public void user(String thisFirstName, String thisLastName, String thisEmail, String thisPhoneNumber, String thisPassword) {
		setFirstName(thisFirstName);
		setLastName(thisLastName);
		setEmail(thisEmail);
		setPhoneNumber(thisPhoneNumber);
		setPassword(thisPassword);
	}
	
}
