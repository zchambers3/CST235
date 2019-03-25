package beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@ManagedBean
@SessionScoped
public class NewSite {

	@NotNull(message = "Please enter a Site ID. This is a required field.")
	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}


	@NotNull(message = "Please enter a Name. This is a required field.")
	@Size(min = 4, max = 15)
	private String name;

	@NotNull(message = "Please enter a Color. This is a required field.")
	@Size(min = 4, max = 15)
	private String color;

	
	public NewSite() {
		id = 0;
		name = "";
		color = "";
		
	}
}
