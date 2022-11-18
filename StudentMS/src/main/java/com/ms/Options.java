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
 * Servlet implementation class Options
 */
@WebServlet("/Options")
public class Options extends HttpServlet {
	
	LoginDao db= new LoginDao();
    Connection conn=db.connectToDb("postgres","postgres","admin");
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		PrintWriter out = response.getWriter();
		teacher  t = new teacher();
		String ts = request.getParameter("action");
		
		if("Enter Record".equals(ts)) {
			
			response.sendRedirect("enterRecord.jsp");
		}
		
		else if("Existing Record".equals(ts)) {
			
			Statement statement;
	        ResultSet rs=null;
	        try {
	            String query="select name,department,subject_name,marks,teacher_name\n" +
	                    "from student\n" +
	                    "inner join marks\n" +
	                    "on marks.student_id = student.student_id\n" +
	                    "inner join subject\n" +
	                    "on  subject.subject_id = marks.subject_id\n" +
	                    "inner join teacher\n" +
	                    "on teacher.teacher_id = subject.teacher_id\n" +
	                    "inner join department\n" +
	                    "on department.department_id = student.department_id ";
	            
	            statement = conn.createStatement();
	            rs=statement.executeQuery(query);
	            
	            out.print("<table border='1'>");
	            while (rs.next()) {
	            	
	            	out.print("<tr>");
	                out.print("<td>"+rs.getString("name")+"</td>");
	                out.print("<td>"+rs.getString("department")+"</td>");
	                out.print("<td>"+rs.getString("subject_name")+"</td>");
	                out.print("<td>"+rs.getString("marks")+"</td>");
	                out.print("<td>"+rs.getString("teacher_name")+"</td>");
	                out.print("</tr>");
	          
	            }
	            out.print("</table>");
	        }catch (Exception e){
	            System.out.println(e);
	        }
		}
		
		
		else if("Add Student".equals(ts)) {
	
	        response.sendRedirect("addStudent.jsp");
        }
		else if("Exit".equals(ts)) {
	
        	response.sendRedirect("logIn.jsp");
        }
		
	}
}
