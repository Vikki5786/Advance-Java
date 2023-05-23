package com.jsp.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Registration {
	public static void main(String[] args) {
		
		String url =
		"jdbc:mysql://localhost:3306/tech41?user=root&password=12345";
		
		String insert = 
		"insert into student(Name, Email, MobileNumber, Password) values(?,?,?,?)";
		
		try {
			Connection connection = DriverManager.getConnection(url);
			PreparedStatement ps = connection.prepareStatement(insert);
			
			//Take RunTime Values
			
			Scanner scan = new Scanner(System.in);	
			
			System.out.println("Enter Your Name :");
			String name = scan.next();
			System.out.println("Enter Your Email Id :");
			String email = scan.next();
			System.out.println("Enter Your Mobile Number :");
			String mb = scan.next();
			System.out.println("Enter Your Password :");
			String password = scan.next();
			//Set the Values of the Place Holder
			
			ps.setString(1, name);
			ps.setString(2, email);
			ps.setString(3, mb);
			ps.setString(4, password);
			
			
			int num = ps.executeUpdate();
			
				if (num != 0) {
					System.out.println("Registration Sucessfully!");
				} else {
					System.out.println("Enter a Valid Details ?");
				}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
