package beans;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class OrdersBusinessServiceImpl implements OrdersBusinessInterface {

	private static Map<Integer,Sites> sites = new HashMap<Integer,Sites>();
	
	@Override
	public void test() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Sites> getOrders() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setOrders(List<Sites> sites) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	@Override
	public boolean addSite(Sites thisSite) {
		if(sites.get(thisSite.getId()) != null) return false;
		sites.put(thisSite.getId(), thisSite);
		return true;
	}

	@Override
	public boolean deleteSite(int id) {
		if(sites.get(id) == null) return false;
		sites.remove(id);
		return true;
	}

	@Override
	public Sites getSite(int id) {
		return sites.get(id);
	}

	@Override
	public Sites[] getAllSites() {
		Set<Integer> ids = sites.keySet();
		Sites[] thisSitesList = new Sites[ids.size()];
		int i = 0;
		for(Integer id : ids){
			thisSitesList[i] = (Sites) sites.get(id);
			i++;
		}
		return thisSitesList;
	}
	

}
