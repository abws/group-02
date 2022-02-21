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

	<!--form action and modelattribute will change onclick via js-->
	<form:form id="form" action="addItemGrams" modelAttribute="itemGram">
		<form:hidden path="spice" value="${spice.name}"/>
		<!--kilograms/stones input depending on js onlcik-->
		<form:input id="input-large" path="kilograms"/>
		<form:label id="label-large" path="kilograms">kilograms</form:label>	
		<!--grams/stones input depending on js onclick-->
		<form:input id="input-small" path="grams"/>
		<form:label id="label-small" path="grams">grams</form:label>
		<button id="units" type="button" onclick="unitSwitch()">Switch to Imperial Units</button>
		<br>
		<input type="submit" value="Add to Cart">
	</form:form>

	<script type="text/javascript">
		let y = false;

		function unitSwitch(){
			//currently at imperial units (pounds and ounces)
			if (!y) {
			y = true;
			document.getElementById("units").innerHTML = "Switch to Metric Units";
			document.getElementById("form").action = "addItemPounds";
			document.getElementById("form").modelAttribute = "itemPound";
			document.getElementById("input-large").path = "pounds";
			document.getElementById("input-small").path = "ounces";
			document.getElementById("label-large").innerHTML = "pounds";
			document.getElementById("label-small").innerHTML = "ounces";
		}

		//currently at metric units (kilograms and grams)
		else if (y) {
			y = false;
			document.getElementById("units").innerHTML = "Switch to Imperial Units";
			document.getElementById("form").action = "addItemGrams";
			document.getElementById("form").modelAttribute = "itemPound";
			document.getElementById("input-large").path = "kilograms";
			document.getElementById("input-small").path = "grams";
			document.getElementById("label-large").innerHTML = "kilograms";
			document.getElementById("label-small").innerHTML = "grams";
		}

		}
	</script>
</body>
</html>