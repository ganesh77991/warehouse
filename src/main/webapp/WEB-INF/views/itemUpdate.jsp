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
	<h1>Welcome to Item Register</h1>

	<form:form action="update" modelAttribute="item">
		<pre>
				
	  Item Id::<form:input path="itemId" readonly="true" />

      Item Code ::<form:input path="itemCode" />
      			  <form:errors path="itemCode" />

      Item Dimensions :: <form:input path="itemWidth" size="5" /> W <form:input
				path="itemLength" size="5" /> L <form:input path="itemHeight"
				size="5" /> H
      		<form:errors path="itemWidth" />     <form:errors
				path="itemLength" />     <form:errors path="itemHeight" />     
 
 	  Base Cost  ::<form:input path="itemBaseCost" />
      			  <form:errors path="itemBaseCost" />
 	  
 	  Base Currency ::<form:select path="itemBaseCurrency">
 	            
 	                <form:option value="">--SELECT--</form:option>
 	                <form:option value="INR">INR</form:option>
 	                <form:option value="USD">USD</form:option>
 	                <form:option value="AUS">AUS</form:option>
 	                <form:option value="ERU">ERU</form:option>
 	  </form:select>
      			  <form:errors path="itemBaseCurrency" />
 	  
 	  
 	  Item Uom::<form:select path="uom.id">
 	  				<form:option value="">--SELECT--</form:option>
 	  				<form:options items="${uoms}" itemLabel="model" itemValue="id" />
 	  </form:select>
      			  <form:errors path="uom.id" />
 	  
 	  Order Method :: (Sale Type)
 	  
 	     	<form:select path="salesType.id">
 	     	     <form:option value="">--SELECT--</form:option>
 	     	     <form:options items="${sales}" itemLabel="code"
					itemValue="id" />
 	     	</form:select> 
      			  <form:errors path="salesType.id" />
 	  
 	   Order Method :: (Purchase Type)
 	  
 	     	<form:select path="purchaseType.id">
 	     	     <form:option value="">--SELECT--</form:option>
 	     	     <form:options items="${purchases}" itemLabel="code"
					itemValue="id" />
 	     	</form:select>
      			  <form:errors path="purchaseType.id" />
          
       Item Vendors :<form:select path="venUsers" multiple="true">
       				<form:option value="">--SELECT--</form:option>
       				<form:options items="${vendors}" itemValue="id"
					itemLabel="code" />
       
       </form:select>
      			  <form:errors path="venUsers" />
       
       Item Customers:<form:select path="custUsers" multiple="true">
       				<form:option value="">--SELECT--</form:option>
					<form:options items="${customers}" itemValue="id" itemLabel="code" />
					
					</form:select>
      			  <form:errors path="custUsers" />
      			  
                 <input type="submit" value="update Item">
            </pre>
	</form:form>
	${message }
</body>
</html>