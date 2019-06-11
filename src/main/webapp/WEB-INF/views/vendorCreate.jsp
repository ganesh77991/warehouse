<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	isELIgnored="false" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form:form action="create" method="POST" modelAttribute="vendor">
	
	<pre>
	
	Vendor Name::<form:input path="venName"/>
				<form:errors path="venName"/>
	
	Vendor Code::<form:input path="venCode"/>
				 <form:errors path="venCode"/>
	
	Vendor Desg::<form:radiobutton path="venDesg" value="sale"/>SALE <form:radiobutton path="venDesg" value="service"/>SERVICE<form:radiobutton path="venDesg" value="both"/>BOTH
				<form:errors path="venDesg"/>
				
	Vendor Preserve::<form:checkbox path="venPreserve" value="A"/>A
	        	 <form:checkbox path="venPreserve" value="B"/>B
		         <form:checkbox path="venPreserve" value="C"/>C
					  <form:errors path="venPreserve"/>
					  
					  <input type="submit" value="Register">
	
	</pre>
	
	
	</form:form>

	${message}
</body>
</html>