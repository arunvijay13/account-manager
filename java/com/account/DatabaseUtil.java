package com.account;

import java.sql.*;

public class DatabaseUtil {
	
	private final static String USERNAME = "root";
	private final static String PASSWORD = "arun123";
	private final static String URL = "jdbc:mysql://localhost:3306/database2";
	
	public static Connection getConnection() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection(URL,USERNAME,PASSWORD);
	}
	
}
