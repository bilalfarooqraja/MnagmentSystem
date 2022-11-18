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

import org.apache.catalina.connector.Response;

import com.login.dao.LoginDao;


@WebServlet("/StudentLogin")
public class StudentLogin extends HttpServlet {

	
	LoginDao db= new LoginDao();
    Connection conn=db.connectToDb("postgres","postgres","admin");
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		String sname = request.getParameter("sname");
		Statement statement;
        ResultSet rs = null;
        try {
            String query = "select name,subject_name,marks,teacher_name,department\r\n"
            		+ "from student\r\n"
            		+ "inner join marks\r\n"
            		+ "on marks.student_id = student.student_id\r\n"
            		+ "inner join subject\r\n"
            		+ "on subject.subject_id= marks.subject_id\r\n"
            		+ "inner join teacher\r\n"
            		+ "on teacher.teacher_id = subject.teacher_id \r\n"
            		+ "inner join department\r\n"
            		+ "on department.department_id = teacher.department_id \r\n"
            		+ "WHERE name = '"+sname+"';";
            statement = conn.createStatement();
            rs = statement.executeQuery(query);
            
            out.print("<table border='1'>");
            while (rs.next()) {
            	
            	out.print("<tr>");
                out.print("<td>"+rs.getString("name")+"</td>");
                out.print("<td>"+rs.getString("subject_name")+"</td>");
                out.print("<td>"+rs.getString("marks")+"</td>");
                out.print("<td>"+rs.getString("teacher_name")+"</td>");
                out.print("<td>"+rs.getString("department")+"</td>");
                out.print("</tr>");
          
            }
            out.print("</table>");
        } catch (Exception e) {
            System.out.println(e);
        }
	}	
	}
