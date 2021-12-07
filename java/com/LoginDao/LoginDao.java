package com.LoginDao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;


public class LoginDao {
	String sql = "select * from users where Username=? and Password=?";
	String url = "jdbc:mysql://localhost:3306/LoginModule";
	String username = "root";
	String password = "********";
	public boolean check(String uname, String pword) throws SQLException {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url,username,password);
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, uname);
			st.setString(2, pword);
			ResultSet rs = st.executeQuery();
			if(rs.next()) {
				 return true;
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		return false;
	}
}
