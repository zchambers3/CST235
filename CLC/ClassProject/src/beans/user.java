package beans;

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
@ManagedBean(name="user") 
public class user {

	// strings per request
	@NotNull(message = "First name cannot be null")
	@Size(min=5, max=15, message = "First name must be between 5 and 10 characters long.") 
	public String firstName;
	
	@NotNull(message = "Last name cannot be null")
	@Size(min=5, max=15, message = "Last name must be between 5 and 10 characters long.") 
	public String lastName;
	
	@NotNull(message = "Password cannot be null")
	@Size(min=10, max=15, message = "Password must be between 10 and 15 characters long.")
	public String password;
	
	@Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="{invalid.phonenumber}")
	public String phoneNumber;
	
	@NotNull(message = "Email address cannot be null")
	@Email	
	public String email;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

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
	
	
	
}
