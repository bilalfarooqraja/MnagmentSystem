<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
        
        <%
        if(session.getAttribute("username")==null){
        	
        	response.sendRedirect("logIn.jsp");
        }
        response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");
        %>
<form action = "Options">
   
   <button name="action" value="Enter Record">Enter Record</button><br>
   
   <button name="action" value="Existing Record">Existing Record</button><br>
   
   <button name="action" value="Add Student">Add Student</button><br>
   
   <button name="action" value="Exit">Exit</button><br>
   
   </form>
   
   
   
</body>
</html>