<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<style>
.card {
  box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2);
  max-width: 360px;
  margin-top: 50px;
  margin-left: 70px;
  margin-right: 40px;
  margin-bottom: auto;
  text-align: center;
  font-family: arial;
  flex: 35%;
  padding: 20px;
  
}

.price {
  color:rgb(252, 168, 90) ;
  font-size: 22px;
}

.card button {
  border: none;
  outline: 0;
  padding: 12px;
  color: white;
  background-color: rgb(252, 168, 90);
  text-align: center;
  cursor: pointer;
  width: 100%;
  font-size: 18px;
}

.card button:hover {
  opacity: 9.0;
}

* {
  box-sizing: border-box;
}

.row {
  display: flex;
}


</style>
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
	
	
	<div class="row">
		<c:forEach items="${spices}" var="spice">
			<div class="card">
				<img src="${spice.getPicture()}" alt="${spice.getName()}" style="width:100%">
				<h1> ${spice.getName()}</h1> 
				<p> Category: ${spice.getCategory()}</p>
				<p class="price">£${spice.getPrice()} per 100g</p>
				<p>${spice.description}</p>
				<p><button>Add to Cart</button></p>
			</div>
		</c:forEach>
	</div>

</body>
</html>