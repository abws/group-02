<%@ page contentType="text/html; charset=UTF-8" %> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
	<jsp:include page="base.jsp" />
	<title>${spice.name}</title>
</head>
<body>
	<p>${spice.name}</p>
	<p>Price per 100g: $ ${spice.price}</p>

	<form:form method="POST", action="addItem?${spice.name}">
		<form></form>
		
	</form:form>
</body>
</html>