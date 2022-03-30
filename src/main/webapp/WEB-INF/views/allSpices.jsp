<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ page pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <script src="https://kit.fontawesome.com/2f306254e3.js" crossorigin="anonymous"></script>
    
    <style>
        .card {
            box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2);
            max-width: 370px;
            margin-top: 20px;
            margin-left: 20px;
            margin-right: 20px;
            margin-bottom: 20px;
            text-align: center;
            font-family:"Monserrat", sans-serif;
            flex: 0 1 33%;
            padding: 0 10px;
            float: left;
            width: 33.33%;

        }
        
        h1{
        	font-weight: 900px;
        }
        


        .cards {
            display: flex;
            flex-wrap: wrap;
            justify-content: space-between;

        }


        .price {
            color: rgb(255 140 32);
            font-size: 22px;
            font-weight: 900;
        }

        .card button {
            border: none;
            outline: 0;
            padding: 12px;
            color: white;
            background-color: #ff8c21;
            text-align: center;
            cursor: pointer;
            width: 100%;
            font-size: 18px;
            border-radius: 10px

        }

        .card button:hover {
            opacity: 9.0;

        }

        .card button:active {
            background-color: #fe7b00;
            box-shadow: 0 5px;
            transform: translateY(4px);
        }

        * {
            box-sizing: border-box;
        }

        .row {
            display: flex;
            flex-wrap: wrap;
            width: 100%;
            justify-content: space-between;

        }

        .center {
            text-align: center;
        }

        .pagination {
            display: inline-block;

        }

        .pagination a {
            color: rgb(252, 167, 111);
            float: left;
            padding: 8px 16px;
            text-decoration: none;
            transition: background-color .3s;
            border: 1px solid rgb(248, 191, 152);
            background: white;

            margin: 0 4px;
        }

        .pagination a.active {
            background-color: rgb(252, 168, 90);
            color: white;;
        }

		a{
			text-decoration: none;
			
		}
        .pagination a:hover:not(.active) {
            background-color: rgb(248, 191, 152);
        }

        .vertical-menu .cata button:active {
            border: 2px solid #F28123;
            background-color: #F28123;
            color: #fff;
        }

        .vertical-menu .cata button {
            display: inline-block;
            font-weight: 700;
            font-size: 18px;
            margin: 15px;
            border: 2px solid #FB9350;
            cursor: pointer;
            padding: 8px 20px;
            border-radius: 25px;
            text-align: center;
            background-color: #FB9350;
            color: #fff;

        }

        body {
            background-color: #f9efe6;
            font-family:"Monserrat", sans-serif;
            padding: 0;
            margin: 0;
        }

        h2 {
            text-align: center;
            font-weight: 900px;
            font-size: 40px;


            font-family:"Monserrat", sans-serif;

            color: #321800;
        }

        .select {
            float: right;
            margin-right: 30px;

        }

        * {
            outline: none;
        }


        .pic {
            align-items: center;
            justify-content: center;
            display: flex;
            width: 100%;
         	height: 400px;
            background-image: linear-gradient(rgba(0, 0, 0, 0.6), rgba(0, 0, 0, 0.6)), url("../../images/spice_hero.png");

        }


		
        form .search {
            position: relative;
            display: flex;
        }

        form .searchTerm {
            border: 4px solid white;
            border-right: none;
            border-top: none;
            border-left: none;
            padding: 5px;
            height: 45px;
            border-radius: 5px 0 0 5px;
            outline: none;
            color: #ffffff;
            background: transparent;
        }
        
     


        form .searchTerm:focus {
            color: white;

        }

        ::placeholder {
            color: white;
            font-family:"Monserrat", sans-serif;
            font-size: 30px;

        }

        form .searchButton {
            width: 40px;
            height: 46px;
            border: transparent;
            background: transparent;
            text-align: center;
            color: #fff;
            border-radius: 0 10px 10px 0;
            cursor: pointer;
            font-size: 30px;


        }

        form input.searchTerm {
            font-size: 35px;
            font-family:"Monserrat", sans-serif;
            padding: 10px;
            
        }
        
   

        .box {
           width: 1300px;
   			margin-inline: auto;
            
        }
        
        .select{
        	color:black;
        	width: 21%;
        }


    </style>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <jsp:include page="nav.jsp"/>
    <title>Spices</title>

