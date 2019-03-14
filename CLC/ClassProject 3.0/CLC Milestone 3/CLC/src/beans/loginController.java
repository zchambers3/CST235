package beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ViewScoped 
@ManagedBean(name = "loginController")
public class loginController {

	public String onFlash (user user) {		
		FacesContext ctx = FacesContext.getCurrentInstance();
		String returnValue = ctx.getExternalContext().getRequestContextPath();
		ctx.getExternalContext().getFlash().put("user", (user.firstName + " " + user.lastName));		
		return "NewSiteResponse.xhtml?faces-redirect=true";
	}
	
	
}
