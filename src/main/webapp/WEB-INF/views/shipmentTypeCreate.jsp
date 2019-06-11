<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form:form action="create" modelAttribute="ship">
<pre>

  Shipment Mode::<form:select path="mode">
  				<form:option value="">-SELECT-</form:option>
  				<form:option value="air">Air</form:option>
  				<form:option value="truck">Truck</form:option>
  				<form:option value="ship">Ship</form:option>
  				<form:option value="train">Train</form:option>
              </form:select>
              <form:errors path="mode"/>
     Shipment Code::<form:input path="code"/>
              <form:errors path="code"/>
     
     Enable Shipment::<form:checkbox path="enabled" value="yes"/>Yes
                    <%--  <form:errors path="enabled"/> --%>
     
     Shipment Grade::<form:radiobutton path="grade" value="A"/> A <form:radiobutton path="grade" value="B"/> B <form:radiobutton path="grade" value="C"/> C
					<form:errors path="grade"/>
	Description :: <form:textarea path="dsc"/>
					<form:errors path="dsc"/>
	
	<input type="submit" value="Create Shipment">
</pre>
</form:form>
${message}

</body>
</html>