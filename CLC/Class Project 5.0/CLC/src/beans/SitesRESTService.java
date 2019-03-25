package beans;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;


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
		

		System.out.println("SitesRESTService Called");

	    return null;
	}
	

    @Path("/delete{id}")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
	// @Produces("application/json")
    public String removeSite(@PathParam("id") Integer thisID) {
    	// search by ID, and remove from the list.  
		System.out.println("Delete called.");
		String resultString = "";
		
		int counter = 0;
		if (thisID != null) {
			System.out.println("Looking for an ID of " + thisID);
			System.out.println("Searching " + NewSiteFormController.getArraySize() + " entries.");
			counter = 0;
			while (counter < NewSiteFormController.getArraySize()) {
				if(NewSiteFormController.get(counter).id == thisID) {
					NewSiteFormController.accessList.remove(counter);
					resultString = "removed a matching item!";
					return resultString;
				}					
				counter++;
			}
			
		} else {
			System.out.println("Not looking for an ID, it is null.");
			return "Not looking for an ID, it is null.";
		}		
		
		// only gets here if the search fails
		resultString ="Record deleted"; 
		return resultString;
	}
	
	
	@POST
	@Path("/post{id}&{name}&{color}")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	// @Produces("application/json")
	public String addSite(
			@PathParam("id") Integer thisID,
			@PathParam("name") String thisName,
			@PathParam("color") String thisColor){
		System.out.println("Post called.");
		// adding a new site
		NewSiteFormController.accessList.add( new Sites(thisID, thisName, thisColor));
		return "OK";
	}
	


    @Path("/put{id}&{name}&{color}")
    @PUT
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	// @Produces("application/json")
    public String reviseSite(
    		@PathParam("id") Integer thisID,
    		@PathParam("name") String newName,
    		@PathParam("color") String newColor) {
    		//add the above to the list
			System.out.println("Put called.");
			String resultString = "";
			int counter = 0;
			if (thisID != null) {
				System.out.println("Looking for an ID of " + thisID);
				System.out.println("Searching " + NewSiteFormController.getArraySize() + " entries.");
				counter = 0;
				while (counter < NewSiteFormController.getArraySize()) {
					if(NewSiteFormController.get(counter).id == thisID) {
						NewSiteFormController.accessList.remove(counter);
						NewSiteFormController.accessList.add(new Sites(thisID, newName, newColor));
						resultString ="Record updated to reflect name of " + newName + " and color of " + newColor;
						System.out.println(resultString);
						return resultString;
					}					
					counter++;
				}
				
			} else {
				System.out.println("Not looking for an ID, it is null.");
				return "Not looking for an ID, it is null.";
			}
			resultString = "no matching ID found.";
			System.out.println(resultString);
		return resultString;
	}
	
    

	
	
		
}
	

