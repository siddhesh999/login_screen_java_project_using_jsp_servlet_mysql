package com.loginapp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.loginapp.model.User;

/**
 * @author siddhesh
 *
 */
public class UserDAO {

	private static final String JDBC_URL = "jdbc:mysql://localhost:3306/logindb";
	private static final String DB_USER = "root";
	private static final String DB_PASSWORD = "root";

	public User getUser(String userId) {
		User user = null;

		try {
			Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASSWORD);
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM users WHERE userId = ?");
			stmt.setString(1, userId);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				String password = rs.getString("password");
				user = new User(userId, password);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return user;
	}

}
