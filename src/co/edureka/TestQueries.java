package co.edureka;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/*
 * This class contains fires all 10 queries one by one.
 * Each query is properly commented and easily readable
 */

public class TestQueries {

	public static void main(String[] args) {
		
		//Find out the name of Director who directed movie A Walk to Remember		
				Connection con=DatabaseConnectionFactory.createConnection();
				String sql="select name,directors,year from movies where name='a walk to remember' ";
				PreparedStatement ps1=null;
				try {
					ps1=con.prepareStatement(sql);
					ResultSet rs=ps1.executeQuery();
					while(rs.next()){
						String director=rs.getString(2);
						System.out.println(director+" directed A Walk to Remember");
					}
				} catch (SQLException e) {					
					e.printStackTrace();
				}
				
				
		//List down the names of all the documentary movies
				String sql2="select name from movies where type='documentary' ";
				PreparedStatement ps2=null;
				List<String> documentaryMovies=new ArrayList<String>();
				try {
					ps2=con.prepareStatement(sql2);
					ResultSet rs=ps2.executeQuery();
					while(rs.next()){
						String movieName=rs.getString(1);
						documentaryMovies.add(movieName);
					}
					System.out.println("Documentary Movies : "+documentaryMovies);
				} catch (SQLException e) {					
					e.printStackTrace();
				}
				
		//List down the names of all documentary movies released in 2000
				String sql3="select name from movies where type='documentary' and year='2000' ";
				PreparedStatement ps3=null;
				List<String> documentaryMovies2000=new ArrayList<String>();
				try {
					ps3=con.prepareStatement(sql3);
					ResultSet rs=ps3.executeQuery();
					while(rs.next()){
						String movieName=rs.getString(1);
						documentaryMovies2000.add(movieName);
					}
					System.out.println("Documentary Movies Released in 2000 : "+documentaryMovies2000);
				} catch (SQLException e) {					
					e.printStackTrace();
				}
				
				
				//Find out the names of all movies directed by Steven Spielberg
				String sql4="select name from movies where directors like '%steven spielberg%' ";
				PreparedStatement ps4=null;
				List<String> spielbergMovies=new ArrayList<String>();
				try {
					ps4=con.prepareStatement(sql4);
					ResultSet rs=ps4.executeQuery();
					while(rs.next()){
						String movieName=rs.getString(1);
					    spielbergMovies.add(movieName);
					}
					System.out.println("Movies Directed by Steven Spielberg : "+spielbergMovies);
				} catch (SQLException e) {					
					e.printStackTrace();
				}
				
				//Find out the names of all movies directed by Steven Spielberg and was released in 2012
				String sql5="select name from movies where directors like '%steven spielberg%' and year='2012' ";
				PreparedStatement ps5=null;
				List<String> spielbergMoviesIn2012=new ArrayList<String>();
				try {
					ps5=con.prepareStatement(sql5);
					ResultSet rs=ps5.executeQuery();
					while(rs.next()){
						String movieName=rs.getString(1);
					    spielbergMoviesIn2012.add(movieName);
					}
					System.out.println("Movies Directed by Steven Spielberg that were released in 2012 : "+spielbergMoviesIn2012);
				} catch (SQLException e) {					
					e.printStackTrace();
				}
				
				//Find out the year in which maximum number of movies were released
				String sql6="select year,count(*) from movies group by year order by count(*) desc limit 1 ";
				PreparedStatement ps6=null;
				try {
					ps6=con.prepareStatement(sql6);
					ResultSet rs=ps6.executeQuery();
					while(rs.next()){
						int year=rs.getInt(1);
						int movieCount=rs.getInt(2);
						System.out.println("Most number of movies released in year "+year+" and the count is "+movieCount);
					}					
				} catch (SQLException e) {					
					e.printStackTrace();
				}
				
				//Find out the movie names which belongs to Genre 'romance'
				String sql7="select name from movies where genres like '%romance%' ";
				PreparedStatement ps7=null;
				List<String> romanticMovies=new ArrayList<String>();
				try {
					ps7=con.prepareStatement(sql7);
					ResultSet rs=ps7.executeQuery();
					while(rs.next()){						
						String movieName=rs.getString(1);
						romanticMovies.add(movieName);
					}
					System.out.println("Romantic Movies : "+romanticMovies);
				} catch (SQLException e) {					
					e.printStackTrace();
				}
				
				//Find out the top 10 movies with Genre 'romance' which got highest number of votes on IMDB
				String sql8="select name from movies where genres like '%romance%' order by imdb_votes desc limit 10 ";
				PreparedStatement ps8=null;
				List<String> top10VotedRomanticMovies=new ArrayList<String>();
				try {
					ps8=con.prepareStatement(sql8);
					ResultSet rs=ps8.executeQuery();
					while(rs.next()){						
						String movieName=rs.getString(1);
						top10VotedRomanticMovies.add(movieName);
					}
					System.out.println("Top 10 Voted Romantic Movies on IMDB : "+top10VotedRomanticMovies);
				} catch (SQLException e) {					
					e.printStackTrace();
				}
				
				//Find out the movie with Genre 'thriller' which have the highest runtime and released after 2005
				String sql9="select name from movies where genres like '%thriller%' and year>2005 order by runtime desc limit 1 ";
				PreparedStatement ps9=null;				
				try {
					ps9=con.prepareStatement(sql9);
					ResultSet rs=ps9.executeQuery();
					while(rs.next()){						
						String longestThrillerMovieAfter2005=rs.getString(1);
						System.out.println("Top 10 Voted Romantic Movies on IMDB : "+longestThrillerMovieAfter2005);
						}
					
				} catch (SQLException e) {					
					e.printStackTrace();
				}
				
				//Find out average IMDB rating for movies 
				//While calculating average exclude the movies for which rating is zero as these are movies for which IMDB rating is not known
				
				String sql10="select avg(imdb_rating) from movies where imdb_rating!=0 ";
				PreparedStatement ps10=null;				
				try {
					ps10=con.prepareStatement(sql10);
					ResultSet rs=ps10.executeQuery();
					while(rs.next()){						
						float averageRating=rs.getFloat(1);
						System.out.println("Average rating of Movies on IMDB : "+averageRating);
						}
					
				}				
				catch(SQLException e) {					
					e.printStackTrace();
				}				
				
				//close the database connection
				try {
					con.close();
				} catch (SQLException e) {					
					e.printStackTrace();
				}

	} 

}
