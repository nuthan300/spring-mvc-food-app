<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form:form action = "saveproduct" modelAttribute="product">
		Name : <form:input path="name"/><br><br>
		Type : <form:input path="type"/><br><br>
		Cost : <form:input path="cost"/><br><br>
		Description: <form:input path="description"/><br><br>
		ImageLink: <form:input path="imageLink" /><br><br>
		Offer: <form:input path = "offer" /><br><br>
		<form:button>Submit</form:button>
	</form:form>

</body>
</html>