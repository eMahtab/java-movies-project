package co.edureka;
import java.io.IOException;

/*
 * Persistence class have main method which first calls the LoadData.loadData() to load data from movies.txt file to movieData list 
 * Then it calls PersistData.persistData() to store the movie data into database from movieData list one by one
 * While running the project first run this file, then TestQueries.java
 * 
 */

public class Persistence {

	public static void main(String[] args) {			
		try {
			LoadData.loadData();
			PersistData.persistData();
		} catch (IOException e) {			
			e.printStackTrace();
		}		
		
	}
}
