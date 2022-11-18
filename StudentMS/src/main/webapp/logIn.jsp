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
        response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");
        %>
   Welcome are you teacher or student?
  <form action = "LogIn">
   
   <button name="action" value="Teacher">Teacher</button>
   
   <button name="action" value="Student">Student</button>
   </form>
</body>
</html>

