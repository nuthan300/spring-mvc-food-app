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
		<table border = "3">
			<tr>
				<th> ID</th>
				<th>Name</th>
				<th>Description</th>
				<th>Type</th>
				<th>imageLink</th>
				<th>offer</th>
				<th>cost</th>
				<th>Add</th>
			</tr>
			<c:forEach var = "list" items = "${mylist}">
				<tr>
					<td>${list.getId()}</td>
					<td>${list.getName() }</td>
					<td>${list.getDescription() }</td>
					<td>${list.getType() }</td>
					<td>${list.getImageLink() }</td>
					<td>${list.getOffer() }</td>
					<td>${list.getCost() }</td>
					<td><a href = "additems?productid=${list.getId()}">add</a>
	<!--  			<td><input path="q${list.getId()}" value = "0"/> </td>
					<td><input path="r${list.getId()}" value = "-"/> </td>-->	
				</tr>
			</c:forEach>
		</table>
	<form action="loadorder">
		<input type = "submit">
	</form>
</body>
</html>