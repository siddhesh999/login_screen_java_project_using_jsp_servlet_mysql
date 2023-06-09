package com.loginapp.servalet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.loginapp.controller.LoginController;

/**
 * @author siddhesh
 *
 */
@WebServlet("/login")
public class MainServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private LoginController loginController;

	public MainServlet() {
		loginController = new LoginController();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userId = request.getParameter("userId");
		String password = request.getParameter("password");

		boolean isValid = loginController.validateUser(userId, password);

		if (isValid) {
			request.setAttribute("username", userId);
			request.getRequestDispatcher("success.jsp").forward(request, response);
		} else {
			request.setAttribute("name", userId);
			request.getRequestDispatcher("error.jsp").forward(request, response);
		}
	}
}
