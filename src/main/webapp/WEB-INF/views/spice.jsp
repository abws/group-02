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
	<p>${spice.category}</p>
	<p>${spice.description}</p>
	<p>${spice.picture}</p>

	<p>Price per 100g: $ ${spice.price}</p>

	<form:form action="addItem" modelAttribute="item">
		<form:hidden path="spice" value="${spice.name}"/>
		<br>
		<form:label path="weightInGrams">Weight: </form:label>
		<form:input path="weightInGrams"/>
		<form:errors path="weightInGrams"/>
		<br>
		<input type="submit" value="Add to Cart">
		
	</form:form>
</body>
</html>