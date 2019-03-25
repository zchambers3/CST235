package beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.xml.bind.annotation.XmlRootElement;

@ManagedBean
@ViewScoped
@XmlRootElement(name = "bible")
public class Bible {
	/*
	 * This class is designed to be a bible passage object. Each object will hold a
	 * book name, chapter number, verse number, and the actual text from the verse.
	 * 
	 */

	// String for name of bible book
	private String bookName="";
	// Variable to hold chapter number
	private int chapter = 0;
	// Variable to hold verse number
	private int verse = 0;
	// Variable to hold scripture text
	private String scripture="";

	// Default constructor
	public Bible() {
	}

	// Loaded constructor
	public Bible(String bookName, int chapter, int verse, String words) {
		this.bookName = bookName;
		this.chapter = chapter;
		this.verse = verse;
		this.scripture = words;
	}

	// Getter and Setters
	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public int getChapter() {
		return chapter;
	}

	public void setChapter(int chapter) {
		this.chapter = chapter;
	}

	public int getVerse() {
		return verse;
	}

	public void setVerse(int verse) {
		this.verse = verse;
	}

	public String getScripture() {
		return scripture;
	}

	public void setScripture(String scripture) {
		this.scripture = scripture;
	}

}
