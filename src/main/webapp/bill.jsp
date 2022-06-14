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
<table border="3">
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Quantity</th>
			<th>MRP</th>
			<th>cost</th>
		</tr>

		<c:forEach var = "order" items = "${displayorderlist}">
		<tr>
			<td>${order.getId()}</td>
			<td>${order.getName() }</td>
			<td>${order.getQuantity() }</td>
			<td>${order.getMrp() }</td>
			<td>${order.getCost() }</td>
		</tr>
	</c:forEach>

	</table>
<h3>Total: ${total }</h3>
<h3>CGST: ${CGST}</h3><br>
<h3>SGST: ${SGST}</h3><br>
<h3>Grand Total(including tax): ${totalbill}</h3>

</body>
</html>