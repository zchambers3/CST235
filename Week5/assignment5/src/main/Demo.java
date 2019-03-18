package main;

import java.sql.SQLException;
import java.util.ArrayList;

import beans.BeautifulThing;
import database.DatabaseService;

public class Demo {

	public static void main(String[] args) throws SQLException {
		DatabaseService ds = new DatabaseService();
		BeautifulThing b = new BeautifulThing(0, "puppies", "Puppies!!!", 10); 
		ArrayList<BeautifulThing> bList = new ArrayList<BeautifulThing>();
		ds.insertOne(b);
		ds.deleteOne(4);
		
		bList = ds.readAll();
		
		System.out.println("===========");
		for(BeautifulThing bt : bList){
			System.out.println("ID: " + bt.getId() 
					+ " title: " + bt.getThingTitle()
					+ " Desc: " + bt.getThingDescription()
					+ " Rating: " + bt.getRating());
			
		}
		System.out.println("End of the List ===========");
		
		b= new BeautifulThing(0, "freshly mowed grass", "Spring is the best!!!", 0);
		ds.updateOne(7, b);
		
	}

}
