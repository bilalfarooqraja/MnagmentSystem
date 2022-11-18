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
<form action="AddStudent" method = "post">

     Student Name : <input type="text" name="sname"><br>
     Select Department
     <button name="action" value="CS">CS</button><br>
   
     <button name="action" value="SE">SE</button><br>
   
     <button name="action" value="EE">EE</button><br>
   
     <button name="action" value="BBA">BBA</button><br>
 
</form>
    
</body>
</html>