package business;

import beans.Bible;

public interface BibleBusinessInterface {
	/*
	 * Interface designed to provide methods for accessing business logic concerning
	 * Bible objects.
	 */

	/*
	 * Method to take a search word as a arugment and search the bible for
	 * occurences of that word. It will return a count of occurences when completed.
	 */
	public int wordOccurrence(String searchString);

	/*
	 * Method to take a search word as an argument and search the bible for the
	 * FIRST occurrence of the word and return the book name, chapter number, verse
	 * number, and actual verse as a bible object.
	 */
	public Bible firstOccurence(String searchString);

	/*
	 * Method takes a book name, chapter number, and verse number as arguments and
	 * returns the bible verse.
	 */
	public Bible bookChapterVerse(String bookName, int chapter, int verse);
}
