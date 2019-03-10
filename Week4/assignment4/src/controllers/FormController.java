package controllers;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import beans.User;
import business.MyTimerService;
import business.OrdersBusinessInterface;

@ManagedBean
@ViewScoped
public class FormController {
	@Inject
	OrdersBusinessInterface services;
	
	@EJB
	MyTimerService timer;
	
	public String onSubmit(){
		
		//get the user values from the input form
		FacesContext context = FacesContext.getCurrentInstance();
		User user = context.getApplication().evaluateExpressionGet(context, "#{user}", User.class);
		
		//prints message to console to let us know which business services is selected
		services.test();
		
		//start a timer when login is clicked (for programmatic timer)
		timer.setTimer(10000);
		
		//put the user object into the POST request
		FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("user", user);
		
		//show the next page
		return "Response.xhtml";
	}
	
	public OrdersBusinessInterface getService() {
		return services;
	}
}