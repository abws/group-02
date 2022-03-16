<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
            color: rgb(252, 168, 90);
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
    <jsp:include page="base.jsp" />
    <title>Spices</title>

</head>
<body>

<div class="row">
    <c:forEach items="${basket}" var="spice">
        <div class="card">
            <h1> ${spice.getName()}</h1>
            <p class="price">�${spice.getPrice()} per 100g</p>

            <p>
            	<a href="/Basket/Remove/${spice.getName()}" class="btn btn-primary">Remove from Cart</a>
            </p>
        </div>
    </c:forEach>
</div>

</body>
</html>