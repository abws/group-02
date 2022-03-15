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
  width: 40%;
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
                <th>Product Name</th>
                <th>Type</th>
                <th>Quantity</th>
                <th>Price/100g</th>
                <th>Total</th>
            </tr>
            <c:forEach items="${cart.items}" var="item">

            <tr>
                <td>${item.spice.name}</td>
                <td>${item.spice.category}</td>
                <td>
                    <form action="increaseItem" method="post">
                        <button class="btn btn-default btn-subtract3" onclick="decrement()">-</button>
                            <input type="text" name="quantity" id="quantity" value="${item.quantity}" class="form-control no-padding text-center item-quantity3"/>
                            <input type="text" name="itemId" value="${item.id}" hidden="true">
                        <button class="btn btn-default btn-add" onclick="increment()">+</button>
                    </form>
                </td>
                <td>${item.spice.price}</td>
                <td>${item.price}</td>

            </tr>
            </c:forEach>
            </table>

          </div>
          
              <div class="right-column">
              <h1 style="text-align: center;">Summary</h1>
               <div class ="summary">
                  <p>Subtotal </p>
                  <p>&pound${cart.price}</p>
               </div>
               
                 <div class ="summary">
                  <p>Shipping Fee </p>
                  <p>&pound6.80</p>
               </div>

                <div class ="total">
                  <p>Total </p>
                  <p id="total"></p>
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
            document.getElementById("total").innerHTML = "&pound" + Math.round(Number(${cart.price} + 6.8) * 100) / 100;

            function increment() {
                let val = Number(document.getElementById("quantity").value);
                if (val == 10) return 0;
                document.getElementById("quantity").value = Number(document.getElementById("quantity").value) + 1;
          }

            function decrement() {
                let val = Number(document.getElementById("quantity").value);
                if (val == 1) return 0;
                document.getElementById("quantity").value = document.getElementById("quantity").value - 1;
          }

        </script>
    </body>
</html>