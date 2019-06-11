<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	isELIgnored="false" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Bootstrap Example</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
  <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" >

</head>
<body>

<div class="container">
<div class="card">

<div class="card-header bg-info text-white">
  WELCOME TO UOM DATA TABLE
</div>  <!-- this is card-header end tag -->

<div class="card-body">

	
	<c:choose>
	
	<c:when test="${!empty uoms }">
		
	<table class="table table-hover table-bordered">
		<tr class="bg-secondary text-white">
			<th>UId</th>
			<th>UTYPE</th>
			<th>UMODEL</th>
			<th>UDSC</th>
			<th colspan="2">OPERATIONS</th>
		</tr>
			<c:forEach items="${uoms}" var="uom">
		<tr>
				<td><c:out value="${uom.id }" /></td>
				<td><c:out value="${uom.type}" /></td>
				<td><c:out value="${uom.model }" /></td>
				<td><c:out value="${uom.dsc}" /></td>
				<td><a href="delete?uomId=${uom.id}" class="btn btn-danger">DELETE</a></td>
				<td><a href="update?uomId=${uom.id}" class="btn btn-warning">UPDATE</a></td>
		</tr>
			</c:forEach>
	</table>
	
	</c:when>
	<c:otherwise>
	<h3 class="text-danger"> NO RECORDS FOUND </h3>
	
	</c:otherwise>
	</c:choose>
	
	</div> <!-- this is the card-body end tag --> 
	
	<c:if test="${message ne null }">
	<div class="card-footer bg-info" >
	
	<div class="bg-info text-white">
	${message}
	</div>
	</div> <!-- this is card-footer end tag -->
	</c:if>
	
	</div> <!-- this is div end tag -->
	</div>  <!-- this is container end tag -->
</body>
</html>