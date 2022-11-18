package com.ms;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.login.dao.LoginDao;

/**
 * Servlet implementation class landingPage
 */
@WebServlet("/landingPage")
public class landingPage extends HttpServlet {
	
    teacher t= new teacher();
    LoginDao db= new LoginDao();
    Connection conn=db.connectToDb("postgres","postgres","admin");

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		PrintWriter out = response.getWriter();
		
		  String uname = request.getParameter("uname");
		  
		  String pass = request.getParameter("pass");
		  
		  String array[]=t.searchByName(conn, uname);
		  
		  if(uname.equals(array[0]) && pass.equals(array[1])) {
		 
			  HttpSession session = request.getSession();
		  
			  session.setAttribute("username", uname);
		  
			  response.sendRedirect("options.jsp"); }
		  else {
			  out.println("Wrong PassWord Or UserName");
			  response.sendRedirect("landingPage.jsp");
		  }
		 
	}
	}

	
