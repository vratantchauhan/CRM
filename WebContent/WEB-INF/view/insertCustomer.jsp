<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Save Customer</title>
</head>
<body>
<div align=center>
<form:form action="saveResultt" method="POST" modelAttribute="customer">
<br><br>
<form:label path="name">Name: </form:label>
<form:input path="name"/>
<form:errors path="name"></form:errors>
<br><br>

<form:label path="phoneNumber">Phone Number: </form:label>
<form:input path="phoneNumber"/>
<form:errors path="phoneNumber"></form:errors>

<br><br>
<form:label path="email">email: </form:label>
<form:input path="email"/>
<form:errors path="email"></form:errors>

<br><br>
<form:label path="branch">branch: </form:label>
<form:input path="branch"/>
<form:errors path="branch"></form:errors>

<br><br>
<input type="submit" value="Save Customer"/>
</form:form> 
</div>
</body>
</html>