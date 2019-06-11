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
<form:form action="update" modelAttribute="ship">
<pre>


  Shipment Id::<form:input path="id"/>

  Shipment Mode::<form:select path="mode">
  				<form:option value="">-SELECT-</form:option>
  				<form:option value="air">Air</form:option>
  				<form:option value="truck">Truck</form:option>
  				<form:option value="ship">Ship</form:option>
  				<form:option value="train">Train</form:option>
              </form:select>
     Shipment Code::<form:input path="code"/>
     
     Enable Shipment::<form:checkbox path="enabled" value="yes"/>Yes
     
     Shipment Grade::<form:radiobutton path="grade" value="A"/> A <form:radiobutton path="grade" value="B"/> B <form:radiobutton path="grade" value="C"/> C

	Description :: <form:textarea path="dsc"/>
	<input type="submit" value="Update Shipment">
</pre>
</form:form>
${message}

</body>
</html>