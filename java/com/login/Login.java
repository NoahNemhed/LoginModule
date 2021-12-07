package com.login;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.LoginDao.LoginDao;


@WebServlet("/Login")
public class Login extends HttpServlet {


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String uname = request.getParameter("uname");
		String pword = request.getParameter("pword");
		LoginDao dao = new LoginDao();
		
		try {
			if(dao.check(uname, pword)) {
					
				HttpSession session = request.getSession();
				session.setAttribute("uname", uname);
				response.sendRedirect("welcome.jsp");
				
			}else {
		        request.setAttribute("errorMessage", "Invalid user or password");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}



}
