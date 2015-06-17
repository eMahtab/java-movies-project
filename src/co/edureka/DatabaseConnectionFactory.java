package co.edureka;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/* This class will be used to get Database Connection
 * Don't forget to change the database properties according to your MySQL setup
 * Here database name is project, username is root and password for user root is blank
 * Change these values according to your MySQL setup
 * */
 
public class DatabaseConnectionFactory {

	private static String dbURL = "jdbc:mysql://localhost/project";
	private static String dbUser = "root";
	private static String dbPassword = "";

	public static Connection createConnection() {
		Connection con = null;
		try {
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException ex) {
				System.out.println("Error: unable to load driver class!");
				System.exit(1);
			}
			con = DriverManager.getConnection(dbURL, dbUser, dbPassword);
		} catch (SQLException sqe) {
			System.out.println("Error: While Creating connection to database");
			sqe.printStackTrace();
		}
		return con;
	}
}
