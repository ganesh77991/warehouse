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
	<form:form action="update" modelAttribute="OrderMethod">
		
	<pre>
	
  Order Id:<form:input path="id"/>
  
  Order Mode::<form:radiobutton path="mode" value="sale" />Sale <form:radiobutton path="mode" value="purchase" />Purchase
 
  Order Code::<form:input path="code" />
 
  Order Method::<form:select path="method">
  		<form:option value="">-SELECT-</form:option>
  		<form:option value="FIFO">FIFO</form:option>
  		<form:option value="LIFO">LIFO</form:option>
  		<form:option value="FCFO">FCFO</form:option>
  		<form:option value="FEFO">FEFO</form:option>
  </form:select>
  
  Order Accept:: <form:checkbox path="accept" value="Multi-model" />Multi-Model
  				 <form:checkbox path="accept" value="Accept-return" />Accept-Return
  				 
  Description::<form:textarea path="dsc" />
  
  		<input type="submit" value="update Order Method">
      </pre>
	</form:form>
	${message}
</body>
</html>