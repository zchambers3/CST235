package database;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import beans.Bible;

@Stateless
@Local(BibleDataInterface.class)
@LocalBean
public class BibleDataService implements BibleDataInterface {
	// EJB to handle bible data

	// String variable to hold book name
	String bookName = "";

	// Method to import bible.txt file and parse it into bible objects within a List
	@Override
	public List<Bible> getBible() {
		// List to hold bible objects
		List<Bible> bibleBooks = new ArrayList<Bible>();
		// String to hold lines of text from bible
		String str;
		// Integer to hold chapter numbers
		int chapter = 0;
		// Integer to hold verse numbesr
		int verse = 0;

		try {
			// Create InputStream with the bible.txt file as its data
			InputStream inputStream = getClass().getClassLoader().getResourceAsStream("bible.txt");
			// Create a buffered reader of the InputStream for access to .readLine method
			BufferedReader in = new BufferedReader(new InputStreamReader(inputStream));
			// Step through bible.txt one line at a time
			while ((str = in.readLine()) != null) {
				/*
				 * Check if line is a book name or verse. If a book name set the bookname
				 * variable to new book and go to next line. If verse, move on.
				 */
				if (!Character.isDigit(str.charAt(0))) {
					bookName = str;
				} else {
					// Parse first number as chapter
					chapter = Integer.parseInt(str.substring(0, str.indexOf(":")));
					// Create index points to separate verse number from string
					int index = str.indexOf(":");
					int index2 = str.indexOf(":", str.indexOf(":") + 1);
					// Set verse number
					verse = Integer.parseInt(str.substring(index + 1, index2));
					// Add new Bible object to list with bookName, chapter, verse, and scripture.
					bibleBooks.add(new Bible(bookName, chapter, verse, str.substring(str.indexOf(" ") + 1)));
				}
			}
			// Close resources
			in.close();
			inputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		// Return the Bible as a List
		return bibleBooks;
	}

}
