<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form:form action="create" modelAttribute="user">
	<pre>
	User Type::<form:radiobutton path="type" value="vendor"/> Vendor <form:radiobutton path="type" value="customer"/> Customer
				<form:errors path="type"/>
				
	User Code::<form:input path="code"/>
			   <form:errors path="code"/>
			   
	User For::<form:input path="forType"/>
				<form:errors path="forType"/>
	
	User Email::<form:input path="email"/>
				<form:errors path="email"/>
	
	User Contact::<form:input path="contact"/>
				<form:errors path="contact"/>
	
	UserId Type::<form:select path="idType">
				<form:option value="">-SELECT-</form:option>
				<form:option value="pan">PAN</form:option>
				<form:option value="aadhar">AADHAR</form:option>
				<form:option value="voterId">VOTERID</form:option>
				<form:option value="other">OTHER</form:option>
	</form:select>
				<form:errors path="idType"/>
	
	If Other::<form:input path="ifOther"/>
				<form:errors path="ifOther"/>
	
	ID Number::<form:input path="idNum"/>
				<form:errors path="idNum"/>
				
	   <input type="submit" value="create User">
    </pre>
	</form:form>
	
	${message }

</body>
</html>