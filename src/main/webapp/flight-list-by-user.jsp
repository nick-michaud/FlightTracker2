<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Flight List</title>
</head>
<body>
<form method="post" action="listnavigationServlet">
<table>
<c:forEach items="${requestScope.allLists}" var="currentlist">
<tr>
	<td><input type="radio" name="id" value="${currentlist.id}"></td>
	<td><h2>${currentlist.listName}</h2></td>
</tr>
	
<tr>
	<td colspan="3">Trip Date: ${currentlist.tripDate}</td>
</tr>

<tr>
	<td colspan="3">Passenger: ${currentlist.passenger.passengerName}</td>
</tr>
<c:forEach var="listVal" items="${currentlist.listOfItems}">
<tr><td></td>
<td colspan="3">
${currentitem.id} ${currentitem.destination} ${currentitem.airline} ${currentitem.flightNumber}
</td>
</tr>
</c:forEach>
</c:forEach>
</table>
<input type="submit" value="edit" name="doThisToFlight">
<input type="submit" value="delete" name="doThisToFlight">
<input type="submit" value="add" name="doThisToFlight">

</form>
<a href="addItemsForListServlet">Create a new flight</a><br />
<a href="index.html">Insert a new flight</a>	
	
</body>
</html>