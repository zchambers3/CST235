package beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class Bible {
	/*
	 * This class is designed to be a bible passage object. Each object will hold a
	 * book name, chapter number, verse number, and the actual text from the verse.
	 * 
	 */

	// String for name of bible book
	private String bookName;
	// Variable to hold chapter number
	private Integer chapter;
	// Variable to hold verse number
	private Integer verse;
	// Variable to hold scripture text
	private String scripture;

	// Default constructor
	public Bible() {
	}

	// Loaded constructor
	public Bible(String bookName, Integer chapter, Integer verse, String words) {
		this.bookName = bookName;
		this.chapter = chapter;
		this.verse = verse;
		this.scripture = words;
	}

	// Getter and Setters
	public String getBookName() {
		return bookName;
	}

	public void setVerse(Integer verse) {
		this.verse = verse;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public Integer getChapter() {
		return chapter;
	}

	public void setChapter(Integer chapter) {
		this.chapter = chapter;
	}

	public Integer getVerse() {
		return verse;
	}

	public String getScripture() {
		return scripture;
	}

	public void setScripture(String scripture) {
		this.scripture = scripture;
	}

}
