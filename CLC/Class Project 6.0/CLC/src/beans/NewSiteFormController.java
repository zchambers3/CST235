package beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import beans.NewSite;;


@SessionScoped
@ManagedBean(name="NewSiteFormController")
public class NewSiteFormController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static List<Sites> accessList =  new ArrayList<Sites>();
	
	public static int arraySize;
	public String siteID;
	public String siteName;
	public String siteColor;

	public void newSite(Sites thisSite){
		FacesContext ctx = FacesContext.getCurrentInstance();
		String returnValue = ctx.getExternalContext().getRequestContextPath();
		ctx.getExternalContext().getFlash().put("Sites", (thisSite.id + " " + thisSite.name + " " + thisSite.color));
		System.out.println("Writing id " + thisSite.id);
		System.out.println("Writing id " + Integer.toString(thisSite.id));
		accessList.add(new Sites(Integer.toString(thisSite.id), thisSite.name, thisSite.color));
		System.out.print("Total Sites = ");
		System.out.println(accessList.size());
		// return "NewSiteRegister.xhtml";
	}

	public String getSiteID() {
		return siteID;
	}

	public void setSiteID(String siteID) {
		this.siteID = siteID;
	}

	public String getSiteName() {
		return siteName;
	}

	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}

	public String getSiteColor() {
		return siteColor;
	}

	public void setSiteColor(String siteColor) {
		this.siteColor = siteColor;
	}

	public static int getArraySize() {
		return accessList.size();
	}

	public void setArraySize(int arraySize) {
		// this.arraySize = arraySize;
	}

	public static Sites get(int counter) {
		Sites tempSite;
		tempSite = accessList.get(counter);
		return tempSite;
	}
	
	
	
	
	
}
