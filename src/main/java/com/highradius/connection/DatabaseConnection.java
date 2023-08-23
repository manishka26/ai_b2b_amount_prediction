package com.highradius.connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {

	public static Connection getConnection() {
    	Connection connection = null;
    	String url = "jdbc:mysql://localhost:3306/mysql";
		String user = "root";
		String password = "root";
    	try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(url, user, password);
			return connection;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return connection;
	}
}
