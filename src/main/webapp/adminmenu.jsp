<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h3>${msg}</h3>
	<p>
		<a href = "adduser">Add User</a><br><br>
		<a href = "deleteuser">Delete User</a><br><br>
		<a href = "loadproduct">Add Product</a><br><br> 
		<a href = "viewproduct">View Product</a><br><br>
		<a href = "login.jsp">Log Out</a>
	</p>
</body>
</html>