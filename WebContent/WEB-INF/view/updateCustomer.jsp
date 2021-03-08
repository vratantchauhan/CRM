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
<form:form action="listCustomerResultForUpdate" modelAttribute="customer">
<form:label path="id">Enter customer Id: </form:label>
<form:input path="id"/>
<input type="submit" value="Update Customer"/>
</form:form>
</div>
</body>
</html>