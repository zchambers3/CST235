package controllers;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import beans.Order;
import beans.User;
import business.MyTimerService;
import business.OrdersBusinessInterface;

@ManagedBean
@ViewScoped
public class FormController {

	// This @Inject adds the OrdersBusinessInterface and allows access to its
	// methods concerning Orders
	@Inject
	OrdersBusinessInterface services;

	// This @EJB annotation allows access to the MyTimerService methods allowing
	// creation of timers
	@EJB
	MyTimerService timer;

	

	// This method handles the user flash action on the TestForm login handing a
	// User object to the TestResponse2.xhtml page with the flash command
	public String onFlash(User user) {
		// Set User class to user supplied in argument
		FacesContext.getCurrentInstance().getExternalContext().getFlash().put("user", user);
		// Send to TestResponse2 page
		return "TestResponse2.xhtml";
	}

	// This method gives the ability to access OrdersBusinessService methods through
	// the formController when making JSF pages
	public OrdersBusinessInterface getServices() {
		return services;
	}
	
	// Method to send an Order through JMS message
	public String onSendOrder() {
		// Send test order through JMS message
		services.sendOrder(new Order("01010101", "Added from Message", (float) 89.78, 1));
		return "OrderResponse.xhtml";
	}
	
	// Method to log the current user out of the application
	public String onLogoff() {
		// Invalidate the Session to clear the security token
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
			
		// Redirect to a protected page (so we get a full HTTP Request) to get Login Page
		return "TestResponse.xhtml?faces-redirect=true";

	}
}
