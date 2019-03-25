package beans;

import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@SessionScoped 
@ManagedBean(name = "FormController")

public class FormController {

	public String onSubmit (User user) {
		FacesContext ctx = FacesContext.getCurrentInstance();
		String returnValue = ctx.getExternalContext().getRequestContextPath();
		// FacesContext.this.SetAttribute
		ctx.getExternalContext().getRequestMap().put("user", (user.firstName + " " + user.lastName));
		return returnValue;
	}
	
	public String onFlash (User user) {		
		FacesContext ctx = FacesContext.getCurrentInstance();
		String returnValue = ctx.getExternalContext().getRequestContextPath();
		ctx.getExternalContext().getFlash().put("user", (user.firstName + " " + user.lastName));		
		return "registered.xhtml?faces-redirect=true";
	}
	
	
}
