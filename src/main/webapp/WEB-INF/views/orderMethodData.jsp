<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	isELIgnored="false" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Bootstrap Example</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<link
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
	rel="stylesheet">

<title>Insert title here</title>
</head>
<body class="container">

	

	<div class="card">
		<div class="card-header bg-info">WELCOME TO ORDER METHOD DATA</div>
		<div class="card-body">
			<c:choose>
				<c:when test="${!empty orderMethods}">
					<table class="table table-hover">
						<tr class="bg-primary">
							<th>ORDER ID</th>
							<th>ORDER MODE</th>
							<th>ORDER CODE</th>
							<th>ORDER METHOD</th>
							<th>ORDER ACCEPT</th>
							<th>ORDER DESCRIPTION</th>
							<th colspan="2">ORDER OPERATIONS</th>
						</tr>
						<c:forEach items="${orderMethods}" var="orderMethod">
							<tr>
								<td><c:out value="${orderMethod.id }" /></td>
								<td><c:out value="${orderMethod.mode}" /></td>
								<td><c:out value="${orderMethod.code}" /></td>
								<td><c:out value="${orderMethod.method}" /></td>
								<td><c:out value="${orderMethod.accept}" /></td>
								<td><c:out value="${orderMethod.dsc}" /></td>
								<td><a href="delete?orderMethodId=${orderMethod.id }">DELETE</a></td>
								<td><a href="update?orderMethodId=${orderMethod.id }">UPDATE</a></td>
							</tr>
						</c:forEach>
					</table>

				</c:when>
				<c:otherwise>
					<h5 class="text-danger">NO RECORDS FOUND</h5>
				</c:otherwise>

			</c:choose>
			
			<c:if test="${null ne message}">
			<div class="card-footer bg-info">${message}</div>
			<!-- this is card footer end tag -->
			</c:if>

		</div>
		<!-- this is cord body end tag -->


	</div>
	<!-- this is card end tag -->
</body>
</html>