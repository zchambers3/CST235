package beans;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.faces.bean.SessionScoped;


@SessionScoped 
 
@ManagedBean(name="Sites")
public class Sites implements Serializable {
	/**
	 * 
	 */	
	private static final long serialVersionUID = 1L;
	public int id;
	@NotNull(message = "Last name cannot be null")
	@Size(min=5, max=15, message = "Name must be between 5 and 10 characters long.") 
	String name;
	@NotNull(message = "Last name cannot be null")
	@Size(min=5, max=15, message = "Color must be between 5 and 10 characters long.") 
	public String color;
	
	public static void addSite(int thisId, String thisName, String thisColor){
		System.out.println("addSite method called");
		
		// essArray[counter] = new Sites(Integer.toString(thisId), thisName, thisColor);
		// counter++;
		
		System.out.print("Total Sites = ");
		// System.out.println(counter);
	}
	
	public Sites(String thisId, String thisName, String thisColor){
		this.id = parseInt(thisId);
		this.name = thisName;
		this.color = thisColor;
		// accessArray[counter] = new Sites(this.id, this.name, this.color);
		// counter++;
		System.out.println("String ID constructor called");
		// System.out.print("Total Sites = ");
		// System.out.println(counter);
	}
	
	public Sites(int thisId, String thisName, String thisColor){
		this.id = thisId;
		this.name = thisName;
		this.color = thisColor;
		// accessArray[counter] = new Sites(this.id, this.name, this.color);
		// counter++;
		System.out.println("Int ID constructor called");
		// System.out.print("Total Sites = ");
		// System.out.println(counter);
	}
	
	private static int parseInt(String id2) {
		// TODO Auto-generated method stub
		return 0;
	}

	public Sites() {
		this.id = 0;
		this.name = "default";
		this.color = "vanilla";
		// accessArray[counter] = this;
		// counter++;
		System.out.println();
		System.out.println("default constructor called");
		// System.out.print("Total Sites = ");
		// System.out.println(counter);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
		System.out.println();
		System.out.print("setting id to ");
		System.out.println(this.id);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
		System.out.println();
		System.out.print("setting name to ");
		System.out.println(this.name);
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
		System.out.println();
		System.out.print("setting color to ");
		System.out.println(this.color);
	}


}
