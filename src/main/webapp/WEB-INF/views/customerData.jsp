<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	isELIgnored="false" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<table border="1">
		<tr>
			<th>CUSTOMER ID</th>
			<th>CUSTOMER CODE</th>
			<th>CUSTOMER ADDRESS</th>
			<th>CUSTOMER LOCATIONS</th>
			<th>CUSTOMER EMAIL</th>
			<th>CUSTOMER CONTACT</th>
			<th colspan="2">OPERATIONS</th>
		</tr>
		<c:forEach items="${customers}" var="customer">
			<tr>
				<td><c:out value="${customer.custId }" /></td>
				<td><c:out value="${customer.custCode }" /></td>
				<td><c:out value="${customer.custAddr }" /></td>
				<td><c:out value="${customer.custLocs }" /></td>
				<td><c:out value="${customer.custEmail }" /></td>
				<td><c:out value="${customer.custContact }" /></td>
				<td><a href="delete?custId=${customer.custId}">DELETE</a>
				<td><a href="update?custId=${customer.custId}">UPDATE</a>
			</tr>
		</c:forEach>

	</table>

	${message}
</body>
</html>