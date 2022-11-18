package com.ms;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.login.dao.LoginDao;

/**
 * Servlet implementation class SignUp
 */
@WebServlet("/SignUp")
public class SignUp extends HttpServlet {

	 teacher t= new teacher();
	 LoginDao db= new LoginDao();
	 Connection conn=db.connectToDb("postgres","postgres","admin");
	 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	     
		
		  String name = request.getParameter("name");
		  
		  String password = request.getParameter("password");
		 
		  String action = request.getParameter("action");
		  String dep="0";
		  if("CS".equals(action)) {
			   dep="1";
		  }
		  else if("SE".equals(action)) {
			   dep="1";
		  }
		  else if("EE".equals(action)) {
			   dep="1";
		  }
		  else if("BBA".equals(action)) {
			   dep="1";
		  }
		  
		t.addTeacher(conn, name, dep, password);
		
		response.sendRedirect("landingPage.jsp");
	}

}
