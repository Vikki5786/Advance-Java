package org.jsp.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class EstablishingConnection {
	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306?user=root&password=12345";
		
		String insert = "insert into tech41.userinformation values(7,'Nandha',889770343,'Nandha40@gmail.com','Nandha@40')";
		try {
			Connection connection = DriverManager.getConnection(url);
			System.out.println("Connection established");

			Statement st = connection.createStatement();
			System.out.println("Plateform created");

			int num = st.executeUpdate(insert);
			if (num != 0) {
				System.out.println(num);

				System.out.println("Data inserted");
			} else {
				System.out.println("data not inserted");
			}

			connection.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
