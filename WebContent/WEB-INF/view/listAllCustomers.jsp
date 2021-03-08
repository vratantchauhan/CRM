<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.CRM.Customer" %>
    <%@ page import="java.util.List" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Customers</title>
</head>
<body>
<div align=center>
<table border="1"> 
		<thead> 
			<tr> 
				<th>Customer Id</th> 
				<th>Name</th> 
				<th>Phone Number</th>
				<th>Email id</th>
				<th>Branch</th>    
			</tr> 
		</thead> 
		<tbody> 
		<c:forEach items="${customer}" var="item" varStatus="status">
			<tr>
			<td><c:out value="${item.id}" /></td>
			<td><c:out value="${item.getName()}" /></td>
			<td ><c:out value="${item.phoneNumber}" /></td>
			<td ><c:out value="${item.email}" /></td>
			<td ><c:out value="${item.branch}" /></td>
			</tr>
		</c:forEach>
		</tbody>
		</table> 
		<br>
		<a href="/CRM/backToHomePage">Return to Home Page</a>
</div>

</body>
</html>