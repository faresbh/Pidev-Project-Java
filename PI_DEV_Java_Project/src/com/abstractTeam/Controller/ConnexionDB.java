package com.abstractTeam.Controller;




import java.sql.Connection;
import java.sql.DriverManager;


public class ConnexionDB {

	public static String url = "jdbc:mysql://localhost:3306/";
	public static String bd="abtractteam";
	public static String login = "root";
	public static String pass = "";
	
	static public Connection getConnected() {
		Connection connection = null;
		
		
		try {

			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(url+bd, login, pass);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return connection;

	}

	
}
