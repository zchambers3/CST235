package database;

import java.util.List;

import beans.Bible;

public interface BibleDataInterface {
	// Interface to provide methods for accessing bible data
	
	// Method to return a List containing Bible passages
	public List<Bible> getBible();
}
