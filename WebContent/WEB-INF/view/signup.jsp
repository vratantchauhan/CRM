<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sign up</title>
</head>
<body>
<h1 align=center>Customer Relationship Management System</h1>
<hr>
<div align=center>
<br><br>
<form:form action="register" modelAttribute="user">
<form:label path="userName">Username: </form:label>
<form:input path="userName"/>
<form:errors path="userName"></form:errors>
<br><br>
<form:label path="email">Email id: </form:label>
<form:input path="email"/>
<form:errors path="email"></form:errors>
<br><br>
<form:label path="PhoneNumber">phone Number: </form:label>
<form:input path="PhoneNumber"/>
<form:errors path="PhoneNumber"></form:errors>
<br><br>
<form:label path="password">Password: </form:label>
<form:password path="password"/>
<br>
<form:errors path="password"></form:errors>
<br><br>

<input type="submit" value="Sign up">
</form:form>
<h4><a href="login">Log in</a></h4>
</div>
</body>
</html>