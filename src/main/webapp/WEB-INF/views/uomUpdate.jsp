<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
  .err {
	color: red
   }
</style>
</head>
<body>
	<h1>Welcome to UOM Register</h1>
	<form:form action="update" modelAttribute="uom">
		<pre>
		
		Uom Id::<form:input path="id" readonly="true" />

             UOM TYPE::<form:select path="type">
        <form:option value="">-SELECT-</form:option>
        <form:option value="packing">PACKING</form:option>
        <form:option value="nopacking">No PACKING</form:option>
        <form:option value="na">-NA-</form:option>
        
</form:select>
       <form:errors path="type" cssClass="err" />

       Uom Model::<form:input path="model" />
       <form:errors path="model" cssClass="err" />
 
       Description::<form:textarea path="dsc" />
       <form:errors path="dsc" cssClass="err" />
       
      <input type="submit" value="update Uom">


</pre>

	</form:form>
	${message }
</body>
</html>