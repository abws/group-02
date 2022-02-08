<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<jsp:include page="nav.jsp" />
<title>Spices</title>
</head>
<body>
	<h2>Categories</h2>

	<div class="vertical-menu">	
	  <a href="/spices" class="active">All</a>
	  <a href="/spices/Spice_Blends">Spice Blends</a>
	  <a href="/spices/Peppers">Peppers</a>
	  <a href="/spices/Salts">Salts</a>
	</div>
	
	
	<div class="sort">
		<a href="/spices/a-z" class="active">A-Z</a>
	  	<a href="/spices/z-a">Z-A</a>
	  	<a href="/spices/price_asc">Price Ascending</a>
	  	<a href="/spices/price_dsc">Price Descending</a>
	  	
	</div>
	
	<label for="sorting">Sort By:</label>
 		 <select name="sort" id="sort" onchange="location.reload()">
			<option value="a-z">A-Z</option>
		  	<option value="z-a">Z-A</option>
		  	<option value="ascending">Price Ascending</option>
		  	<option value="descending">Price Descending</option>
	  	</select>
	
	<c:forEach items="${spices}" var="spice">
		<h3> ${spice.getName()} : £${spice.getPrice()} per 100g </h3>
		<p> Category: ${spice.getCategory()}</p>
		<img src="${spice.getPicture()}" alt="${spice.getName()}">
	
	</c:forEach>

</body>
</html>