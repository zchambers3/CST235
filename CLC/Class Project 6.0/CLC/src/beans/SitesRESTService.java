package beans;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/sites")
public class SitesRESTService {
		
	@GET
	@Path("/get")
	@Produces("application/json")
	public Sites getSite(
	            @QueryParam("id") Integer thisID,
	            @QueryParam("name") String thisName,
				@QueryParam("color") String thisColor){

		int counter = 0;
		if (thisID != null) {
			System.out.println("Looking for an ID of " + thisID);
			System.out.println("Searching " + NewSiteFormController.getArraySize() + " entries.");
			counter = 0;
			while (counter < NewSiteFormController.getArraySize()) {
				if(NewSiteFormController.get(counter).id == thisID) {
					// this is it!
					System.out.println("Found it!");
					return NewSiteFormController.get(counter);
				} else {
					// this is not our record, keep searching.
					System.out.println(NewSiteFormController.get(counter).getId() + " is not " + thisID);
					System.out.println(NewSiteFormController.get(counter).id);
				}
				counter++;
			}
			
		} else {
			System.out.println("Not looking for an ID, it is null.");
		}
		
		if (thisName != null) {
			System.out.println("Looking for a name of " + thisName);
			System.out.println("Searching " + NewSiteFormController.getArraySize() + " entries.");
			counter = 0;
			while (counter < NewSiteFormController.getArraySize()) {
				if(NewSiteFormController.get(counter).name.trim().toUpperCase().equals(thisName.trim().toUpperCase())) {
					// this is it!
					System.out.println("Found it!");
					return NewSiteFormController.get(counter);
				} else {
					// this is not our record, keep searching.
					System.out.println(NewSiteFormController.get(counter).name + " is not " + thisName);
				}
				counter++;
			}
			
		} else {
			System.out.println("Not looking for a name, it is null.");
		}
		
		if (thisColor != null) {
			System.out.println("Looking for a color of " + thisColor);
			System.out.println("Searching " + NewSiteFormController.getArraySize() + " entries.");
			counter = 0;
			while (counter < NewSiteFormController.getArraySize()) {
				if(NewSiteFormController.get(counter).color.trim().toUpperCase().equals(thisColor.trim().toUpperCase())) {
					// this is it!
					System.out.println("Found it!");
					return NewSiteFormController.get(counter);
				} else {
					// this is not our record, keep searching.
					System.out.println(NewSiteFormController.get(counter).color + " is not " + thisColor);
					System.out.println(NewSiteFormController.get(counter).color.trim().length());
					System.out.println(thisColor.length());
				}
				counter++;
			}
			
		} else {
			System.out.println("Not looking for a color, it is null.");
		}
		
		// thisSite.setId(thisID);
		// thisSite.setName(thisName);
		// thisSite.setColor(thisColor);
		System.out.println("SitesRESTService Called");
		// System.out.println(NewSiteFormController.arraySize);
	    return null;
	}
	
	private String buildMyString(String ID, String Name, String Color) {
		// making my own JSON 
		String jsonString ="{\"id\"" ;
		return jsonString;
	}
	
	
		
}
	

