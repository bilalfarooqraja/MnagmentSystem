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
<form action="EnterRecord" method = "post">

     Student Roll# : <input type="text" name="sroll"><br>
     Marks : <input type="text" name="marks"><br>
     <button name="action" value="OOP">OOP</button><br>
   
     <button name="action" value="ITCP">ITCP</button><br>
   
     <button name="action" value="MATHS">MATHS</button><br>
   
     <button name="action" value="NW">NW</button><br>
 
</form>
</body>
</html>