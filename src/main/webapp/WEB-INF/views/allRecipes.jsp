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
            font-family: arial;
            flex: 0 1 33%;
            padding: 0 10px;
            float: left;
            width: 33.33%;

        }

        .cards {
            display: flex;
            flex-wrap: wrap;
            justify-content: space-between;

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
            background-color: #fae3cc;
            font-family: arial;
            padding: 0;
            margin: 0;
        }

        h2 {
            text-align: center;
            font-weight: 900px;
            font-size: 40px;


            font-family: arial;

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
            background-image: linear-gradient(rgba(0, 0, 0, 0.6), rgba(0, 0, 0, 0.6)), url("../../images/recipeback.png");


        }


        form .search {
            width: 100%;
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
            font-family: arial;
            font-size: 30px;

        }
  
        a{
			text-decoration: none;
			
		}
		
		
        .select{
        	color:black;
        	width: 20%;
        }
        
        #sort{
        	width:100px;
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
            font-family: arial;
            padding: 10px;
        }

        .box {


            padding-right: 15px;
            padding-left: 15px;
            margin-right: auto;
            margin-left: auto;
            width: 1300px;

            display: flex;

        }



    </style>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <jsp:include page="nav.jsp"/>
    <title>Recipes</title>

</head>
<body>


<div id="back">

    <div class="pic">

    <form action="/recipesearch" class="searchform" method="GET">
        <input name="recipe" type="text" class="searchTerm" placeholder="What are you looking for?">
          <button type="submit" class="searchButton">
            <i class="fa-solid fa-magnifying-glass"></i>
         </button>
    </div>

    </form>

    </div>
</div>


<h2>Categories</h2>
<div class="vertical-menu" style="text-align: center">

    <a href="/recipes" class="cata" >
        <button >All</button>
    </a>
        
    <a href="/recipes/Breakfast" class="cata">
        <button>Breakfast</button>
    </a>
    <a href="/recipes/Lunch" class="cata">
        <button>Lunch</button>
    </a>
    <a href="/recipes/Dinner" class="cata">
        <button>Dinner</button>
    </a>
    <a href="/recipes/Cakes_and_Pies" class="cata">
        <button>Cakes and Pies</button>
    </a>
    <a href="/recipes/Pastries" class="cata">
        <button>Pastries</button>
    </a>
</div>


<form name="sortby" class="select">
    <label for="sorting">Sort By:</label>
    <select name="sort" id="sort">
        <option id ="fixed_sort"selected disabled>Select</option>        
        <option id="sort_a-z" value="/recipes/a-z">A-Z</option>
        <option id="sort_z-a" value="/recipes/z-a">Z-A</option>
    
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
    
    <c:forEach items="${recipes}" var="recipe">
        <div class="card">
            <a href="/recipe?recipe=${recipe.name}"><img src="${recipe.getPicture()}" alt="${recipe.getName()}" width="500"
                                                          height="300" style="width:100%"></a>
            <h1> ${recipe.getName()}</h1>
            <p> Category: ${recipe.getCategory()}</p>
            <p>${recipe.description}</p>
            <p>
                <a href="/recipe?recipe=${recipe.name}"><button>View Details</button></a>
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