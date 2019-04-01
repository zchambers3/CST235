package beans;





import java.util.List;

import javax.ejb.Local;

import beans.NewSite;;

@Local
public interface OrdersBusinessInterface {
	public void test();
	public List<Sites> getOrders();
	public void setOrders(List<Sites> sites);
	public boolean addSite(Sites thisSite);
	public boolean deleteSite(int id);
	public Sites getSite(int id);
	public Sites[] getAllSites();
}
