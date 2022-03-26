<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
            width: 55%;
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

        /* Recipe Ingredients */
        .recipe-ingredients {
            border-bottom: 1px solid #E1E8EE;
            margin-bottom: 20px;
        }

        .recipe-ingredients span {
            font-size: 12px;
            color: #d57a29;
            letter-spacing: 1px;
            text-transform: uppercase;
            text-decoration: none;
        }

        .recipe-ingredients h1 {
            font-weight: 300;
            font-size: 52px;
            color: #000000;
            letter-spacing: -2px;
        }

        .recipe-ingredients p {
            font-size: 16px;
            font-weight: 300;
            color: #9e9586;
            line-height: 24px;
        }

        /* Recipe Method */
        .recipe-method {
            border-bottom: 1px solid #E1E8EE;
            margin-bottom: 20px;
        }

        .recipe-method span {
            font-size: 12px;
            color: #d57a29;
            letter-spacing: 1px;
            text-transform: uppercase;
            text-decoration: none;
        }

        .recipe-method h1 {
            font-weight: 300;
            font-size: 52px;
            color: #000000;
            letter-spacing: -2px;
        }

        .recipe-method p {
            font-size: 16px;
            font-weight: 300;
            color: #9e9586;
            line-height: 24px;
        }

        /* Right Column */

        /* Recipe Description */
        .recipe-description {
            border-bottom: 1px solid #E1E8EE;
            margin-bottom: 20px;
            margin-left: 60px;
        }

        .recipe-description span {
            font-size: 12px;
            color: #d57a29;
            letter-spacing: 1px;
            text-transform: uppercase;
            text-decoration: none;
        }

        .recipe-description h1 {
            font-weight: 300;
            font-size: 52px;
            color: #000000;
            letter-spacing: -2px;
        }

        .recipe-description p {
            font-size: 16px;
            font-weight: 300;
            color: #9e9586;
            line-height: 24px;
        }

        /* Recipe Configuration */
        .recipe-color span,
        .type-config span {
            font-size: 14px;
            font-weight: 400;
            color: # #000000;
            margin-bottom: 20px;
            display: inline-block;
        }

        .quantity-config span {
            font-size: 14px;
            font-weight: 400;
            color: # #000000;
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
            border: none;
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

        #amount {
            border: 2px solid #eee7e1;
            border-radius: 6px;
            padding: 13px 20px;
            font-size: 14px;
            color: #5E6977;
            background-color: #fff;
            cursor: pointer;
            transition: all .5s;
            width: 15px;
            text-align: center;
        }

        .unit_input {
            border: 2px solid #eee7e1;
            border-radius: 6px;
            padding: 13px 20px;
            font-size: 14px;
            color: #5E6977;
            background-color: #fff;
            cursor: pointer;
            transition: all .5s;
            width: 25px;
            text-align: center;

        }

        .product {


            padding-right: 15px;
            padding-left: 15px;
            margin-right: auto;
            margin-left: auto;
            width: 1200px;

            display: flex;

        }

        .product div {

            width: 25%;

            padding: 5px;
            margin: 5px;
        }

        .product img {
            border-radius: 5px;

            img-shadow: 2px 2px;

            border: 2px solid #fff;

            box-shadow: 10px 10px 5px #ccc;
            -moz-box-shadow: 10px 10px 5px #ccc;
            -webkit-box-shadow: 10px 10px 5px #ccc;
            -khtml-box-shadow: 10px 10px 5px #ccc;
        }

        .product img:hover {
            box-shadow: 0 0 2px 2px #fd8d0c;
            cursor: pointer;
        }

        h2 {

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
    <jsp:include page="nav.jsp"/>

    <title>${recipe.name}</title>
</head>

<body>
<main class="container">

    <!-- Left Column / Image -->
    <div>
        <img src="${recipe.picture}" alt="${recipe.name}">
    </div>
    <!-- Right Column -->
    <div class="right-column">

        <!-- Product Description -->
        <div class="recipe-description">
            <span>${recipe.category}</span>
            <h1 class="name">${recipe.name}</h1>
            <p>${recipe.description}</p>
        </div>
    </div>
</main>
<main class="container">
    <!--Ingredients and Method below the photo-->
    <div class="recipe-ingredients">
        <h1 class="Ingredients">Ingredients</h1>

        <ul>
            <c:forEach var="ingredient" items="${recipe.getIngredients()}">
                <li>${ingredient}</li>
            </c:forEach>
        </ul>
        <h1 class="Method">Method</h1>
        <ol>
            <c:forEach var="ingredient" items="${recipe.getMethod()}">
                <li>${ingredient}</li>
            </c:forEach>
        </ol>
    </div>
</main>


<h2 style="text-align:center;">Related Product</h2>
<div class="product">


    <div>
        <img src="https://www.spicemountain.co.uk/wp-content/uploads/2019/10/paprika1.jpeg" alt="Sweet Paprika"
             width="304" height="236">
        <p>Sweet Paprika</p>
    </div>

    <div>
        <img src="https://www.spicemountain.co.uk/wp-content/uploads/2019/10/cumin-seed.jpg" alt="Cumin Seeds"
             width="304" height="236">
        <p>Cumin Seeds</p>
    </div>

    <div>
        <img src="https://www.spicemountain.co.uk/wp-content/uploads/2019/10/cayenne-pepper_1422925949-scaled.jpg"
             alt="Cayenne Pepper" width="304" height="236">
        <p>Cayenne Pepper</p>
    </div>

    <div>
        <img src="https://www.spicemountain.co.uk/wp-content/uploads/2019/10/20161123_131905.jpg" alt="Carway Seeds"
             width="304" height="236">
        <p>Carway Seeds</p>
    </div>

</div>

</body>

</html>