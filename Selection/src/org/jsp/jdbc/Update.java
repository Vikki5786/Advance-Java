package org.jsp.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Update {
	public static void main(String[] args) {
		String url = 
				"jdbc:mysql://localhost:3306?user=root&password=12345";
		String update = 
				"update tech41.userinformation set user_password='NCPJV@40458' where user_id=2";
		
		try {
			Connection connection =  DriverManager.getConnection(url);
			
			Statement st = connection.createStatement();
			
			int num = st.executeUpdate(update);
			if (num > 0) {
				System.out.println("Executed"+num);
				System.out.println("Updated");
			}
			else {
				System.out.println("Not Executed"+num);
				System.out.println("Not Updated");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
