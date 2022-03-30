<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8 /">

<!--JSP Page Contains HTML, CSS and JAVASCRIPT-->
<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <script>document.getElementsByTagName("html")[0].className += " js";</script>
    <link rel="stylesheet" href="assets/css/style.css">


    <!--CSS-->
    <style>
        .hero-nav {
            background-color: rgb(255, 136, 0);

        }

        .navigation ul {
            list-style-type: none;
            margin: 0;
            padding: 0;
            overflow: hidden;
            font-size: 18px;
            font-family: "Monserrat", sans-serif;
            font-weight: 900;
            background-color: rgb(255, 136, 0);

        }

        html, body {
            height: 100%;
            width: 100%;
            margin: 0;
            font-family: "Monserrat", sans-serif;
        }

        .container {
            max-width: 1200px;
            margin: 0 auto;
            padding: 15px;
            display: flex;
            margin-top: 5%;
        }

        /* Columns */
        .left-column {
            width: 70%;
            position: relative;
        }

        .right-column {
            width: 40%;
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
            font-weight: 400;
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
            color: #000000;
            margin-bottom: 20px;
            display: inline-block;
        }

        .quantity-config span {
            font-size: 14px;
            font-weight: 400;
            color: #000000;

            display: inline-block;
        }


        /* Cable Configuration */
        .type-choose {
            margin: 20px 0px;
            padding-bottom: 10px;
            border-bottom: 1px solid #E1E8EE;

        }

        .type {
            margin: 20px 0px;
            padding-bottom: 10px;

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

        .type button {
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

        .type button:hover,
        .type button:active,
        .type button:focus {
            border: 2px solid #9e9386;
            outline: none;
        }


        .type-config {
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
            font-size: 30px;
            font-weight: 400;
            color: black;
            margin-right: 10px;
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
            padding: 13px 0px;
            font-size: 14px;
            color: #5E6977;
            background-color: #fff;
            cursor: auto;
            transition: all .5s;
            width: 4em;
            text-align: center;
        }

        .recipe {
            padding-right: 15px;
            padding-left: 15px;
            margin-right: auto;
            margin-left: auto;
            width: 1200px;
            display: flex;
        }

        .recipe div {
            width: 33.33%;
            padding: 10px;
            margin: 10px;
        }

        .recipe img {
            border-radius: 10px;
            img-shadow: 2px 2px;
            border: 2px solid #fff;
            box-shadow: 10px 10px 5px #ccc;
            -moz-box-shadow: 10px 10px 5px #ccc;
            -webkit-box-shadow: 10px 10px 5px #ccc;
            -khtml-box-shadow: 10px 10px 5px #ccc;
        }

        .recipe img:hover {
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

        button {
            display: inline;
        }

        button[disabled] {
            cursor: not-allowed;
        }

        #submit[disabled] {
            cursor: not-allowed;
            background-color: #a3a3a3;

        }

        #price- span {

            font-size: 20px;
        }

        form {
            border-bottom: none;

        }

        .type .cart-btn {

            float: right;
        }

    </style>
    <jsp:include page="nav.jsp"/>
    <title>${spice.name}</title>
</head>


<!--MAIN HTML-->
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

        <!--Product Selection-->
        <c:choose>

            <c:when test="${level == 'none' || level == 'basic' || level == 'novice'}">
                <!--NON-MEMBERS, BASIC & NOVICE MEMBERS CAN ONLY CHOOSE WEIGHTS FROM A SELECTION-->

                <!-- Weight Selection -->
                <div class="type-config">
                    <div class="type-choose">
                        <span>Select Weight</span>
                        <button class="quantity" onmousedown="flashImperial()" onmouseup="stayMetric()">See in
                            Imperial
                        </button>
                        <br>
                        <button id="b-25" class="quantity" onclick="manageWeight(0, 25)">25g</button>
                        <button id="b-50" class="quantity" onclick="manageWeight(0, 50)">50g</button>
                        <button id="b-100" class="quantity" onclick="manageWeight(0, 100)">100g</button>
                        <button id="b-250" class="quantity" onclick="manageWeight(0, 250)">250g</button>
                        <button id="b-500" class="quantity" onclick="manageWeight(0, 500)">500g</button>
                    </div>
                </div>

                <!--Hidden Form for Server-Side-->
                <div class="quantity-config">
                    <div class="type">
                        <form:form id="form" action="addItemMetric" modelAttribute="itemMetric">
                            <form:hidden path="spice" value="${spice.name}"/>
                            <form:hidden id="input-large" class="unit_input" path="kilograms"/>
                            <form:hidden id="input-small" class="unit_input" path="grams"/>

                            <!--Quantity-->
                            <span>Select Quantity</span>
                            <div class="type-choose">
                                <button class="btn btn-default btn-subtract" onclick="decrement()" type="button">-
                                </button>
                                <form:input class="unit_input" id="quantity" path="quantity" value="1"
                                            onkeyup="value=value.replace(/^./g,'')" min="1" max="10" readonly="true"
                                            onfocus="this.blur()"/>
                                <button class="btn btn-default btn-add" onclick="increment()" type="button">+</button>
                            </div>

                            <div class="product-price">
                                <span><p id="price-">&pound${spice.price} per 100g</p></span>
                            </div>
                            <input type="submit" class="cart-btn" value="Add to Cart" id="submit" disabled>
                        </form:form>
                    </div>
                </div>
            </c:when>


            <c:when test="${level == 'expert'}">
                <!--EXPERT USER HAS ACCESS TO THE FORM DIRECTLY-->

                <!-- Weight Selection -->
                <div class="quantity-config">
                    <div class="type">
                        <span>Select Weight</span>

                        <!--form action and model attribute will change onclick via js-->
                        <form:form id="form" action="addItemMetric" modelAttribute="itemMetric">
                            <form:hidden path="spice" value="${spice.name}"/>

                            <!--kilograms/stones input depending on if button clicked-->
                            <form:input id="input-large" class="unit_input" path="kilograms" type="number" min="0"
                                        onkeyup="value=value.replace('-','')"/>
                            <form:label id="label-large" path="kilograms">kg</form:label>

                            <!--grams/stones input depending on if button clicked-->
                            <form:input id="input-small" class="unit_input" path="grams" type="number" min="0" max="999"
                                        onkeyup="value=value.replace('-','')"/>
                            <form:label id="label-small" path="grams">g</form:label>

                            <button id="units" type="button" onclick="unitSwitch()">Switch to Imperial Units</button>

                            <div class="type-choose">
                                <button class="btn btn-default btn-subtract" onclick="decrement()" type="button">-
                                </button>
                                <form:input class="quantity unit_input" id="quantity" path="quantity" value="1"
                                            onkeyup="value=value.replace(/^./g,'')" min="1" max="10" readonly="true"
                                            onfocus="this.blur()"/>
                                <button class="btn btn-default btn-add" onclick="increment()" type="button">+</button>
                            </div>

                            <div class="product-price">
                                <span><p id="price-">&pound${spice.price} per 100g</p></span>
                            </div>
                            <input type="submit" class="cart-btn" value="Add to Cart" id="submit" disabled>

                        </form:form>
                    </div>
                </div>
            </c:when>
        </c:choose>


    </div>
</main>

<!--Temporary Placeholder Recipes (Hardcoded)-->
<h2 style="text-align:center;">Related Recipes</h2>
<div class="recipe">
    <div>
        <img src="https://selfproclaimedfoodie.com/wp-content/uploads/new-york-strip-steak-square-3.jpg"
             alt="Black pepper" width="304" height="236">
        <p> Angus Steak</p>
    </div>
    <div>
        <img src="https://www.connoisseurusveg.com/wp-content/uploads/2017/04/black-pepper-tofu.jpg" alt="Black pepper"
             width="304" height="236">
        <p>Black Pepper Tofu</p>
    </div>

    <div>
        <img src="https://huntercattle.com/wp-content/uploads/2020/11/istockphoto-541851706-612x612-1.jpg"
             alt="Black pepper" width="304" height="236">
        <p>Sirloin Steak</p>
    </div>
</div>

<!--JAVASCRIPT-->
<script>
    /**
     * Initialisation of page
     */
    let metric = false;

    var level = '${level}';

    if (level == 'none' || level == 'basic') { //hide buttons for both non-members and basic members
        var weights = document.querySelectorAll('#b-100, #b-250, #b-500');
        weights.forEach((weight) => {
            weight.style.display = 'none';
        })
    }
    var inputElements = document.querySelectorAll('#input-small, #input-large');


    inputElements.forEach(el => {
        ['keyup', 'mouseup'].forEach(event => {
            el.addEventListener(event, manageWeightWrapper, false);
        })
    })

    /**
     * Deals with changing item form
     */
    function unitSwitch() {
        if (!metric) { //if at imperial units (pounds and ounces)
            metric = true;
            document.getElementById("units").innerHTML = "Switch to Metric Units";

            document.getElementById("form").action = "addItemImperial";
            document.getElementById("form").modelAttribute = "itemImperial";

            document.getElementById("input-large").setAttribute('path', 'pounds');
            document.getElementById("input-small").setAttribute('path', 'ounces');
            document.getElementById("input-large").setAttribute('name', 'pounds');
            document.getElementById("input-small").setAttribute('name', 'ounces');

            document.getElementById("label-large").innerHTML = "lb";
            document.getElementById("label-small").innerHTML = "oz.";
            manageWeightWrapper();
        } else if (metric) { //if at metric units (kilograms and grams)
            metric = false;
            document.getElementById("units").innerHTML = "Switch to Imperial Units";

            document.getElementById("form").action = "addItemMetric";
            document.getElementById("form").modelAttribute = "itemMetric";

            document.getElementById("input-large").setAttribute('path', "kilograms");
            document.getElementById("input-small").setAttribute('path', "grams");
            document.getElementById("input-large").setAttribute('name', 'kilgrams');
            document.getElementById("input-small").setAttribute('name', 'grams');

            document.getElementById("label-large").innerHTML = "kg";
            document.getElementById("label-small").innerHTML = "g";
            manageWeightWrapper();
        }
    }

    /**
     * Increases quantity of product by 1
     */
    function increment() {
        var quantity = Number(document.getElementById("quantity").value);
        if (quantity == 10) return 0;

        document.getElementById("quantity").value = Number(document.getElementById("quantity").value) + 1;
        var small = fetchInputSmall();
        var large = fetchInputLarge();
        if (large > 0 || small > 0) manageWeight(large, small);
    }

    /**
     * Decreases quantity of product by 1
     */
    function decrement() {
        var quantity = Number(document.getElementById("quantity").value);
        if (quantity == 1) return 0;

        document.getElementById("quantity").value = Number(document.getElementById("quantity").value) - 1;
        var small = fetchInputSmall();
        var large = fetchInputLarge();
        if (large > 0 || small > 0) manageWeight(large, small);
    }

    /**
     * Manages users chosen weight and dynamically prints price
     * @param {Number} smallWeight The small weight (e.g grams) of the chosen product
     * @param {Number} largeWeight The large weight (e.g kilograms) of the chosen product
     */
    function manageWeight(largeWeight, smallWeight) {
        var unit = document.getElementById("input-small").getAttribute("name");
        var quantity = Number(document.getElementById("quantity").value);
        var rate = '${spice.price}';

        document.getElementById("input-large").value = largeWeight;
        document.getElementById("input-small").value = smallWeight;

        if (!allowAndCheckSubmition(smallWeight + largeWeight)) return; //don't show price if submition isn't yet allowed (i.e input=0)


        showUnitPrice(smallWeight, largeWeight, rate, unit);
        computeAndShowPrice(smallWeight, largeWeight, quantity, rate, unit);
    }

    /**
     * Formats weights into default grams after mouse is unclicked
     */
    function stayMetric() {
        for (var i = 25; i <= 500; i *= 2) {
            if (i == 200) i += 50;
            document.getElementById("b-" + i).innerHTML = i + "g";
        }
    }

    /**
     * Formats weights into imperial whilst button is being pressed
     */
    function flashImperial() {
        for (var i = 25; i <= 500; i *= 2) {
            if (i == 200) i += 50;
            document.getElementById("b-" + i).innerHTML = (i / 28.35).toFixed(2)
                + "oz";
        }
    }

    /**
     * Undisables product submission form if weight is greater than 0
     */
    function allowAndCheckSubmition(weightPolarity) {
        if (weightPolarity > 0) {
            document.getElementById('submit').removeAttribute('disabled');
            return true;
        }

        document.getElementById('submit').setAttribute('disabled', 'disabled');
        var priceElement = document.getElementById("total-price");
        if (priceElement != null) priceElement.remove();
        return false;
    }

    /**
     * Manages computing total price and adding an element showing it
     * @param {Number} smallWeight The small weight of the chosen product
     * @param {Number} largeWeight The large weight of the chosen product
     * @param {Number} quantity The large weight of the chosen product
     * @param {Number} rate The price per 100g of spice
     * @param {Number} unit The chosen units of the user
     */
    function computeAndShowPrice(smallWeight, largeWeight, quantity, rate, unit) {
        if (unit == 'grams') { //i.e unit == 'metric'
            var pricePerUnit = (rate / 100) * (Number(smallWeight) + (Number(largeWeight) * 1000));

            var element = document.createElement("p");
            element.setAttribute("id", "total-price");
            document.getElementById("price-").appendChild(element);
            document.getElementById("total-price").innerHTML = "Total: &pound" +
                (quantity * pricePerUnit).toFixed(2);
        } else { //unit == 'imperial'
            var pricePerUnit = (rate / 100) *
                ((Number(largeWeight * 16) + Number(smallWeight)) * 28.3495);
            var element = document.createElement("p");

            element.setAttribute("id", "total-price");
            document.getElementById("price-").appendChild(element);
            document.getElementById("total-price").innerHTML = "Total: &pound" +
                (quantity * pricePerUnit).toFixed(2);

        }
    }

    /**
     *
     */
    function showUnitPrice(smallWeight, largeWeight, rate, unit) {
        if (unit == 'grams') {
            var pricePerUnit = (rate / 100) * (Number(smallWeight) + (Number(largeWeight) * 1000));
            if (largeWeight == 0) {
                document.getElementById("price-").innerHTML = "&pound" +
                    pricePerUnit.toFixed(2) +
                    " <span> per " + smallWeight +
                    "g jar</span>";
            } else {
                document.getElementById("price-").innerHTML = "&pound" +
                    pricePerUnit.toFixed(2) +
                    " <span> per " + largeWeight + "kg " +
                    smallWeight + "g unit</span>";
            }
        } else { //unit == imperial
            var pricePerUnit = (rate / 100) *
                ((Number(largeWeight * 16) + Number(smallWeight)) * 28.3495);
            if (largeWeight == 0) {
                document.getElementById("price-").innerHTML = "&pound" +
                    pricePerUnit.toFixed(2) +
                    " <span> per " + smallWeight +
                    "oz. jar</span>";
            } else {
                document.getElementById("price-").innerHTML = "&pound" +
                    pricePerUnit.toFixed(2) +
                    " <span> per " + largeWeight + "lb " +
                    smallWeight + "oz. unit </span>";
            }
        }
    }

    function manageWeightWrapper() {
        var small = fetchInputSmall();
        var large = fetchInputLarge();

        manageWeight(large, small);
    }

    function fetchInputSmall() {
        return document.getElementById("input-small").value;
    }

    function fetchInputLarge() {
        return document.getElementById("input-large").value;
    }


</script>
</body>
</html>