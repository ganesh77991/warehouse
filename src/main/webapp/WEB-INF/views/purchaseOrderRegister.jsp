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
  <form:form action="create" method="POST" modelAttribute="purchaseOrder">
  
  <pre>
  
    Order Code::<form:input path="shipmentCode"/>
    				
    
    Shipment Code::<form:select path="shipmentCode.code">
    			<form:option value="">--SELECT--</form:option>
    			<form:options items="" itemLabel="" itemValue=""/>
    			</form:select>
    
    
    Vendor::<form:select path="vendor.venId">
    		<form:option value="">--SELECT--</form:option>
    		<form:options items="" itemLabel="" itemValue=""/>
	</form:select>    
    Reserve Number::<form:input path="refNumber"/>
    
    Quality Check::<form:radiobutton path="purchaseCheck" value="required"/>Required <form:radiobutton path="purchaseCheck" value="not required"/>Not Required
  
    Default status::<form:input path="purchaseStatus"/>
    
    Description ::<form:textarea path="purchaseDescription"/>
    
      <input type="submit" value="Place Order">
      
  </pre>
  
  </form:form>

</body>
</html>