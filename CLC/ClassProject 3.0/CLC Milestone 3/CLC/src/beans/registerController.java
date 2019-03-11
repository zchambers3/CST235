package beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;


@ViewScoped 
@ManagedBean(name = "registerController")
public class registerController {

	public String onFlash (user user) {		
		FacesContext ctx = FacesContext.getCurrentInstance();
		String returnValue = ctx.getExternalContext().getRequestContextPath();
		ctx.getExternalContext().getFlash().put("user", (user.firstName + " " + user.lastName));				
		return "registered.xhtml?faces-redirect=true";
	}
	
}
