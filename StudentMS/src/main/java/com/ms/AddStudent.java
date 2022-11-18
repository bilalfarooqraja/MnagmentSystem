package com.ms;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.login.dao.LoginDao;

/**
 * Servlet implementation class AddStudent
 */
@WebServlet("/AddStudent")
public class AddStudent extends HttpServlet {

	LoginDao db= new LoginDao();
    Connection conn=db.connectToDb("postgres","postgres","admin");
	Student s = new Student();
	
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String sname= request.getParameter("sname");	
		String ts = request.getParameter("action");
		String depId="N";
		if("CS".equals(ts)) {
			
			depId="1";
		}
		if("SE".equals(ts)) {
			
			depId="2";
		}
		if("EE".equals(ts)) {
			
			depId="3";
		}
		if("BBA".equals(ts)) {
			
			depId="4";
		}
		
		s.addStudent(conn, sname, depId);
		
		response.sendRedirect("options.jsp");
		
	}
}
