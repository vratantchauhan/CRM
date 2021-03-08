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
<p>${customer.name}</p>
<P>${customer.phoneNumber}</p>
<form:form action="updateResult" modelAttribute="customer">
<form:label path="id">updating customer with id ${customer.id}</form:label>
<br>
<form:label path="name">Update name to: </form:label>
<form:input path="name"/>
<br>
<form:label path="phoneNumber">Update phone number to: </form:label>
<form:input path="phoneNumber"/>
<br>
<form:label path="email">Update email to: </form:label>
<form:input path="email"/>
<br>
<form:label path="branch">Update branch to: </form:label>
<form:input path="branch"/>
<br>
<input type="submit" value="update Customer">
</form:form>
</body>
</html>