package clcAssignment1;

import java.io.Serializable;

public class exampleBeanOne implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String beanName;			//Product description
	private int beanID;				//Product identification number
	private int beanNum;				//Number of products
	private String beanWord;			//Product category
	
	public exampleBeanOne(){
		beanName = null;
		beanID = 0;
		beanNum = 0;
		beanWord = null;
	}
	public exampleBeanOne(String name, int id, int num, String word){
		beanName = name;
		beanID = id;
		beanNum = num;
		beanWord = word;
	}
	
	public void setBeanName (String name){
		this.beanName = name;
	}
	public String getBeanName (){
		return beanName;
	}
	
	public void setBeanID (int id){
		this.beanID = id;
	}
	public int getBeanID (){
		return beanID;
	}
	
	public void setBeanNum (int num){
		this.beanNum = num;
	}
	public int getBeanNum (){
		return beanNum;
	}
	
	public void setBeanWord (String word){
		this.beanWord = word;
	}
	public String getBeanWord (){
		return beanWord;
	}
	
}
