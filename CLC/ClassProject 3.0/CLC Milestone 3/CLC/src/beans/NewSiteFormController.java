package beans;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import NewSite;

@ManagedBean
public class NewSiteFormController {

	public String newSite(){
		FacesContext context = FacesContext.getCurrentInstance();
		NewSite newSite = context.getApplication().evaluateExpressionGet(context, "#{NewSite}", NewSite.class);
		FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("NewSite", newSite);
		return "NewSiteRegister.xhtml";
	}
}
