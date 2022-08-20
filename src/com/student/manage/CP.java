package com.student.manage;
import java.sql.Connection;
import java.sql.DriverManager;

//CP-connection provider
public class CP {
	/*when the connection will be created we gonna store somewhere
	here it will be stored in the "con" variable*/
	
	static Connection con;
	//we will make a method that will give us created connection
	public static Connection createC() {
		//now we have the five steps to create a connection
		//1.load the driver
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			//2.create the connection....
			con=DriverManager.getConnection("jdbc:mysql://localhost/student_manage","root","");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return con;
	}
}
