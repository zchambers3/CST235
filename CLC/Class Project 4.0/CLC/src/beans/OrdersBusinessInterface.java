package beans;

import java.util.List;

import javax.ejb.Local;

import beans.NewSite;;

@Local
public interface OrdersBusinessInterface {
	public void test();
	public List<Sites> getOrders();
	public void setOrders(List<Sites> sites);
}
