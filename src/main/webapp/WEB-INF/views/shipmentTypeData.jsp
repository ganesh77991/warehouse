<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table border="1" >
		<tr>
			<th>Shipment Id</th>
			<th>Shipment Mode</th>
			<th>Shipment Code</th>
			<th>Shipment Enabled</th>
			<th>Shipment Grade</th>
			<th>Shipment Dsc</th>
		</tr>
		<c:forEach items="${ships}" var="ship">
		
			<tr>
				<td><c:out value="${ship.id}"></c:out></td>
				<td><c:out value="${ship.mode }"></c:out></td>
				<td><c:out value="${ship.code }"></c:out></td>
				<td><c:out value="${ship.enabled }"></c:out></td>
				<td><c:out value="${ship.grade }"></c:out></td>
				<td><c:out value="${ship.dsc }"></c:out></td>
				<td><a href="delete?shipId=${ship.id }">DELETE</a></td>
				<td><a href="update?shipId=${ship.id }">UPDATE</a></td>
			</tr>
		</c:forEach>
	</table>



	${message}

</body>
</html>