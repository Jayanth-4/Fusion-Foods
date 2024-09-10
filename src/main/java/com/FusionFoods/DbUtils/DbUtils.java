package com.FusionFoods.DbUtils;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbUtils {
	
	private static String url="jdbc:mysql://localhost:3306/fusion_foods";
	private static	String username="root";
	private static String password="root";
	static Connection con=null;
	
	static public Connection myConnect() {
		
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(url,username,password);
			

		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	return con;	
	}

}
