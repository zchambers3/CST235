package beans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@SessionScoped 
@ManagedBean(name="UserBean", eager = true) 

public class UserBean {

	private List<User> users;  
		
	
	public ArrayList<User> getUsers() {
		return (ArrayList<User>) users;
	}
	
}
