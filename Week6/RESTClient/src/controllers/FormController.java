package controllers;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import beans.Bible;
import beans.SearchString;
import business.RestServiceInterface;

@ManagedBean
@ViewScoped
public class FormController {

	@Inject
	RestServiceInterface service;
	
	/*
	 * Method to return a Bible passage by book, chapter, and verse
	 */
	public String onSubmit(Bible bible) {
		// Call REST method and return results
		bible = service.getBible(bible);
		// Set Bible bean to results
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("bible", bible);
		// Send to response page
		return "VerseResponse.xhtml";
	}
	
	/*
	 * Method to search for a word and return the Bible passage of its first occurrence
	 */
	public String onSearchWord(SearchString searchString){
		// Call REST method and return results
		Bible bible = service.findWord(searchString);
		// Set Bible bean to results
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("bible", bible);
		// Pass searchstring bean to next page
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("searchString", searchString);
		// Send to response page
		return "WordSearchResponse.xhtml";
	}
	
	/*
	 * Method to search for a word and return the amount of times it occurs in the bible
	 */
	public String onWordCount(SearchString searchString) {
		// Call REST method and return results
		service.findWordCount(searchString);
		// Pass searchstring bean to next page
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("searchString", searchString);
		// Send to response page
		return "WordCountResponse.xhtml";		
	}
}