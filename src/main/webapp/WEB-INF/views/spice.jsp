<%@ page contentType="text/html; charset=UTF-8" %> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>

<style>

html, body {
  height: 100%;
  width: 100%;
  margin: 0;
  
 	
	font-family: 'Arial';
		
		
}

.container {
  max-width: 1200px;
  margin: 0 auto;
  padding: 15px;
  display: flex;
}

/* Columns */
.left-column {
  width: 65%;
  position: relative;
}

.right-column {
  width: 35%;
  margin-top: 60px;
}


/* Left Column */
.left-column img {
  width: 70%;
  position: absolute;
  left: 0;
  top: 10%;
  transition: all 0.3s ease;
}

.left-column img.active {
  opacity: 1;
}


/* Right Column */

/* Product Description */
.product-description {
  border-bottom: 1px solid #E1E8EE;
  margin-bottom: 20px;
}
.product-description span {
  font-size: 12px;
  color: #d57a29;
  letter-spacing: 1px;
  text-transform: uppercase;
  text-decoration: none;
}
.product-description h1 {
  font-weight: 300;
  font-size: 52px;
  color: #000000;
  letter-spacing: -2px;
}
.product-description p {
  font-size: 16px;
  font-weight: 300;
  color: #86939E;
  line-height: 24px;
}

/* Product Configuration */
.product-color span,
.type-config span {
  font-size: 14px;
  font-weight: 400;
  color: ##000000;
  margin-bottom: 20px;
  display: inline-block;
}

.quantity-config span {
  font-size: 14px;
  font-weight: 400;
  color: ##000000;
  margin-bottom: 20px;
  display: inline-block;
}



/* Cable Configuration */
.type-choose {
  margin-bottom: 20px;
}

.type-choose button {
  border: 2px solid #E1E8EE;
  border-radius: 6px;
  padding: 13px 20px;
  font-size: 14px;
  color: #5E6977;
  background-color: #fff;
  cursor: pointer;
  transition: all .5s;
}

.type-choose button:hover,
.type-choose button:active,
.type-choose button:focus {
  border: 2px solid #86939E;
  outline: none;
}

.type-config {
  border-bottom: 1px solid #E1E8EE;
  margin-bottom: 20px;
}
.quantity-config {
  margin-bottom: 20px;
}
.type-config a {
  color: #358ED7;
  text-decoration: none;
  font-size: 12px;
  position: relative;
  margin: 10px 0;
  display: inline-block;
}
.type-config a:before {
  content: "?";
  height: 15px;
  width: 15px;
  border-radius: 50%;
  border: 2px solid rgba(53, 142, 215, 0.5);
  display: inline-block;
  text-align: center;
  line-height: 16px;
  opacity: 0.5;
  margin-right: 5px;
}

/* Product Price */
.product-price {
  display: flex;
  align-items: center;
}

.product-price span {
  font-size: 36px;
  font-weight: 300;
  color: black;
  margin-right: 20px;
}

.cart-btn {
  display: inline-block;
  background-color: #fd8d0c;
  border-radius: 6px;
  font-size: 16px;
  color: #FFFFFF;
  text-decoration: none;
  padding: 12px 30px;
  transition: all .5s;
}
.cart-btn:hover {
  background-color: #ff6600;
}

/* Responsive */
@media (max-width: 940px) {
  .container {
    flex-direction: column;
    margin-top: 60px;
  }

  .left-column,
  .right-column {
    width: 100%;
  }

  .left-column img {
    width: 300px;
    right: 0;
    top: -65px;
    left: initial;
  }
}

@media (max-width: 535px) {
  .left-column img {
    width: 220px;
    top: -85px;
  }
}

#amount{
	border: 2px solid #E1E8EE;
    border-radius: 6px;
    padding: 13px 20px;
    font-size: 14px;
    color: #5E6977;
    background-color: #fff;
    cursor: pointer;
    transition: all .5s;
    width: 15px;
    text-align:center;
}
.recipe{

width:100%;

}



