package org.jsp.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PalindromeEmployeeDetails {
	public static void main(String[] args) {
		
		String url = 
		"jdbc:mysql://localhost:3306/tech41?user=root&password=12345";
		
		String select = 
		"select * from userinformation";
		
		try {
			Connection connection = DriverManager.getConnection(url);
			
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(select);
			if (rs.last()) {
				rs.beforeFirst();
				while (rs.next()) {
					int id = rs.getInt(1);
					int temp = id;
					int rev = 0;
					int last = 0;
					
					while (temp != 0) {
						last = temp % 10;
						rev = rev * 10 + last;
						temp = temp / 10;
					}
					if (rev == id) {
						System.out.println("Name of the UserInformation :"+rs.getString(2));
						System.out.println("Id of the UserInformation :"+rs.getInt(1));
					}
				}
			} else {
				System.out.println("Enter a Valid Information");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
