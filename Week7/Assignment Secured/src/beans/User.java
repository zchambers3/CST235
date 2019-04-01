package beans; 

import java.security.Principal;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@ManagedBean
@SessionScoped
public class User {
	//A class that represents a user of the application
	
	// Strings to contain first and last name of user
	@NotNull()
	@Size(min=5, max=15)
	private String firstName;
	@NotNull()
	@Size(min=5, max=15)
	private String lastName;

	// Default constructor with my name
	public User() {
		firstName = "Zack";
		lastName = "Chambers";
	}
	
	// Method created after the bean is initialized
	@PostConstruct
	public void init() {
		// Get the logged in Principle and set the user name to the logged in user
		Principal principle= FacesContext.getCurrentInstance().getExternalContext().getUserPrincipal();
			if(principle == null)
			{
				setFirstName("Unknown");
				setLastName("");
			}
			else
			{
				setFirstName(principle.getName());
				setLastName("");
			}

	}

	// Getter and Setter methods
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
}