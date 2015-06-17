To run the project you will require Java 7 and MySQL Database (Using Eclipse IDE for Java programming is highly recommended)   

Make sure you have changed the MySQL database specific properties in file DatabaseConnectionFactory.java according to your MySQL setup

Make a MySQL database named project and change the username and password property according to your MySQL setup

    private static String dbURL = "jdbc:mysql://localhost/project";
	private static String dbUser = "root";
	private static String dbPassword = "";
	
	
Create movies table under project database by using below Create Table command	

CREATE TABLE IF NOT EXISTS movies (
  name varchar(500) NOT NULL,
  type varchar(500) NOT NULL,
  directors varchar(500) NOT NULL,
  imdb_rating float NOT NULL,
  runtime int(11) NOT NULL,
  year int(11) NOT NULL,
  genres varchar(100) NOT NULL,
  imdb_votes int(11) NOT NULL,
  imdb_top25 char(1) NOT NULL,
  must_see char(1) NOT NULL,
  URL varchar(300) NOT NULL
)	
	
	
Make sure mysql.jar is on the project build path otherwise you will get ClassNotFoundException while running the project

Now run the Persistence.java file which will store all the movie data into movies table in database
When you run the Persistence.java you will see the messages printing on console. Inserting all the movies into database will take around 30 seconds time. 
So after running Persistence.java wait until it inserts all the movies into database.

Next run the TestQueries.java file which will run all SQL queries one by one and print the result of each query on the console

Happy Coding...	