<%@ page contentType="text/html; charset=UTF-8" %> 
<!DOCTYPE html>
<html>
<head>
	<jsp:include page="base.jsp" />
	<title>${item.getSpices().getName()}</title>
</head>
<body>
	<p>${item.getSpices().getName()}</p>
	<p>Price per 100g: $ ${item.getSpices().getPrice()}</p>
	<p>${item.weightInGrams}</p>
	<p>${item.weightInPounds}</p>
	<p>${item.price}</p>
</body>
</html>