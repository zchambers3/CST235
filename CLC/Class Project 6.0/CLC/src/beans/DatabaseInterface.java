package beans;

import java.util.ArrayList;

import javax.ejb.Local;

import beans.NewSite;

@Local
public interface DatabaseInterface {
	public int deleteOne(int d);
	public int insertOne(NewSite b);
	public ArrayList<NewSite> readAll();
	public int updateOne(int d, NewSite b);
	public NewSite getThingById(int thingnumber);
	public ArrayList<NewSite> searchByName(String searchname);
}