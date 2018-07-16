package com.anuja.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;


public class TestJDBC {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String jdbcURL = "jdbc:mysql://localhost:3306/hb-01-one-to-one-uni?useSSL=false";
		String usr = "root";
		String pass = "root";
		try {
			System.out.println("connecting to db");
			Connection connection = DriverManager.getConnection(jdbcURL, usr, pass);
			System.out.println("Successful!!");
			
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
