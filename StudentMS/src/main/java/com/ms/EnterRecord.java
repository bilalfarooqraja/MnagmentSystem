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
 * Servlet implementation class EnterRecord
 */
@WebServlet("/EnterRecord")
public class EnterRecord extends HttpServlet {

	LoginDao db= new LoginDao();
    Connection conn=db.connectToDb("postgres","postgres","admin");
	Student s= new Student();
	teacher t = new teacher();
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String sroll= request.getParameter("sroll");
		String sname= request.getParameter("sname");
		String marks= request.getParameter("marks");
		
		String ts = request.getParameter("action");
		String subjectId="N";
		if("OOP".equals(ts)) {
			
			subjectId="1";
		}
		if("ITCP".equals(ts)) {
			
			subjectId="2";
		}
		if("MATHS".equals(ts)) {
			
			subjectId="3";
		}
		if("NW".equals(ts)) {
			
			subjectId="4";
		}
		
		t.InsertStudentMarks(conn, marks, subjectId, sroll);
		
		response.sendRedirect("options.jsp");
	}

}
