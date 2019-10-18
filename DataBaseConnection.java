package connector;

import java.sql.Connection;
import java.sql.DriverManager;

public class DataBaseConnection {
	final static private String myurl = "jdbc:mysql://localhost:3306/";
	final static private String mydriver = "com.mysql.cj.jdbc.Driver";
	final static private String mydb = "mypanel";

	final static private String username = "root";
	final static private String password = "root";

	public static Connection JAVAConnection() {
		Connection conn = null;

		try {
			Class.forName(mydriver);
			conn = (Connection) DriverManager.getConnection(myurl + mydb, username, password);
		} catch (Exception e) {

			e.printStackTrace();

		}
		return conn;

	}

}
