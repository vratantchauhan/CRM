<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1 align=center>Customer Relationship Management System</h1>
<hr>
<div align=center>
<h3>welcome to login page</h3>
<form:form action="loggingin" modelAttribute="user">
<form:label path="id">Employee ID: </form:label>
<form:input path="id"/>
<form:errors path="id"></form:errors>
<br><br>
<form:label path="password">Password: </form:label>
<form:password path="password"/>
<form:errors path="password"></form:errors>
<br><br>
<input type="submit" value="Log in">
</form:form>
<br>
<h4><a href="signup">Sign up</a></h4>
</div>
</body>
</html>