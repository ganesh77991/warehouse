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

	<form:form action="update" modelAttribute="user">
	<pre>
	
	User Id::<form:input path="id"/>
	
	User Type::<form:radiobutton path="type" value="vendor"/> Vendor <form:radiobutton path="type" value="customer"/> Customer
	
	User Code::<form:input path="code"/>
	
	User For::<form:input path="forType"/>
	
	User Email::<form:input path="email"/>
	
	User Contact::<form:input path="contact"/>
	
	UserId Type::<form:select path="">
				<form:option value="">-SELECT-</form:option>
				<form:option value="pan">PAN</form:option>
				<form:option value="aadhar">AADHAR</form:option>
				<form:option value="voterId">VOTERID</form:option>
				<form:option value="other">OTHER</form:option>
	</form:select>
	
	If Other::<form:input path="ifOther"/>
	
	ID Number::<form:input path="idNum"/>
	   <input type="submit" value="Update User">
    </pre>
	</form:form>
	
	${message }

</body>
</html>