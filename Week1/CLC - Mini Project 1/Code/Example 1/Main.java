package clcAssignment1;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		readWriteExample();
		
	}
	private static void readWriteExample(){
		fileReader reader = new fileReader("src\\Beans.txt");
		reader.printList();
		System.out.println("Adding new Bean...");
		
		ArrayList<exampleBeanOne> tempList = reader.getMyBeans();
		exampleBeanOne bean = new exampleBeanOne("HotBean", 2, 456, "Ice");
		tempList.add(bean);
		
		reader.writeFile("src\\Beans.txt");
		reader.printList();
	}

}
