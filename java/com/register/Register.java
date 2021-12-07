package com.register;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.LoginDao.LoginDao;
import com.RegisterDao.RegisterDao;

@WebServlet("/Register")
public class Register extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LoginDao ldao = new LoginDao();
		RegisterDao rdao = new RegisterDao();
		String uname = request.getParameter("uname");
		String pword = request.getParameter("pword");
		
		try {
			if(ldao.check(uname, pword)) {
		        request.setAttribute("Failed", "Failed to register");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}else {
				rdao.RegisterAccount(uname, pword);
		        request.setAttribute("Sucsess", "Account has been registred");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
