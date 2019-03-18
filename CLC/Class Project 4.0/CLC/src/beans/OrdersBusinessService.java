package beans;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.enterprise.inject.Alternative;

import beans.NewSite;;

@Stateless
@Local(OrdersBusinessInterface.class)
@Alternative
public class OrdersBusinessService implements OrdersBusinessInterface {

	List<Sites> sites = new ArrayList<Sites>();
	
	@Override
	public void test() {
		System.out.println("Printing from @OrdersBusinessService test method");
	}

	public OrdersBusinessService(){
		sites.add(new Sites((int)1,"Zeus Suite", "Orange"));
		sites.add(new Sites((int)2,"Hera Suite", "Black"));
		sites.add(new Sites((int)4,"Demeter Suite", "White with Black Spots"));
		sites.add(new Sites((int)5,"Ares Suite", "Black"));
		sites.add(new Sites((int)6,"Athena Suite", "Black"));
		
	}
	
	@Override
	public List<Sites> getOrders() {
		// TODO Auto-generated method stub
		return sites;
	}

	@Override
	public void setOrders(List<Sites> sites) {
		// TODO Auto-generated method stub
		this.sites = sites;
	}

}