</head>

<body>


<div id="back">

		<div class="pic">

		<form action="/spicesearch" class="searchform" method="GET">
		    <input name="spice" type="text" class="searchTerm" placeholder="What are you looking for?">
      		<button type="submit" class="searchButton">
				<i class="fa-solid fa-magnifying-glass"></i>
     		</button>
        </div>

		</form>

		</div>
	</div>


<h2>Products</h2>


<div class="vertical-menu" style="text-align: center">

    <a href="/spices" class="cata">
        <button>All</button>
    </a>
    <a href="/spices?sort=spiceBlends" class="cata">
        <button>Spice Blends</button>
    </a>
    <a href="/spices?sort=peppers" class="cata">
        <button>Peppers</button>
    </a>
    <a href="/spices?sort=salts" class="cata">
        <button>Salts</button>
    </a>
</div>

<form name="sortby" class="select">
    <label for="sorting">Sort By:</label>
    <select name="sort" id="sort">
        <option selected disabled>${path}</option>
        <option id="sort_a-z" value="/spices?sort=a-z">A-Z</option>
        <option id="sort_z-a" value="/spices?sort=z-a">Z-A</option>
        <option id="sort_asc" value="/spices?sort=price_asc">Price Ascending</option>
        <option id="sort_dec" value="/spices?sort=price_dsc">Price Descending</option>
    </select>

</form>


<script>
    var sortmenu = document.getElementById('sort');
    sortmenu.onchange = function () {
        window.open(this.options[this.selectedIndex].value, "_self");
    };

</script>

<div class="box">
<div class="row">

    <c:forEach items="${spices}" var="spice">
        <div class="card">
                <a href="/spice?spice=${spice.name}">
                <img src="${spice.getPicture()}" alt="${spice.getName()}" width="500"
                                                      height="300" style="width:100%">
            </a>
            <h1> ${spice.getName()}</h1>
            <p> Category: ${spice.getCategory()}</p>
            <c:choose>
                <c:when test="${isMember}">
                    <p class="price" style="text-decoration: line-through; color: black; font-size:17px;"><fmt:formatNumber type="currency" currencySymbol="£" maxFractionDigits="2"
                                                       minFractionDigits="2">${spice.getPrice()}</fmt:formatNumber>
                        per 100g</p>
                    <p class="price">Now: <fmt:formatNumber type="currency" currencySymbol="£" maxFractionDigits="2"
                                                       minFractionDigits="2">${spice.getUserPrice()}</fmt:formatNumber>
                        per 100g</p>
                </c:when>
                <c:otherwise>
                    <p class="price" style="font-size:17px;">Member Price: <fmt:formatNumber type="currency" currencySymbol="£" maxFractionDigits="2"
                                                                   minFractionDigits="2">${spice.getUserPrice()}</fmt:formatNumber>
                        per 100g</p>
                    <p class="price">Price: <fmt:formatNumber type="currency" currencySymbol="£" maxFractionDigits="2"
                                                                         minFractionDigits="2">${spice.getPrice()}</fmt:formatNumber>
                        per 100g</p>

                </c:otherwise>
            </c:choose>
            <p>${spice.description}</p>
            <p>
                <a href="/spice?spice=${spice.name}"><button>View Details</button></a>
            </p>
        </div>
    </c:forEach>
</div>
</div>
<div class="center">
    <div class="pagination">
        <a href="#">&laquo;</a>
        <a href="#" class="active">1</a>
        <a href="#">2</a>
        <a href="#">3</a>
        <a href="#">4</a>
        <a href="#">5</a>
        <a href="#">6</a>
        <a href="#">&raquo;</a>
    </div>
</div>

</body>
</html>