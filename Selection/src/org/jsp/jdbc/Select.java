package org.jsp.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Select {
	public static void main(String[] args) {
		
		String url = 
		"jdbc:mysql://localhost:3306?user=root&password=12345";
		
		//WAQTD all the details of the userinformation
		
		String select = "select * from tech41.userinformation";
		
		try {
			Connection connection = DriverManager.getConnection(url);
			
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(select);
			
			while (rs.next()) {
				System.out.println("Id of the userinformation :"+rs.getInt(1));
				System.out.println("Name of the userinformation :"+rs.getString(2));
				System.out.println("Mobile Number of the userinformation :"+rs.getString(3));
				System.out.println("Email Id of the userinformation :"+rs.getString(4));
				System.out.println("Password of the userinformation :"+rs.getString(5));
				System.out.println("-----------------------------------------------");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
