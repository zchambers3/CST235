package business;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import beans.Bible;

@RequestScoped
@Path("/bible")
@Produces({ "application/xml", "application/json" })
@Consumes({ "application/xml", "application/json" })
public class BibleRestService {

	// Provide access to the BibleBusinessInterface classes for business logic
	@Inject
	BibleBusinessInterface service;

	// JSON method to return a Verse when give book name, chapter, and verse
	@GET
	@Path("/getverse/{book}/{chapter}/{verse}")
	@Produces(MediaType.APPLICATION_JSON)
	public Bible getVerse(@PathParam("book") String bookName, @PathParam("chapter") int chapter,
			@PathParam("verse") int verse) {
		return service.bookChapterVerse(bookName, chapter, verse);
	}
	// JSON method to return a Verse when first occurrence of a word is located
	@GET
	@Path("/findfirstword/{searchWord}")
	@Produces(MediaType.APPLICATION_JSON)
	public Bible getFirstWordOccurrence(@PathParam("searchWord") String searchWord) {
		return service.firstOccurence(searchWord);
	}
	// JSON method to count every occurrence of a word in the Bible
	@GET
	@Path("/getwordcount/{searchWord}")
	@Produces(MediaType.APPLICATION_JSON)
	public int getWordCount(@PathParam("searchWord") String searchWord) {
		return service.wordOccurrence(searchWord);
	}
}
