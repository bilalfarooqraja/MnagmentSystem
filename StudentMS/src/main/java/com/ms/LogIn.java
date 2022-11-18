package com.ms;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.login.dao.LoginDao;

@WebServlet("/LogIn")
public class LogIn extends HttpServlet {

 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		
		String ts = request.getParameter("action");
		if("Teacher".equals(ts)) {
			
			response.sendRedirect("sinup.jsp");
		}
		else if("Student".equals(ts)) {
			
			response.sendRedirect("studentLogin.jsp");
		}

	}

}





