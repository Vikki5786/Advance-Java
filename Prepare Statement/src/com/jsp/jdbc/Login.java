package com.jsp.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;
import java.util.Scanner;

public class Login {
	public static void main(String[] args) {
		
		String url =
			"jdbc:mysql://localhost:3306/tech41?user=root&password=12345";
		
		String select = 
			"select * from userinformation where USER_EMAIL_ID = ? and USER_PASSWORD = ?";
		
		try {
			Connection connection = DriverManager.getConnection(url);
			 PreparedStatement ps =connection.prepareStatement(select);
			 Scanner scan = new Scanner(System.in);
			 System.out.println("Enter Your Mail Id :");
			 String mail = scan.next();
			 System.out.println("Enter Your Password :");
			 String password = scan.next();
			 ps.setString(1, mail);
			 ps.setString(2, password);
			 ResultSet rs = ps.executeQuery();
			 if (rs.next()) {
				 
				 System.out.println("Login Sucessfully");
				 
				 Random r = new Random();
				  int otp= r.nextInt(1000);
				  System.out.println("OTP PIN is "+otp);
			 }
			 else {
				 System.out.println("Invalid Details");
			 }
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
