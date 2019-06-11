<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	isELIgnored="false" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
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



</head>
<body class="container">

		
		<div class="card">
		
		<div class="card-header bg-info">WELCOME TO VENDOR DATA</div>
		
		<div class="card-body">

	<c:choose><c:when test="${!empty vendors }">
	
	<table class="table table-hover">
		<tr>
			<th>Vendor ID</th>
			<th>Vendor NAME</th>
			<th>Vendor CODE</th>
			<th>Vendor DESG</th>
			<th>Vendor PRESERVE</th>
			
		</tr>
			<c:forEach items="${vendors}" var="vendor">
		<tr>
				<td><c:out value="${vendor.venId }" /></td>
				<td><c:out value="${vendor.venName }" /></td>
				<td><c:out value="${vendor.venCode }" /></td>
				<td><c:out value="${vendor.venDesg }" /></td>
				<td><c:out value="${vendor.venPreserve }" /></td>
				
				<td><a href="delete?vendorId=${vendor.venId }">DELETE</a></td>
				<td><a href="update?vendorId=${vendor.venId }">UPDATE</a></td>
		</tr>
			</c:forEach>
	</table>
	
	
	</c:when> <c:otherwise><h5 class="text-danger"> NO DATA FOUND</h5>
	</c:otherwise>  
	</c:choose>
	
	</div>  <!-- this is card body end tag -->
	
	<c:if test="${null ne message }">
	<div class="card-footer bg-info">
	${message}
	</div>  <!-- this is card footer -->
	</c:if>
	
	
	</div> <!-- this is card end tag -->
</body>
</html>