package com.sathya.jdbc;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcEx1 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		//load the driver
		Class.forName("oracle.jdbc.driver.OracleDriver");
		System.out.println("Driver created successfull");
		
		//Create the connection
		Connection connection=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","alekhya","java");
		System.out.println("connection created successfull");
		
		//process the query
		//Static statements - statement - create,drop
		Statement statement=connection.createStatement();
		String q1="Create table employ(id number,name varchar2(30),salary number)";
		int res1=statement.executeUpdate(q1);
		System.out.println("Table Created Successfully "+res1);
		
		//close the connection
		connection.close();
		System.out.println("Connection closed ");
	}

}
