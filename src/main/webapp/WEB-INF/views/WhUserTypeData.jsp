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

	<table border="1">
		<tr>
			<th>WhUser Id</th>
			<th>WhUser TYPE</th>
			<th>WhUser  CODE</th>
			<th>WhUser FORTYPE</th>
			<th>WhUser EMAIL</th>
			<th>WhUser CONTACT</th>
			<th>WhUser IDTYPE</th>
			<th>WhUser IFOTHER</th>
			<th>WhUser IDNUM</th>
			<th colspan="2">OPERATIONS</th>
		</tr>
			<c:forEach items="${whUsers}" var="whUser">
		<tr>
				<td><c:out value="${whUser.id }" /></td>
				<td><c:out value="${whUser.type}" /></td>
				<td><c:out value="${whUser.code }" /></td>
				<td><c:out value="${whUser.forType}" /></td>
				<td><c:out value="${whUser.email}" /></td>
				<td><c:out value="${whUser.contact}" /></td>
				<td><c:out value="${whUser.idType}" /></td>
				<td><c:out value="${whUser.ifOther}" /></td>
				<td><c:out value="${whUser.idNum}" /></td>
				<td><a href="delete?whUserTypeId=${whUser.id}">DELETE</a></td>
				<td><a href="update?whUserTypeId=${whUser.id}">UPDATE</a></td>
		</tr>
			</c:forEach>
	</table>	
	${message }

</body>
</html>