.column {
  float: left;
  padding: 10px;
}

/* Clearfix (clear floats) */
.row::after {
  content: "";
  clear: both;
  display: table;
}


</style>

    <jsp:include page="nav.jsp" />
  <title>${spice.name}</title>
</head>
	




	 <body>
    <main class="container">

      <!-- Left Column / Image -->
      <div class="left-column">
        <img src="${spice.picture}"alt="${spice.name}">      
      </div>


      <!-- Right Column -->
      <div class="right-column">

        <!-- Product Description -->
        <div class="product-description">
          <span>${spice.category}</span>
          <h1>${spice.name}</h1>
          <p>${spice.description}</p>
        </div>

            <div class="type-choose">
              <button>500g</button>
              <button>5kg</button>
              <button>10kg</button>
            </div>
            
             <!-- Quantity -->
          <div class="quantity-config">            
            <div class="type-choose">
                <!--form action and modelattribute will change onclick via js-->
              <form:form id="form" action="addItemGrams" modelAttribute="itemGram">
                  <form:hidden path="spice" value="${spice.name}"/>
                  <!--kilograms/stones input depending on js onlcik-->
                  <form:input id="input-large" path="kilograms"/>
                  <form:label id="label-large" path="kilograms">kg</form:label> 
                  <!--grams/stones input depending on js onclick-->
                  <form:input id="input-small" path="grams"/>
                  <form:label id="label-small" path="grams">g</form:label>
                  <button id="units" type="button" onclick="unitSwitch()">Switch to Imperial Units</button>
                  <br>
                  <div class="product-price">
                    <input class="cart-btn" type="submit" value="Add to Cart">
                  </div>
              </form:form>
            </div>

            
          </div>
        </div>

        <!-- Product Pricing -->
        <div class="product-price">
          <span><p>Price per 100g: &pound;${spice.price}</p></span>
        </div>
        
       
    </main>
    
      <div class="recipe">
           <h1 style="Text-align:center;"> Recommended Recipe </h1>
           
	 	 <div class="row">
		  	<div class="column">
		   	 <img src="https://desirerecipes.com/wp-content/uploads/2021/11/image-28-1-1-1-1.jpg" alt="Black pepper" height="400" width="450">
		   	 <p>Black Pepper Angus Steak</p>
		 	</div>
		 <div class="column">
		   	 <img src="https://desirerecipes.com/wp-content/uploads/2021/11/image-28-1-1-1-1.jpg" alt="Black pepper" height="400" width="450">
		   	 <p>Black Pepper Angus Steak</p>
		 	</div>
		  <div class="column">
		   	 <img src="https://desirerecipes.com/wp-content/uploads/2021/11/image-28-1-1-1-1.jpg" alt="Black pepper" height="400" width="450">
		   	 <p>Black Pepper Angus Steak</p>
		 	</div>
		</div>
  
           </div>


	<script type="text/javascript">
		let y = false;

		function unitSwitch(){
			//if at imperial units (pounds and ounces)
			if (!y) {
				y = true;
				document.getElementById("units").innerHTML = "Switch to Metric Units";

				document.getElementById("form").action = "addItemPounds";
				document.getElementById("form").modelAttribute = "itemPound";

				document.getElementById("input-large").path = "pounds";
				document.getElementById("input-small").path = "ounces";

				document.getElementById("label-large").innerHTML = "lb";
				document.getElementById("label-small").innerHTML = "oz.";
			}

			//if at metric units (kilograms and grams)
			else if (y) {
				y = false;
				document.getElementById("units").innerHTML = "Switch to Imperial Units";

				document.getElementById("form").action = "addItemGrams";
				document.getElementById("form").modelAttribute = "itemGram";

				document.getElementById("input-large").path = "kilograms";
				document.getElementById("input-small").path = "grams";

				document.getElementById("label-large").innerHTML = "kg";
				document.getElementById("label-small").innerHTML = "g";
			}
		}
	</script>

</body>
</html>