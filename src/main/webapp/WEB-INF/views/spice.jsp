<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<script>document.getElementsByTagName("html")[0].className += " js";</script>
<link rel="stylesheet" href="assets/css/style.css">
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
  width: 70%;
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
  color: #9e9586;
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
  border: 2px solid #eee7e1;
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
  border: 2px solid #9e9386;
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
  font-size: 46px;
  font-weight: 300;
  color: black;
  margin-right: 20px;
}

.cart-btn {
  display: inline-block;
  background-color: #fd8d0c;
  border-radius: 10px;
  font-size: 18px;
  color: #FFFFFF;
  text-decoration: none;
  padding: 12px 30px;
  transition: all .5s;
  border:none;
  cursor: pointer;
}
.cart-btn:hover {
  background-color: #fc8a6f;
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
	border: 2px solid #eee7e1;
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

.unit_input{
border: 2px solid #eee7e1;
    border-radius: 6px;
    padding: 13px 20px;
    font-size: 14px;
    color: #5E6977;
    background-color: #fff;
    cursor: pointer;
    transition: all .5s;
    width: 25px;
    text-align:center;

}
.recipe{


    padding-right: 15px;
    padding-left: 15px;
    margin-right: auto;
    margin-left: auto;
    width: 1200px;

display: flex;

}

.recipe div{

width:33.33%;

    padding: 10px;
    margin: 10px;
}

.recipe img{
  border-radius: 10px;
  
img-shadow: 2px 2px;

      border:2px solid #fff;
    
      box-shadow: 10px 10px 5px #ccc;
      -moz-box-shadow: 10px 10px 5px #ccc;
      -webkit-box-shadow: 10px 10px 5px #ccc;
      -khtml-box-shadow: 10px 10px 5px #ccc;
}

.recipe img:hover {
  box-shadow: 0 0 2px 2px #fd8d0c;
      cursor: pointer;
}

h2{

    text-align: center;
    background: #fc8a70;
    color: white;
    padding: 10px;

 border-radius: 0px 50px 0px 0px;
    font-family: arial;
    font-size: 28px;
    width: 50%;


}


</style>
   <jsp:include page="nav.jsp" />

	<title>${spice.name}</title>
	</head>
	 <body>
    <main class="container">

      <!-- Left Column / Image -->
      <div class="left-column">
        <img src="${spice.picture}" alt="${spice.name}">      
      </div>


      <!-- Right Column -->
      <div class="right-column">

        <!-- Product Description -->
        <div class="product-description">
          <span>${spice.category}</span>
          <h1 class="name">${spice.name}</h1>
          <p>${spice.description}</p>
        </div>

          <!-- Type Configuration -->
          <div class="type-config">
            <span>Select Type</span>

            <div class="type-choose">
              <button class="quantity" onclick="change_price()">100g</button>
              <button class="quantity1" onclick="change_price1()">500g</button>
              <button class="quantity2" onclick="change_price2()">1kg</button>
              <button class="quantity3" onclick="change_price3()">5kg</button>
             
            </div>
            
            <div class="quantity-config">            
              <div class="type-choose">
                  <!--form action and modelattribute will change onclick via js-->
                <form:form id="form" action="addItemGrams" modelAttribute="itemGram">
                    <form:hidden path="spice" value="${spice.name}"/>
                    <!--kilograms/stones input depending on js onlcik-->
                    <form:input id="input-large" class="unit_input" path="kilograms"/>
                    <form:label id="label-large" path="kilograms">kg</form:label> 
                    <!--grams/stones input depending on js onclick-->
                    <form:input id="input-small" class="unit_input" path="grams"/>
                    <form:label id="label-small" path="grams">g</form:label>

                    <form:input class="unit_input" path="quantity"/>
                    <form:label path="quantity">Quantity</form:label>                    <button id="units" type="button" onclick="unitSwitch()">Switch to Imperial Units</button>
                    <input type="submit">
                    <br>
                    
                </form:form>
              </div>
  
              
            </div>
            
             <!-- Quantity -->
          <div class="quantity-config">
            <span>Select Quantity</span>

            <div class="type-choose">
              <button class="btn btn-default btn-subtract">-</button>
              <input type="text" id="amount" value="1" class="form-control no-padding text-center item-quantity" min="0" onkeyup="value=value.replace(/^\d/g,'')">
              <button class="btn btn-default btn-add">+</button>
            </div>
			
            
          </div>
        </div>

        <!-- Product Pricing -->
        <div class="product-price">
          <span><p id="price"></p></span>
         <button onclick="my()" class="cart-btn" id="pass">Add to cart</button>
        </div>
        
     </div>
  	</main>
    
    
            <h2 style="text-align:center;">Related Recipe</h2>
      <div class="recipe">
      
      	
   
	 	<div >
 	 		<img src="https://selfproclaimedfoodie.com/wp-content/uploads/new-york-strip-steak-square-3.jpg" alt="Black pepper" width="304" height="236">
		   	 <p> Angus Steak</p>
	 	</div>
	 	
	 	<div >
 	 		<img src="https://www.connoisseurusveg.com/wp-content/uploads/2017/04/black-pepper-tofu.jpg" alt="Black pepper" width="304" height="236">
		   	 <p>Black Pepper Tofu</p>
	 	</div>
	 	
	 	<div >
 	 		<img src="https://huntercattle.com/wp-content/uploads/2020/11/istockphoto-541851706-612x612-1.jpg" alt="Black pepper" width="304" height="236">
		   	 <p>Sirloin Steak</p>
	 	</div>
	 	
		   	
		</div>
  
           
<script>
	var minus = document.querySelector(".btn-subtract");
	var add = document.querySelector(".btn-add");
	var quantityNumber = document.querySelector(".item-quantity");
	var currentValue = 1;
	var quantity1 = document.querySelector(".quantity1");
	var quantity2 = document.querySelector(".quantity2");
	var quantity3 = document.querySelector(".quantity3");
	var price = ${spice.price};
	var price1 = ${spice.price}*5;
	var price2 = ${spice.price}*8;
	var price3 = ${spice.price}*10;
	var total =document.getElementById("price").innerHTML;
	var p = document.getElementById("price");
	var type = "";
	var q = "";
	var submit_price = 0;

	document.getElementById("price").innerHTML = "&pound" +${spice.price}.toFixed(2);

	
	minus.addEventListener("click", function(){
		if (currentValue > 1){
		    currentValue -= 1;
		    quantityNumber.value = currentValue;
		    document.getElementById("price").innerHTML = "&pound"+ (total * quantityNumber.value).toFixed(2);
		    console.log(currentValue)}
	
		else{
			currentValue = 1;
		}
		
	});
	
	add.addEventListener("click", function() {
	    currentValue += 1;
	    quantityNumber.value = currentValue;
	    document.getElementById("price").innerHTML = "&pound"+(total * quantityNumber.value).toFixed(2);
	    console.log(currentValue);
	});
	
	

	function change_price(){
		quantityNumber.value = 1;
		currentValue = 1;
	    document.getElementById("price").innerHTML = "&pound"+price.toFixed(2);
	    total = price;
	    type = document.querySelector(".quantity").innerHTML;
	    submit_price = price.toFixed(2);
	}
	function change_price1(){
		quantityNumber.value = 1;
		currentValue = 1;
	    document.getElementById("price").innerHTML = "&pound"+price1.toFixed(2);
	    total = price1;
	    type = document.querySelector(".quantity1").innerHTML;
	    submit_price = price1.toFixed(2);

	}
	function change_price2(){
		quantityNumber.value = 1;
		currentValue = 1;
	    document.getElementById("price").innerHTML ="&pound"+ price2.toFixed(2);
	    total = price2;
	    type = document.querySelector(".quantity2").innerHTML;
	    submit_price = price2.toFixed(2);

	}
	function change_price3(){
		quantityNumber.value = 1;
		currentValue = 1;
	    document.getElementById("price").innerHTML = "&pound"+price3.toFixed(2);
	    total = price3;
	    type = document.querySelector(".quantity3").innerHTML;
	    submit_price = price3.toFixed(2);

	}
	

	
	var addtobasket = document.querySelector(".cart-btn");
	var submit_price = 0;
	var product = document.getElementByClass("product-price");
 

	

	
	function my(){
		
		window.location.href="addtobasket"+window.location.search +"&type="+type+"&quantity="+currentValue+"&price="+submit_price+"&total="+(submit_price*currentValue).toFixed(2);
	}
	
 </script>      



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