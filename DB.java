package code.java;

import java.sql.Connection;
import java.sql.DriverManager;

public class DB
{
	final static private String myurl="jdbc:mysql://localhost:3306/";
	final static private String mydrivar="com.mysql.jdbc.Driver";
	final static private String mydb="Graphicpass";
	/*final static private String password="!mg@247m@n@v";
	final static private String username="root";
	*/
	final static private String password="root";
	final static private String username="root";
	 
	 public static Connection JAVAConnection()
	 {
		 Connection conn=null;
		 try
		 {
			 Class.forName(mydrivar).newInstance();
			 conn=(Connection) DriverManager.getConnection(myurl+mydb,username,password);
		 }
		 catch (Exception e)
		 {
			 System.out.println("Error"+e);
		 }
		 return conn;
		 
	 }

}

