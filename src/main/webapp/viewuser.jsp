<%@page import="com.ty.food.dto.Item"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.ty.food.dto.FoodOrder"%>
<%@page import="java.util.List"%>
<%@page import="com.ty.food.dto.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<p>
		<a href="loaditem">New Order</a> Your Orders:
	</p>

	<table border="3">
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Phone</th>
			<th>Total</th>
			<th>Delete</th>
			<th>Generate Bill</th>
		</tr>

		<c:forEach var = "order" items = "${mylist}">
		<tr>
			<td>${order.getId()}</td>
			<td>${order.getName() }</td>
			<td>${order.getPhone() }</td>
			<td>${order.getTotal() }</td>
			<td><a href = "deleteuser?id=${order.getId()}">Delete</a>
			<td><a href = "generatebill?id=${order.getId()}">Bill</a>
		</tr>
	</c:forEach>

	</table>

</body>
</html>