package co.edureka;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/*
 * This class persist the data(store the data) into database.
 * Remember LoadData class just loads the data from a movies.txt and store it in List of List, it does not save it in database
 * It is the PersistData class which actually saves the data into database from movieData list
 *   
 */

public class PersistData {
	
	public static void persistData(){
		Connection con=DatabaseConnectionFactory.createConnection();		
		PreparedStatement st=null;
		String sql=null;		
		
		//We could have used JDBC Batch Insert to insert all the data rapidly
		//Here we iterate though the movieData list get the movie info for each movie and insert it one by one
		for(int i=0;i<LoadData.movieData.size();i++){
			System.out.println("Storing Movie "+(i+1)+" to database");
			List<String> row=LoadData.movieData.get(i);	
		    
			String name=row.get(0).trim();
			String type=row.get(1).trim();
			String directors=row.get(2).trim();			
			
			float imdb_rating=(row.get(3).trim().equals(""))?0:Float.parseFloat(row.get(3).trim());
			int runtime=(row.get(4).trim().equals(""))?0:Integer.parseInt(row.get(4).trim());
			int year=(row.get(5).trim().equals(""))?0:Integer.parseInt(row.get(5).trim().substring(0, 4));
			String genres=row.get(6).trim();
			int imdb_votes=(row.get(7).trim().equals(""))?0:Integer.parseInt(row.get(7).trim());
			char imdb_top25=(row.get(8).trim().equals(""))?'N':Character.valueOf(row.get(8).trim().charAt(0));
			char must_see=(row.get(9).trim().equals(""))?'N':Character.valueOf(row.get(9).trim().charAt(0));
			String URL=row.get(10).trim();
			
			/*System.out.println(name);
			System.out.println(type);
			System.out.println(directors);
			System.out.println(imdb_rating);
			System.out.println(runtime);
			System.out.println(year);
			System.out.println(genres);
			System.out.println(imdb_votes);
			System.out.println(imdb_top25);
			System.out.println(must_see);
			System.out.println(URL);
			*/
			
			sql="insert into movies(name,type,directors,imdb_rating,runtime,year,genres,imdb_votes,imdb_top25,must_see,URL)"
					+ " values(?,?,?,?,?,?,?,?,?,?,?)";
			
			try {
				st=con.prepareStatement(sql);
				st.setString(1, name);st.setString(2, type);
				st.setString(3, directors);st.setFloat(4, imdb_rating);
				st.setInt(5, runtime);st.setInt(6, year);
				st.setString(7, genres);st.setInt(8, imdb_votes);
				st.setString(9, String.valueOf(imdb_top25));
				st.setString(10, String.valueOf(must_see));
				st.setString(11, URL);
				st.executeUpdate();
				
			} catch (SQLException e) {			
				e.printStackTrace();
			}			
		}	
		
	}
}
