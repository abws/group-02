<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
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
  width: 80%;
  position: relative;
}

.right-column {
  width: 60%;
  margin-top: 30px;

  background-color: #ffe1ca;;
  border-radius: 35px;
  font-family: 'Helvetica';


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
margin-top: 10px;
box-shadow: 0px 10px 10px -10px grey;
}

.summary p{
    color: black;
        font-size: 16px;
    font-weight: 800;

}

.total {
    margin-top: 15px;
    display:flex;
    justify-content: space-between;
    font-size: 2em; 
}

.total .final-price {
    margin-top: 20px;
    font-size: 2.5em;
}

.right-column h1{
    color: black;
}

.header{
    width:100%;
    text-align:center;
}

img {
    width: 150%;
}

.delete-row {
    padding: 0px !important;
}

.delete-row input[value] {
    color: red;
    width: 100%;
}

</style>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Caveat+Brush&family=Londrina+Solid&display=swap" rel="stylesheet">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <jsp:include page="../base.jsp" />
    <title>Cart</title>

</head>
<body>
    <div class="header">
        <h1>Shopping Cart</h1>
    </div>
<c:choose>
    <c:when test="${cart.getItems().size() > 0}">
         <main class="container">

         
              <div class="left-column">
              

        <table id="cart">
            <tr>
                <th></th>
                <th>Product</th>
                <th>Product Name</th>
                <th>Type</th>
                <th>Quantity</th>
                <th>Price/100g</th>
                <th>Weight/Unit</th>
                <th>Total Price</th>
            </tr>
            <c:forEach items="${cart.items}" var="item">

            <tr>
                <td class="delete-row">
                    <form action="/deleteItem" method="POST">
                        <input name="itemId" value="${item.id}" hidden>
                        <input type="submit" value="Delete">
                    </form>
                </td>
                <td><img src="${item.spice.picture}" alt=""></td>
                <td>${item.spice.name}</td>
                <td>${item.spice.category}</td>
                <td>
                    <form action="increaseItem" method="post">
                        <button class="btn btn-default btn-subtract3" onclick="decrement(${item.id})">-</button>
                            <input type="text" name="quantity" id="quantity${item.id}" value="${item.quantity}" class="form-control no-padding text-center item-quantity3"/>
                            <input type="text" name="itemId" value="${item.id}" hidden="true">
                        <button class="btn btn-default btn-add" onclick="increment(${item.id})">+</button>
                    </form>
                </td>
                <td>&pound${item.spice.price}</td>
                <td>${item.toString()}</td>
                <td>&pound${item.price}</td>

            </tr>
            </c:forEach>
            </table>

          </div>
          
              <div class="right-column">
              <h1 style="text-align: center;">Summary</h1>
               <div class ="summary">
                  <p>Subtotal </p>
                  <p id="subtotal">${cart.price}</p>
               </div>
               
                 <div class ="summary">
                  <p>Shipping Fee </p>
                  <p>&pound6.80</p>
               </div>

                <div class="total">
                  <p>Total </p>
                  <p class="final-price"id="total"></p>
               </div>

               <div class = "checkout">
               <a href="/billing"><button>Checkout</button></a>
                  
              </div>
              </div>

         </main>
     </c:when>
     <c:otherwise>
     <h1>Shopping cart empty</h1>
     </c:otherwise>
 </c:choose>
         <script>
            document.getElementById("total").innerHTML = "&pound" + Number(${cart.price} + 6.8).toFixed(2);
            document.getElementById("subtotal").innerHTML = "&pound" + Number(${cart.price}).toFixed(2);

            function increment(id) {
                let val = Number(document.getElementById("quantity" + id).value);
                if (val == 10) return 0; //the button deactivates for values over 10 or below 0
                document.getElementById("quantity" + id).value = Number(document.getElementById("quantity" + id).value) + 1;
          }

            function decrement(id) {
                let val = Number(document.getElementById("quantity" + id).value);
                if (val == 1) return 0;
                document.getElementById("quantity" + id).value = Number(document.getElementById("quantity"  + id).value) - 1;
          }

        </script>
    </body>
</html>