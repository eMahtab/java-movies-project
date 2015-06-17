package co.edureka;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * This class loads the data from the movies.txt file to a List of List (movieData).
 * As each movie itself is a list that is why we have used List of List
 */

public class LoadData {
	static List<List<String> > movieData=new ArrayList<List<String>>();	
	
	public static void loadData() throws IOException{		
		BufferedReader breader=null;		
		try{		
		Path path = Paths.get("src/resources", "movies.txt");
        breader = Files.newBufferedReader(path, StandardCharsets.ISO_8859_1);        
		}catch(IOException exception){
			System.out.println("Error occured while trying to read the file");
			System.exit(0);
		}
		String line=null;
		int lineCount=0;
		
		while( (line=breader.readLine())!=null){			
			lineCount++;
			if(lineCount==1){
				//We don't add first line of the file as it is header line with names of the columns
				;
			}
			else{
				String movie[]=line.split(";");				
				List<String>listFormat=Arrays.asList(movie);				
				LoadData.movieData.add(listFormat);
			}
		}
		
		
	}	
}
