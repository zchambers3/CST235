package business;

import beans.Bible;
import beans.SearchString;

public interface RestServiceInterface {
	/*
	 * Interface to provide access to REST methods
	 */
	
	// Method to search for Bible verse book/chapter/verse
	public Bible getBible(Bible bible);
	// Method to serach for a word and return the passage of its first occurrence
	public Bible findWord(SearchString searchWord);
	// Method to search for a word and count its occurrences in the bible
	public String findWordCount(SearchString searchString);
}
