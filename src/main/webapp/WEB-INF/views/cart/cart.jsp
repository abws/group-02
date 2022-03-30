<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ page pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <style>


        html, body {
            height: 100%;
            width: 100%;
            margin: 0;
            font-family: "Monserrat", sans-serif;
        }

        #cart {
            font-family: 'Monserrat, sans-serif';
            border-collapse: collapse;
            width: 100%;

        }

        #cart td, #cart th {
            border: 1px solid #c5c5c5;
            border-top: none;
            border-left: none;
            border-right: none;
            text-align: center;
            font-size: 16px;
            width: 900px;
        }

        #cart tr:hover {
            background-color: #ece8e8;
        }

        #cart th {
            padding-top: 12px;
            padding-bottom: 12px;
            text-align: center;

            color: black;

        }

        input {

            width: 30%;
            border-bottom: none;
            border-top: none;
            border-left: none;
            border-right: none;
            text-align: center;
            background: transparent;
            font-size: 14px;


        }

        button {

            border-radius: 40px;
            background: white;
            border: 1px solid #fb892c;
            color: #fb892c;

        }

        button:hover {
            background-color: #fd8d0c;
            color: white;
        }

        .container {
            max-width: 1300px;
            margin: 0 auto;
            padding: 25px;
            display: flex;

        }

        /* Columns */
        .left-column {
            width: 80%;
            position: relative;
            margin-top: 20px;
        }

        .right-column {
            width: 28%;
            margin-top: 30px;
            height: 30%;
            background-color: #ffe1ca;;
            border-radius: 35px;
            font-family: 'Monserrat, sans-serif';
            -webkit-box-shadow: 10px 10px 5px #d9d9d9;
            margin-left: 20px;
        }

        .checkout {
            text-align: center;
        }

        .checkout button {
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

        .summary {
            display: flex;
            justify-content: space-between;
            margin-top: 10px;
            border-bottom: solid 1px #808080;
            margin-right: 20px;
            margin-left: 20px;
        }

        .summary p {
            color: black;
            font-size: 16px;
            font-weight: 800;

        }

        .total {
            margin-top: 15px;
            display: flex;
            justify-content: space-between;
            font-size: 2em;
            font-family: 'Monserrat, sans-serif';

        }

        .total .final-price {
            margin-top: 20px;
            margin-right: 20px;
            font-family: 'Monserrat, sans-serif';
        }

        .right-column h1 {
            color: black;
            margin-top: 20px;
        }


        .header {
            width: 100%;
            text-align: center;
        }

        img {
            width: 100%;
        }

        .delete-row {
            padding: 0px !important;
        }

        .delete-row input[value] {
            color: red;
            width: 100%;
        }

        .delete-row input[value]:hover {
            cursor: pointer;
            text-decoration: underline;
        }

        .pic {
            align-items: center;
            justify-content: center;
            display: flex;
            width: 100%;
            height: 400px;
            background-image: linear-gradient(rgba(0, 0, 0, 0.5), rgba(0, 0, 0, 0.5)), url("../../images/cartback.webp");


        }

    </style>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Caveat+Brush&family=Londrina+Solid&display=swap"
          rel="stylesheet">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <jsp:include page="../base.jsp"/>
    <title>Cart</title>

</head>
<body>

<div id="back">

    <div class="pic">
        <h1 style="font-size:50px; color: white; font-family: 'Monserrat, sans-serif'">Shopping Cart</h1>


    </div>

</div>

<c:choose>
    <c:when test="${cart.getItems().size() > 0}">
        <main class="container">


            <div class="left-column">


                <table id="cart">
                    <tr>
                        <th></th>
                        <th>Product</th>
                        <th>Name</th>
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
                                    <button class="btn btn-default btn-subtract3" onclick="decrement(${item.id})">-
                                    </button>
                                    <input type="text" name="quantity" id="quantity${item.id}"
                                           value="${item.quantity}"/>
                                    <input type="text" name="itemId" value="${item.id}" hidden="true">
                                    <button onclick="increment(${item.id})">+</button>
                                </form>
                            </td>

                            <sec:authorize access="hasAnyAuthority('NOVICE', 'EXPERT', 'ADMIN')">
                                <td><fmt:formatNumber type="currency" currencySymbol="£" maxFractionDigits="2"
                                                      minFractionDigits="2">${item.spice.getUserPrice()}</fmt:formatNumber></td>
                                <td>${item.toString()}</td>
                                <td><fmt:formatNumber type="currency" currencySymbol="£" maxFractionDigits="2"
                                                      minFractionDigits="2">${item.getUserPrice()}</fmt:formatNumber></td>
                            </sec:authorize>
                            <sec:authorize access="!hasAnyAuthority('NOVICE', 'EXPERT', 'ADMIN')">
                                <td>&pound${item.spice.price}</td>
                                <td>${item.toString()}</td>
                                <td>&pound${item.price}</td>
                            </sec:authorize>

                        </tr>
                    </c:forEach>
                </table>

            </div>

            <div class="right-column">
                <h2 style="text-align: center;">Summary</h2>
                <div class="summary">
                    <p>Subtotal </p>
                    <sec:authorize access="hasAnyAuthority('NOVICE', 'EXPERT', 'ADMIN')">
                        <p id="subtotal">${cart.getUserPrice()}</p>
                    </sec:authorize>
                    <sec:authorize access="!hasAnyAuthority('NOVICE', 'EXPERT', 'ADMIN')">
                        <p id="subtotal">${cart.price}</p>
                    </sec:authorize>
                </div>

                <div class="summary">
                    <p>Shipping Fee </p>
                    <p>&pound6.80</p>
                </div>


                <div class="summary" style="border-bottom:none;">
                    <p style="font-size:36px;">Total</p>
                    <p style="font-size:36px;" class="final-price" id="total"></p>
                </div>

                <div class="checkout">
                    <a href="/billing">
                        <button>Checkout</button>
                    </a>

                </div>
            </div>

        </main>
    </c:when>
    <c:otherwise>
        <h1 style="text-align:center;">Shopping cart empty</h1>
    </c:otherwise>
</c:choose>
<script>
    <sec:authorize access="hasAnyAuthority('NOVICE', 'EXPERT', 'ADMIN')">
    document.getElementById("total").innerHTML = "&pound" + Number(${cart.getUserPrice()} +6.8).toFixed(2);
    document.getElementById("subtotal").innerHTML = "&pound" + Number(${cart.getUserPrice()}).toFixed(2);
    </sec:authorize>
    <sec:authorize access="!hasAnyAuthority('NOVICE', 'EXPERT', 'ADMIN')">
    document.getElementById("total").innerHTML = "&pound" + Number(${cart.price} +6.8).toFixed(2);
    document.getElementById("subtotal").innerHTML = "&pound" + Number(${cart.price}).toFixed(2);
    </sec:authorize>


    function increment(id) {
        let val = Number(document.getElementById("quantity" + id).value);
        if (val == 10) return 0; //the button deactivates for values over 10 or below 0
        document.getElementById("quantity" + id).value = Number(document.getElementById("quantity" + id).value) + 1;
    }

    function decrement(id) {
        let val = Number(document.getElementById("quantity" + id).value);
        if (val == 1) return 0;
        document.getElementById("quantity" + id).value = Number(document.getElementById("quantity" + id).value) - 1;
    }

</script>
</body>
</html>
