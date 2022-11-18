package com.ms;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Student {

     	    public String searchByName(Connection conn, String name) {
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
	            		+ "WHERE name = '"+name+"';";
	            statement = conn.createStatement();
	            rs = statement.executeQuery(query);
	            String data ="";
	            while (rs.next()) {
	            	
	                String studentname = rs.getString("name");
	                String subjectname = rs.getString("subject_name");
	                String marks = rs.getString("marks");
	                String tname = rs.getString("teacher_name");
	                String dep = rs.getString("department");
	               return data = studentname+"\n"+subjectname+"\n"+marks+"\n"+tname+"\n"+dep;
	            }
	        } catch (Exception e) {
	            System.out.println(e);
	        }
	        return null;
	    }

	    public void searchById(Connection conn, String studentId) {
	        Statement statement;
	        ResultSet rs = null;
	        try {
	            String query = "select name,department,subject_name,marks,teacher_name\n" +
	                    "from student\n" +
	                    "inner join marks\n" +
	                    "on marks.student_id = student.student_id\n" +
	                    "inner join subject\n" +
	                    "on  subject.subject_id = marks.subject_id\n" +
	                    "inner join teacher\n" +
	                    "on teacher.teacher_id = subject.teacher_id\n" +
	                    "inner join department\n" +
	                    "on department.department_id = student.department_id \n" +
	                    "WHERE student.student_id ='"+studentId+"';";
	            statement = conn.createStatement();
	            rs = statement.executeQuery(query);
	            while (rs.next()) {
	                System.out.print("Student Name: "+rs.getString("name") + "\n");
	                System.out.print("Department: "+rs.getString("department") + "\n");
	                System.out.println("Subject Name: "+rs.getString("subject_name") + "\n");
	                System.out.println("Marks: "+rs.getString("marks") + "\n");
	                System.out.println("Teacher Name: "+rs.getString("teacher_name") + "\n");
	            }
	        } catch (Exception e) {
	            System.out.println(e);
	        }
	    }

	    public String[] searchSubject(Connection conn, String studentId) {
	        Statement statement;
	        ResultSet rs = null;
	        try {
	            String query = "select subject_name\n" +
	                    "from subject\n" +
	                    "inner join marks\n" +
	                    "on marks.subject_id = subject.subject_id\n" +
	                    "where student_id = "+studentId;
	            statement = conn.createStatement();
	            rs = statement.executeQuery(query);

	            int tem=0;
	            while (rs.next()) {
	                String subname = rs.getString("subject_name");
	                return new String[]{subname};
	            }
	        } catch (Exception e) {
	            System.out.println(e);
	        }
	        return null;
	    }

	    public void addStudent(Connection conn, String name,String dep_id) {
	        Statement statement;
	        ResultSet rs = null;
	        try {
	            String query = "INSERT INTO student(name,department_id)\n" +
	                    "VALUES ('" + name +"' , '"+dep_id + "');\n";
	            statement = conn.createStatement();
	            statement.executeUpdate(query);
	            System.out.println("Query Executed");
	        } catch (Exception e) {
	            System.out.println(e);
	        }
	    }
}
