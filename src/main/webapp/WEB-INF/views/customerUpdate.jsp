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
	<form:form action="update" method="POST" modelAttribute="customer">
		
	<pre>
	
	   Customer Id::<form:input path="custId"/>
	
       Customer Code::   <form:input path="custCode"/>
						<form:errors  path="custCode"/>
	
	Customer Address::<form:input path="custAddr"/>
						<form:errors  path="custAddr"/>
	
	Customer Locotions::<form:select path="custLocs" multiple="true">
					<form:option value="HYD">HYD</form:option>
					<form:option value="BAN">BAN</form:option>
					<form:option value="CHN">CHN</form:option>
	</form:select>
						<form:errors  path="custLocs"/>
	
	Customer Enabled::<form:radiobutton path="custEnabled"/> YES
						<form:errors  path="custEnabled"/>
	
	Customer Email::<form:input path="custEmail"/>
						<form:errors  path="custEmail"/>
	
	Customer Contact::<form:input path="custContact"/>
						<form:errors  path="custContact"/>  
  		<input type="submit" value="Update">
      </pre>
	</form:form>
	${message}
</body>
</html>