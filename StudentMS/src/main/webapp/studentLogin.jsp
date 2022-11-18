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
 <form action="StudentLogin">
     Enter Student name : <input type="text" name="sname"><br>
    <input type="submit" value ="Submit">
</form>
</body>
</html>