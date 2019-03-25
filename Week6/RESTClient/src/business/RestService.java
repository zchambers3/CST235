package business;

import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;

import beans.Bible;
import beans.SearchString;
@Stateless
@Local(RestServiceInterface.class)
@LocalBean
public class RestService implements RestServiceInterface{
	/*
	 * This class provides access to the REST Services
	 */
	
	// Variable to hold output
	private String output;
	
	/*
	 * Method to get a verse by book, chapter, and verse number
	 */
	@Override
	public Bible getBible(Bible bible) {
		//URI of JSON request
		String REST_URI = "http://localhost:8080/BibleRestProgram/rest/bible/getverse/" + bible.getBookName() + "/" + bible.getChapter() + "/" + bible.getVerse();
		// Client class to access REST API
		Client client = ClientBuilder.newClient();
		// Query and return result from REST API
		return client.target(REST_URI).request(MediaType.APPLICATION_JSON).get(Bible.class);		
	}
	
	/*
	 * Method to find the first occurrence of a word and return the bible scripture it is in
	 */
	@Override
	public Bible findWord(SearchString searchWord) {
		//URI of JSON request
		String REST_URI = "http://localhost:8080/BibleRestProgram/rest/bible/findfirstword/" + searchWord.getSearchWord();
		// Client class to access REST API
		Client client = ClientBuilder.newClient();
		// Query and return result from REST API
		return client.target(REST_URI).request(MediaType.APPLICATION_JSON).get(Bible.class);
	}
	
	/*
	 * Method to find all occurrences of a word and return the count
	 */
	@Override
	public String findWordCount(SearchString searchString) {
		
		try {
			// URI of REST API
			URL url = new URL("http://localhost:8080/BibleRestProgram/rest/bible/getwordcount/"+ searchString.getSearchWord());
			// Create client to connect to REST API
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");
			
			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
			}
			// Read REST return as a string
			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
			// Set result as string
			searchString.setSearchCount(br.readLine());
			conn.disconnect();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		//Return result
		return output;		
	}
	
	
}
