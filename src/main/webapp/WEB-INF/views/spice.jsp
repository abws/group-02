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

	<form:form action="addItemGrams" modelAttribute="itemGram">
		<form:hidden path="spice" value="${spice.name}"/>
		<!--kilograms/stones input-->
		<form:input path="kilograms"/>
		<form:label path="kilograms">kilograms</form:label>	
		<!--grams/stones input-->
		<form:input path="grams"/>
		<form:label path="grams">grams</form:label>
		<br>
		<input type="submit" value="Add to Cart">
		
	</form:form>
</body>
</html>