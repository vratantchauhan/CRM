<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div align=center>
<P>Customer Id: ${customer.id}<p>
<p>Name: ${customer.name}<p>
<P>Phone Number: ${customer.phoneNumber}<p>
<P>Email Id: ${customer.email}<p>
<P>Branch: ${customer.branch}<p>
<br><br>
<a href="/CRM/backToHomePage">Return to Home Page</a>
</div>

</body>
</html>