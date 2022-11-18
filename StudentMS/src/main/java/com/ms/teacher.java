package com.ms;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class teacher {

	
	public void InsertStudentMarks(Connection conn,String marks,String Student_id,String Subject_id){
        Statement statement;
        try {
            String query=String.format("Insert into %s(marks,subject_id,student_id) values('%s','%s','%s');","marks",marks,Student_id,Subject_id);
            statement = conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("Row Inserted");
        }catch (Exception e){
            System.out.println(e);
        }
    }
    // Read Data
    public String readData(Connection conn){
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
            
            String record="\n";
            while (rs.next()){
                String name = rs.getString("name");
                String department = rs.getString("department");
                String subject = rs.getString("subject_name");
                String marks = rs.getString("marks");
                String teacherName = rs.getString("teacher_name");
                record="\n"+record+"\n"+name+"\n"+department+"\n"+subject+"\n"+marks+"\n"+teacherName;
            }
            return record;
        }catch (Exception e){
            System.out.println(e);
        }
        return null;
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

    public String subjectName(Connection conn, String teacher_id){
        Statement statement;
        ResultSet rs;
        try {
            String query="select subject_name \n" +
                    "from subject\n" +
                    "inner join marks\n" +
                    "on marks.subject_id = subject.subject_id\n" +
                    "where teacher_id = '"+teacher_id+"'\n";
            statement = conn.createStatement();
            rs=statement.executeQuery(query);

            String subName;
            while (rs.next()) {
                String subject_name = rs.getString("subject_name");

                return subject_name;
            }

        }catch (Exception e){
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
	
	
}
