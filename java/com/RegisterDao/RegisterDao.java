package com.RegisterDao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RegisterDao {
	
	String sql = "Insert into users values (?, ?)";
	String url = "jdbc:mysql://localhost:3306/LoginModule";
	String username = "root";
	String password = "*****";
	public void RegisterAccount(String uname, String pword) throws SQLException {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url,username,password);
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, uname);
			st.setString(2, pword);
			st.executeUpdate();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
}
