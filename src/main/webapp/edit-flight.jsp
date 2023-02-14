<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action = "editFlightServlet" method ="post">
Destination: <input type ="text" name = "destination" value= "${itemToEdit.destination}">
Airline: <input type = "text" name = "airline" value = "${itemToEdit.airline }">
Flight Number: <input type = "text" name = "flight number" value = "${itemToEdit.flightNumber}">
<input type = "hidden" name = "id" value = "${itemToEdit.id}">
<input type = "submit" value ="Save Edited Item">
</form>
</body>
</html>