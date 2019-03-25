package business;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;

import beans.Bible;
import database.BibleDataInterface;

@Stateless
@Local(BibleBusinessInterface.class)
@LocalBean
public class BibleBusinessService implements BibleBusinessInterface {
	/*
	 * EJB service that provides the business logic for Bible searches
	 */

	// Variable to hold the name of a bible book
	String bookName = "";
	// Boolean to hold a true/false value for searches
	boolean foundWord;
	// Integer to hold the count of word occurrences.
	int wordCount = 0;
	// Bible object
	Bible bibleScripture = new Bible();

	// Injection to access Bible data methods
	@Inject
	BibleDataInterface service;

	// Method to find occurrences of a word
	@Override
	public int wordOccurrence(String searchString) {
		// Populate a List with the Bible from the Bible Data service
		List<Bible> bibleBooks = service.getBible();
		// Set the wordCount to zero
		wordCount = 0;

		/*
		 * Take the inputed search string and check each bible verse with .contains to
		 * see if the string is present. If it is, add one to the wordcount.
		 */
		bibleBooks.forEach(x -> {
			if (x.getScripture().toLowerCase().contains(searchString.toLowerCase())) {
				wordCount = wordCount + 1;
			}
		});
		
		// Return the amount of times word was found
		return wordCount;

	}

	// Method to find the first occurence of a word and return the bible passage
	@Override
	public Bible firstOccurence(String searchString) {
		// Reset bibleScripture to null;
		bibleScripture = new Bible();
		// Populate a List with the Bible from the Bible Data service
		List<Bible> bibleBooks = service.getBible();
		// Integer to increment through the List
		int i = 0;
		// Reset boolean to false
		foundWord = false;
		/*
		 * Search through bible passages with .contains for the search string. If found
		 * set foundWord to true. Set bibleScripture to the passsage containg the
		 * string.
		 */
		while (!foundWord) {
			if (bibleBooks.get(i).getScripture().toLowerCase().contains(searchString.toLowerCase())) {
				foundWord = true;
				bibleScripture = bibleBooks.get(i);
			} else {
				i++;
			}
		}
		// Return the bible verse containing the word.
		return bibleScripture;
	}

	/*
	 * Method to return a bible passage from a book name, chapter number, verse
	 * number inquiry.
	 */
	@Override
	public Bible bookChapterVerse(String bookName, int chapter, int verse) {
		// Reset bibleScripture to null;
		bibleScripture = new Bible();
		// Populate a List with the Bible from the Bible Data service
		List<Bible> bibleBooks = service.getBible();

		// search list for passage that matches book name, chapter, and verse arguments.
		// Set the matching passage to bibleScripture variable.
		bibleBooks.forEach(x -> {
			if (x.getBookName().toLowerCase().equals(bookName.toLowerCase()) && x.getChapter() == chapter
					&& x.getVerse() == verse) {
				bibleScripture = x;
			}
		});
		
		// Return matching bible scripture
		return bibleScripture;

	}

}
