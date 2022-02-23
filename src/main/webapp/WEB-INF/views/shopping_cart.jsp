<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html lang="en">

<html>
<head>
<style>

#cart {
  font-family: Arial;
  border-collapse: collapse;
  width: 60%;
}

#cart td, #cart th {
    border: 1px solid #c5c5c5;
    border-top: none;
    border-left: none;
    border-right: none;
    padding: 40px;
    text-align: center;
    font-size:16px;
}

#cart tr:nth-child(even){background-color: #f2f2f2;}

#cart tr:hover {background-color: #ddd;}

#cart th {
  padding-top: 12px;
  padding-bottom: 12px;
  text-align: center;

  color: black;
  
 }
 
input{

width:30%;
   border-bottom: none;
    border-top: none;
    border-left: none;
    border-right: none;
    text-align:center;
    background:transparent;
    font-size:14px;
    

}

button{

border-radius:40px;
background:white;
border: 1px solid #fb892c;
color:#fb892c;

}

button:hover {
  background-color: #fd8d0c;
  color: white;
}

.container {
  max-width: 1200px;
  margin: 0 auto;
  padding: 25px;
  display: flex;
  border-top: 1px solid black;
}

/* Columns */
.left-column {
  width: 60%;
  position: relative;
}

.right-column {
  width: 35%;
  margin-top: 30px;

  background-color: #ffe1ca;;
  border-radius: 35px;
  

  -webkit-box-shadow: 10px 10px 5px #d9d9d9;
}

.checkout{
	text-align:center;
}

.checkout button{
	background-color: #f17a1c;
    border-radius: 25px;
    color: white;
   
    cursor: pointer;
   
    width: 60%;
    height: 50px;
    font-size: 22px;
    cursor: pointer;

    margin: 30px;
}

.checkout button:hover {
  background-color: #ff6600;
}

.summary{
display: flex; 
justify-content: space-between; 
padding: 0 50 0 50;
}

.summary p{
	color: black;
	    font-size: 16px;
    font-weight: 800;

}

.right-column h1{
	color: black;
}

.header{
	width:100%;
	text-align:center;
	
	
}
</style>
</head>
 <jsp:include page="nav.jsp" />



	<title>Shopping Cart</title>



<body>
<div class="header">
	<h1>Shopping Cart</h1>
</div>
 <main class="container">

 
      <div class="left-column">
      

<table id="cart">
  <tr>
    
    <th>Product Name</th>
    <th>Type</th>
    <th>Quantity</th>
    <th>Price/100g</th>
    <th>Total</th>

  </tr>

  
  <tr>
    <td>${name}</td>
    <td>${type}</td>
    <td><button class="btn btn-default btn-subtract3" id = "3" onclick="decrementValue(this.id)">-</button><input id="number3" class="form-control no-padding text-center item-quantity3" value="${quantity}"><button class="btn btn-default btn-add" id = "3" onclick="incrementValue(this.id)">+</button></td>
    <td id="price3">£${price}</td>
    <td id="total3">£${total}</td>
  </tr>
 

	</table>
  </div>
  
      <div class="right-column">
      <h1 style="text-align: center;">Summary</h1>
	   <div class ="summary">
	      <p>Subtotal </p>
	      <p id="subtotal"></p>
	   </div>
	   
	     <div class ="summary">
	      <p>Shipping Fee </p>
	      <p id="shipping">£6.80</p>
	   </div>
	   
	   <div class = "checkout">
	   <button>Checkout</button>
	      
      </div>
      </div>
 </main>
</body>
</html>




<script>

		
	var table = document.getElementById("cart"),
	sumVal = 0;
	for (var i = 1; i < table.rows.length; i++) {
		total = table.rows[i].cells[4].innerHTML.replace("£","");
		sumVal = sumVal + parseFloat(total);
	}
	
	document.getElementById("subtotal").innerHTML = "£"+sumVal.toFixed(2);	
	
	function sumup(){
		var table = document.getElementById("cart"),
		sumVal = 0;
		for (var i = 1; i < table.rows.length; i++) {
			total = table.rows[i].cells[4].innerHTML.replace("£","");
			sumVal = sumVal + parseFloat(total);
		}
		
		document.getElementById("subtotal").innerHTML = "£"+sumVal.toFixed(2);
	}
	

	function incrementValue(Id){
		if (Id == 1){
			var value = parseInt(document.getElementById('number1').value);
			value++;
		    document.getElementById('number1').value = value;
		    var price = document.getElementById('price1').innerHTML.replace("£","");
			var total = value * price;
			document.getElementById('total1').innerHTML = "£"+total.toFixed(2);
		    document.getElementById('number1').value = value;
		    sumup();
		}else if(Id == 2){
			var value = parseInt(document.getElementById('number2').value);
			value++;
		    document.getElementById('number2').value = value;
		    var price = document.getElementById('price2').innerHTML.replace("£","");
			var total = value * price;
			document.getElementById('total2').innerHTML = "£"+total.toFixed(2);
		    document.getElementById('number2').value = value;
		    sumup();

		}else{
			var value = parseInt(document.getElementById('number3').value);
			value++;
		    document.getElementById('number3').value = value;
		    var price = document.getElementById('price3').innerHTML.replace("£","");
			var total = value * price;
			document.getElementById('total3').innerHTML = "£"+total.toFixed(2);
		    document.getElementById('number3').value = value;
		    sumup();

		}
	}
	
	function decrementValue(Id){
		if (Id == 1){
			var value = parseInt(document.getElementById('number1').value);
			if (value > 1){
				value=value-1;
			}else{
				value = 0;
			}
			var price = document.getElementById('price1').innerHTML.replace("£","");
			var total = value * price;
			document.getElementById('total1').innerHTML = "£"+total.toFixed(2);
		    document.getElementById('number1').value = value;
		    sumup();

		}else if(Id == 2){
			var value = parseInt(document.getElementById('number2').value);
			if (value > 1){
				value=value-1;
			}else{
				value = 0;
			}
			var price = document.getElementById('price2').innerHTML.replace("£","");
			var total = value * price;
			document.getElementById('total2').innerHTML = "£"+total.toFixed(2);
		    document.getElementById('number2').value = value;
		    sumup();

		}else{
			var value = parseInt(document.getElementById('number3').value);
			if (value > 1){
				value=value-1;
			}else{
				value = 0;
			}
			var price = document.getElementById('price3').innerHTML.replace("£","");
			var total = value * price;
			document.getElementById('total3').innerHTML = "£"+total.toFixed(2);
		    document.getElementById('number3').value = value;
		    sumup();

		}
	}



</script>
</html>

