package beans;

import java.util.ArrayList;

public class BeautifulThings {
	ArrayList<BeautifulThing> theList = new ArrayList<BeautifulThing>();
	public void add(BeautifulThing bt){
		theList.add(bt);
	}
	public void printAll(){
		System.out.println("=======");
		for(BeautifulThing bt : theList){
			System.out.println("ID: " + bt.id 
					+ " Title: " + bt.thingTitle
					+ " Desc: " + bt.thingDescription
					+ " Rating: " + bt.rating);
		}
		System.out.println("=====END====");
	}
	

}
