package com.ms;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Sinup
 */
@WebServlet("/Sinup")
public class Sinup extends HttpServlet {



	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		String ts = request.getParameter("action");
		if("SignIn".equals(ts)) {
			
			response.sendRedirect("landingPage.jsp");
		}
		else if("SignUp".equals(ts)) {
			
			response.sendRedirect("signUp.jsp");
		}
	}



}
