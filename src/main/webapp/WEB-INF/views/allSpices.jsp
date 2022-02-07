<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Spices</title>
</head>
<body>

	<c:forEach items="${spices}" var="spice">
	<h3> ${spice.getName()} : ${spice.getPrice()} per 100g </h3>
	<img src="${spice.getPicture()}" alt="${spice.getName()}">
	
	</c:forEach>

</body>
</html>