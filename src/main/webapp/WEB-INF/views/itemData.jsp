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

		<div class="card-header bg-info">WELCOME TO ITEM DATA</div>

		<div class="card-body">

			<c:choose>
				<c:when test="${!empty items }">

					<table class="table table-hover">
						<tr>
							<th>Item Id</th>
							<th>Item Code</th>
							<th>Item Dimensions</th>
							<th>Item BaseCost</th>
							<th>Item BaseCurrency</th>
							<th>Item SaleType</th>
							<th>Item PurchaseType</th>
							<th colspan="2">OPERATIONS</th>
						</tr>
						<c:forEach items="${items}" var="item">
							<tr>
								<td><c:out value="${item.itemId }" /></td>
								<td><c:out value="${item.itemCode}" /></td>
								<td>W:<c:out value="${item.itemWidth}" /> , L:<c:out
										value="${item.itemLength}" /> , H:<c:out
										value="${item.itemHeight}" />
								</td>
								<td><c:out value="${item.itemBaseCost}" /></td>
								<td><c:out value="${item.itemBaseCurrency}" /></td>
								<td><c:out value="${item.salesType.code}" /></td>
								<td><c:out value="${item.purchaseType.code}" /></td>
								<td><c:forEach items="${itm.venUsers}" var="ven">
										<c:out value="${ven.userCode}" />,
	            </c:forEach></td>
								<td><c:forEach items="${itm.custUsers}" var="cust">
										<c:out value="${cust.userCode}" />,
	             </c:forEach></td>

								<td><a href="delete?itemId=${item.itemId}">DELETE</a></td>
								<td><a href="update?itemId=${item.itemId}">UPDATE</a></td>
							</tr>
						</c:forEach>
					</table>


				</c:when>
				<c:otherwise>
				
					<h5 class="text-danger">NO DATA FOUND</h5>
				</c:otherwise>
			</c:choose>


		</div>
		<!-- this is card body tag -->

		<c:if test="${null ne message }">
			<div class="card-footer bg-info">${message}</div>
			<!-- this is card footer -->
		</c:if>

	</div>
	<!--  this is card-end tag -->
</body>
</html>