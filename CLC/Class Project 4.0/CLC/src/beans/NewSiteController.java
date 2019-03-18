package beans;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class NewSiteController {

	public String newSite(){	
		System.out.println("You hit the new Site button #1");
		return "NewSiteResponse.xhtml";
	}
}
