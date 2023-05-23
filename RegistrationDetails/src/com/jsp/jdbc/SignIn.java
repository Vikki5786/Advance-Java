package com.jsp.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class SignIn {
	public static void main(String[] args) {
		
		String url = 
			"jdbc:mysql://localhost:3306/tech41?user=root&password=12345";
		
		String insert = 
			"insert into bank (Name, MobileNumber, Password) values (?, ?, ?)";
		
		try {
			Connection connection = DriverManager.getConnection(url);
			PreparedStatement ps = connection.prepareStatement(insert);
			Scanner scan = new Scanner(System.in);	
			System.out.println("Enter Your Name :");
			String name = scan.next();
			System.out.println("Enter Your MobileNumber :");
			String phno = scan.next();
			System.out.println("Enter Your Password :");
			String password = scan.next();
			ps.setString(1, name);
			ps.setString(2, phno);
			ps.setString(3, password);
			int num = ps.executeUpdate();
			if (num != 0) {
				System.out.println("Sign in Sucessfully In tech41 Bank Account");
			}
			else {
				System.out.println("Enter a Valid Details..");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
