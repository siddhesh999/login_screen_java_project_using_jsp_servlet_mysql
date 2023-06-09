package com.loginapp.controller;

import com.loginapp.dao.UserDAO;
import com.loginapp.model.User;

/**
 * @author siddhesh
 *
 */
public class LoginController {

	private UserDAO userDAO;

	public LoginController() {
		userDAO = new UserDAO();
	}

	public boolean validateUser(String userId, String password) {
		User user = userDAO.getUser(userId);

		if (user != null && user.getPassword().equals(password)) {
			return true;
		}

		return false;
	}

}
