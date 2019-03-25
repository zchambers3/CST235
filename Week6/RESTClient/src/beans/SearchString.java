package beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;


@ManagedBean
@ViewScoped
public class SearchString {
	/*
	 * This class is for holding the search string and its results
	 */
	// Variable to hold search string
	private String searchWord = "";
	// Variable to hold search results
	private String searchCount ="";
	
	// Getter and setters
	public String getSearchWord() {
		return searchWord;
	}

	public void setSearchWord(String searchWord) {
		this.searchWord = searchWord;
	}

	public String getSearchCount() {
		return searchCount;
	}

	public void setSearchCount(String searchCount) {
		this.searchCount = searchCount;
	}	
	
}
