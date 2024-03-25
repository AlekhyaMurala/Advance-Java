package com.sathya.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcEx {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		//1.load the driver
		Class.forName("oracle.jdbc.driver.OracleDriver");
		System.out.println("Driver Loaded Successfully");
		
		//2.create the connection
		
		Connection connection=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","alekhya","java");
		System.out.println("Connection created Successfully");
		
		//4.Close the resources
		
		connection.close();
		System.out.println("Connection closed");
	}

}
