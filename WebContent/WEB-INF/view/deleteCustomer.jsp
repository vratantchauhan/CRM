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
<div align=center>
<br>
<form:form action="deleteResult" modelAttribute="customer">
<form:label path="id">Enter customer id</form:label>
<form:input path="id"/>
<input type="submit" value="delete Customer"/>
</form:form>
</div>

</body>
</html>