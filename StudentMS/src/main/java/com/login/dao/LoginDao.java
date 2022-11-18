package com.login.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class LoginDao {
	
    public Connection connectToDb(String dbname, String user, String pass) {
        Connection conn = null;
        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/" + dbname, user, pass);
            if (conn != null) {
                System.out.println("Connection Established");
            } else {
                System.out.println("Connection Failed");
            }
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
        return conn;
    }
    
    
    public String[] searchByName(Connection conn, String name){
        Statement statement;
        ResultSet rs;
        try {
            String query="select * From "+"teacher"+ " Where teacher_name ='"+name+"'";
            statement = conn.createStatement();
            rs=statement.executeQuery(query);

            while (rs.next()) {
                String id = rs.getString("teacher_id");
                String Teachername = rs.getString("teacher_name");
                String Pass = rs.getString("teacher_password");
                return new String[]{Teachername, Pass, id};
            }

        }catch (Exception e){
            System.out.println("Wrong USerName Or Password");
            System.out.println(e);
        }
        return null;
    }
    
    public void addTeacher(Connection conn, String name,String dep_id, String pass_word) {
        Statement statement;
        ResultSet rs = null;
        try {
            String query = "INSERT INTO teacher(teacher_name,department_id,teacher_password)\n" +
                    "VALUES ('" + name +"' , '"+ dep_id +"' , '"+ pass_word + "');\n";
            statement = conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("Query Executed");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public void readData(Connection conn){
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
            while (rs.next()){
                System.out.print("Student Name: "+rs.getString("name")+"\n");
                System.out.print("Department: "+rs.getString("department")+"\n");
                System.out.println("Subject Name: "+rs.getString("subject_name")+"\n");
                System.out.println("Marks: "+rs.getString("marks")+"\n");
                System.out.println("Teacher Name: "+rs.getString("teacher_name")+"\n");
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }

	
}
