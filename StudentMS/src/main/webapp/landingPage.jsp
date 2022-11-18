<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

</head>
<body>
    <%
        response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");
        %>
        
 <form action="landingPage">
     Enter username : <input type="text" name="uname"><br>
     Enter password : <input type="password" name="pass"><br>
    <input type="submit" value ="logIn">
</form>
</body>
</html>