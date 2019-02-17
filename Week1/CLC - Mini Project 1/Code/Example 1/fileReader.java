package clcAssignment1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Scanner;

public class fileReader {

	public fileReader(String fileName){
		readFile(fileName);
	}
	public fileReader(){}
	
	private ArrayList <exampleBeanOne> myBeans;
	
	public ArrayList <exampleBeanOne> getMyBeans(){
		return myBeans;
	}
	
	private void readFile (String filename){
		File nameOfFile = new File (filename);
		myBeans = new ArrayList <exampleBeanOne> ();
		try {
			Scanner inputstream = new Scanner(nameOfFile);
			while (inputstream.hasNext()){
				String data = inputstream.nextLine();
				String values[] = data.split(",");
				exampleBeanOne newBean = new exampleBeanOne();
				newBean.setBeanID(Integer.parseInt(values[0]));
				newBean.setBeanName(values[1]);
				newBean.setBeanNum(Integer.parseInt(values[2]));
				newBean.setBeanWord(values[3]);
				myBeans.add(newBean);
			}
			inputstream.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	public void writeFile (String destination){
		try {
			PrintWriter writer = new PrintWriter (destination, "utf-8");
			for (exampleBeanOne bean: myBeans){
				writer.println(bean.getBeanID() + "," 
						+ bean.getBeanName() + "," 
						+ bean.getBeanNum() + "," 
						+ bean.getBeanWord());
			}
			writer.close();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	public void printList(){
		for (exampleBeanOne bean: myBeans){
			System.out.print("Bean ID: " + bean.getBeanID() + " ");
			System.out.print("Bean Name: " + bean.getBeanName() + " ");
			System.out.print("Bean Number: " + bean.getBeanNum() + " ");
			System.out.print("Bean Word: " + bean.getBeanWord());
			System.out.println();
		}
	}
}
